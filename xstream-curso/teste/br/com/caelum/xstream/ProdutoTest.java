package br.com.caelum.xstream;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class ProdutoTest {

	@Test
	public void deveGerarOXmlComONomePrecoEDescricaoAdequados() {
		
		String resultadoEsperado = "<produto codigo=\"1587\">\n" +
		        "  <nome>geladeira</nome>\n" +
		        "  <preco>1000.0</preco>\n" +
		        "  <descricao>geladeira duas portas</descricao>\n" +
		        "</produto>";
		
		Produto geladeira = new Produto("geladeira", 1000, "geladeira duas portas", 1587);
		
		
		XStream xstream = new XStream();
		xstream.alias("produto", Produto.class);
		
		xstream.aliasField("descrição", Produto.class, "descrição");
		
		xstream.useAttributeFor(Produto.class, "codigo");
		
		String xmlGerado = xstream.toXML(geladeira);
		
		
		assertEquals(resultadoEsperado, xmlGerado);
	
	}
}
