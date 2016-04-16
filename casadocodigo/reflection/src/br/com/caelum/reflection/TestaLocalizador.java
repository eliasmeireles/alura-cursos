package br.com.caelum.reflection;

import java.util.List;

import org.junit.Test;

public class TestaLocalizador {
	public static void main(String[] args) {
		testador();
	}

	@Test
	private static void testador() {
		LocalizadorDeAtributos atributos = new  LocalizadorDeAtributos();
		Produtos produtos  = new Produtos();
		produtos.setEmail("email@.com");
		produtos.setNome("Nome qualquer");
		
		List<String> lista = atributos.buscaStringEmAtributos(produtos);
		System.out.println(lista);
	}
}
