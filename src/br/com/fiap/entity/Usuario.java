package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity	
@Table(name="TAB_USUARIO")
@SequenceGenerator(name="usuario", sequenceName="SQ_TAB_USUARIO", allocationSize = 1)
public class Usuario {
	
	@Id
	@Column(name="cod_usuario")
	@GeneratedValue(generator="usuario",strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nom_usuario")
	private String nome;
	
	@ManyToMany(mappedBy="usuarios", cascade=CascadeType.PERSIST)
	private List<ItemTeste> itens;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public Usuario(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemTeste> getItensTeste() {
		return itens;
	}

	public void setItensTeste(List<ItemTeste> itensTeste) {
		this.itens = itensTeste;
	}
	
	

}
