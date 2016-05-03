package br.com.caelum.leilao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {
	
	
	@Test
	public void naoPodeAceitarUsuarioComDoisLeiloesSeguidos() {
		
		Usuario renato = new Usuario("Renato");
		Leilao leilao = new CriadorDeLeilao()
				.para("TV led Sansugue 58 polegadas")
				.lance(renato, 2500)
				.constroi();

		assertEquals(1, leilao.getLances().size());
		assertEquals(2500.0, leilao.getLances().get(0).getValor(), 0.00001);
	}
	 @Test
	    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
			 Usuario steveJobs = new Usuario("Steve Jobs");
			 Usuario billGates = new Usuario("Bill Gates");
			 Leilao leilao = new CriadorDeLeilao()
	        		.para("Macbook Pro 15")
	        		.lance(steveJobs, 2000)
	        		.lance(billGates, 3000)
	        		.lance(steveJobs, 4000)
	        		.lance(billGates, 5000)
	        		.lance(steveJobs, 6000)
	        		.lance(billGates, 7000)
	        		.lance(steveJobs, 8000)
	        		.lance(billGates, 9000)
	        		.lance(steveJobs, 10000)
	        		.lance(billGates, 11000)
	        		.constroi();
	        		


	        // deve ser ignorado
	        leilao.propoe(new Lance(steveJobs, 12000));

	        assertEquals(10, leilao.getLances().size());
	        int ultimo = leilao.getLances().size() - 1;
	        Lance ultimoLance = leilao.getLances().get(ultimo);
	        assertEquals(11000.0, ultimoLance.getValor(), 0.00001);
	    }
	 
	 @Test
	 public void deveDobrarUltimoLandDoUsuarioSeSuaQuantidadeDeLancesForMenorQue5 (){
		 	Leilao leilao = new Leilao("Macbook Pro 15");
	        Usuario steveJobs = new Usuario("Steve Jobs");
	        Usuario billGates = new Usuario("Bill Gates");

	        leilao.propoe(new Lance(steveJobs, 10000));
	        leilao.propoe(new Lance(billGates, 11000));
	        leilao.propoe(new Lance(steveJobs, 22000));
	        leilao.propoe(new Lance(billGates, 23000));

	        // deve ser ignorado
	        leilao.propoe(new Lance(steveJobs, 12000));
	        leilao.propoeDobroDoUltimoLance(billGates);
	        leilao.propoeDobroDoUltimoLance(billGates);

	        assertEquals(6, leilao.getLances().size());
	        int ultimo = leilao.getLances().size() - 1;
	        Lance ultimoLance = leilao.getLances().get(ultimo);
	        assertEquals(46000.0, ultimoLance.getValor(), 0.00001);
	 }
}
