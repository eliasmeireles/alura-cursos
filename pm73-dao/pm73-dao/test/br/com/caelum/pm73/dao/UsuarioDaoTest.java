package br.com.caelum.pm73.dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dominio.Usuario;

public class UsuarioDaoTest {

	private Session session;
	private UsuarioDao usuarioDao;

	@Before
	public void before() {
		session = new CriadorDeSessao().getSession();
		usuarioDao = new UsuarioDao(session);
		session.beginTransaction();
	}
	@After
	public void after() {
		session.getTransaction().rollback();
		session.close();
	}

	@Test
	public void deveEncotrarUsuarioaPorEmail() {

		Usuario usuario = new Usuario("João da Silva", "joao@dasilva.com.br");
		usuarioDao.salvar(usuario);

		Usuario usuarioBanco = usuarioDao.porNomeEEmail("João da Silva", "joao@dasilva.com.br");

		assertEquals("João da Silva", usuarioBanco.getNome());
		assertEquals("joao@dasilva.com.br", usuarioBanco.getEmail());
	}

	@Test
	public void deveRetornarUmUsuarioNulo() {
		Usuario usuarioBanco = usuarioDao.porNomeEEmail("Maria", "maria@gmail.com");

		assertNull(usuarioBanco);
	}
	@Test
    public void deveDeletarUmUsuario() {
        Usuario usuario = 
                new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

        usuarioDao.salvar(usuario);
        usuarioDao.deletar(usuario);

        session.flush();

        Usuario usuarioNoBanco = 
                usuarioDao.porNomeEEmail("Mauricio Aniche", "mauricio@aniche.com.br");

        assertNull(usuarioNoBanco);

    }
	 @Test
	    public void deveAlterarUmUsuario() {
	        Usuario usuario = 
	                new Usuario("Mauricio Aniche", "mauricio@aniche.com.br");

	        usuarioDao.salvar(usuario);

	        usuario.setNome("João da Silva");
	        usuario.setEmail("joao@silva.com.br");

	        usuarioDao.atualizar(usuario);

	        session.flush();

	        Usuario novoUsuario = 
	                usuarioDao.porNomeEEmail("João da Silva", "joao@silva.com.br");
	        assertNotNull(novoUsuario);
	        System.out.println(novoUsuario);

	        Usuario usuarioInexistente = 
	                usuarioDao.porNomeEEmail("Mauricio Aniche", "mauricio@aniche.com.br");
	        assertNull(usuarioInexistente);

	    }

}
