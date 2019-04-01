package br.com.fiap.teste;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.entity.CasoTeste;
import br.com.fiap.entity.ItemTeste;
import br.com.fiap.entity.Sistema;
import br.com.fiap.entity.Usuario;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TestDAO {
	
	private UsuarioDAO usuarioDao;
	
	private Usuario usuario;
	
	private static EntityManager em;
	
	@BeforeAll
	public static void init() {
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	}
	
	@org.junit.jupiter.api.Test
	public void cadastrar() {
		usuarioDao = new UsuarioDAOImpl(em);
		
		usuario = new Usuario("Usuario");
		
		ItemTeste item = new ItemTeste();
		item.setDescricao("Teste de stress");
		
		CasoTeste caso = new CasoTeste();
		caso.setNome("Caso de cadastro de usuario");
		
		Sistema sistema = new Sistema();
		sistema.setNome("Sistema Teste");
		

		
		
		
		
		List<ItemTeste> itens = new ArrayList<>();
		itens.add(item);
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario);
		
		item.setUsuarios(usuarios);
		item.setCasoTeste(caso);
		
		caso.setSistema(sistema);
		
		usuario.setItensTeste(itens);
		try {

			usuarioDao.create(usuario);
			usuarioDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Falha no teste");
		}	
		
	}

	

}
