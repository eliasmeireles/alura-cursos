package br.com.caelum.leilao.infra.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class LeilaoDaoTest {
	
	
	@Test
	public void testandoOMetodoTesteDoLeilaoDao() {
		LeilaoDao leilaoDao = mock(LeilaoDao.class);

		assertEquals("teste", LeilaoDao.teste());
		
		
	}
}
