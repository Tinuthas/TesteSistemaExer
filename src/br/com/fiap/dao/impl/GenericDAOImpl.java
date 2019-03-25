package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	EntityManager em;
	
	private Class<T> clazz;
	
	
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
	}

	@Override
	public void create(T entity) {
		em.persist(entity);		
	}

	@Override
	public T read(K key) throws IdNotFoundException {
		T entity = em.find(clazz, key);
		if(entity == null) {
			throw new IdNotFoundException();
		}
		return entity;
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
		
	}

	@Override
	public void delete(K key) throws IdNotFoundException {
		T entity = read(key);
		em.remove(entity);
		
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
		
	}


}
