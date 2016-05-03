package br.com.caelum.leilao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;


public class TestaAvaliador {
	private Avaliador leiloeiro;
	private Usuario maria;
	private Usuario jose;
	private Usuario joao;
	private Usuario rodrigo;
	private Usuario mauricio;
	private Usuario roberta;
	private Usuario ronaldo;
	private Usuario renato;
	
	@BeforeClass
	public static void testandoBeforeClass() {
	  System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
	  System.out.println("after class");
	}

	@Before
    public void criaAvaliador() {
        this.leiloeiro = new Avaliador();
        joao = new Usuario("João");
        jose = new Usuario("jose");
        maria = new Usuario("Maria");
        renato = new Usuario("Renato");
		ronaldo = new Usuario("Ronaldo");
		roberta = new Usuario("Roberto");
		mauricio = new Usuario("Mauricio");
		rodrigo = new Usuario("Rodrigo");
    }
	
	/*@After
	public void finaliza() {
	  System.out.println("fim");
	}*/
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 300.0)
				.lance(jose, 400.0)
				.lance(maria, 250.0)
				.constroi();
		
		leiloeiro.avalia(leilao);
	
		assertEquals(400.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(250.0, leiloeiro.getMenorLance(), 0.00001);
	}
	@Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Leilao leilao = new CriadorDeLeilao()
        		.para("Playstation 3 Novo")
        		.lance(joao, 200.0)
        		
        		.constroi();

        leiloeiro.avalia(leilao);

        assertThat(leiloeiro.getMenorLance(), equalTo(200.0));
    }
	
	@Test
	public void deveEntenderLancesEmOrdemAleatoria() {

		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.lance(ronaldo, 700.0)
				.lance(renato, 630.0)
				.lance(mauricio, 625.0)
				.lance(jose, 450.0)
				.lance(rodrigo, 379.0)
				.lance(roberta, 230.0)
				.lance(joao, 200.0)
				.lance(maria, 120.0)
				.constroi();

		criaAvaliador();
		
		
		leiloeiro.avalia(leilao);
		
		assertEquals(700.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(120.0, leiloeiro.getMenorLance(), 0.00001);
	}
	@Test
	public void deveEntenderLancesEmOrdemDecrescente() {
		
		
		
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation 3 Novo")
				.lance(ronaldo, 700.0)
				.lance(renato, 630.0)
				.lance(mauricio, 625.0)
				.lance(jose, 450.0)
				.lance(rodrigo, 379.0)
				.lance(roberta, 230.0)
				.lance(joao, 200.0)
				.lance(maria, 120.0)
				.constroi();

		criaAvaliador();
		
		
		leiloeiro.avalia(leilao);

		List<Lance> tresMaiores = leiloeiro.getTresMaiores();
		
		
		assertEquals(700.0, tresMaiores.get(0).getValor(), 0.00001);
        assertEquals(630.0, tresMaiores.get(1).getValor(), 0.00001);
        assertEquals(625.0, tresMaiores.get(2).getValor(), 0.00001);
	}
	
	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
	    Leilao leilao = new CriadorDeLeilao()
	        .para("Playstation 3 Novo")
	        .constroi();

	    leiloeiro.avalia(leilao);
	}
	
}

