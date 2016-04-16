package br.com.caelum.xstream;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class CompraTestNovo {
	@Test
	public void deveSerializarLivroEMusica() {
		String resultadoEsperado = "<compra>\n" 
                + "  <id>15</id>\n"
                + "  <produtos class=\"linked-list\">\n" 
                + "    <livro codigo=\"1589\">\n"
                + "      <nome>O Pássaro Raro</nome>\n"
                + "      <preco>100.0</preco>\n"
                + "      <descrição>dez histórias sobre a existência</descrição>\n"
                + "    </livro>\n" 
                + "    <musica codigo=\"1590\">\n"
                + "      <nome>Meu Passeio</nome>\n"
                + "      <preco>100.0</preco>\n"
                + "      <descrição>música livre</descrição>\n"
                + "    </musica>\n"
                + "  </produtos>\n" 
                + "</compra>";
		
		Compra compra = compraComLivroEMusica();
		
		XStream xstream = xstreamParaCompraEProdutoMusicaELivro();
		
		String xmlGerado = xstream.toXML(compra);
		
		assertEquals(resultadoEsperado, xmlGerado);
		
	}
	
	private Compra compraComLivroEMusica() {
	    Produto livro = new Livro("O Pássaro Raro", 100.0, "dez histórias sobre a existência", 1589);
	    Produto musica = new Musica("Meu Passeio", 100.0, "Música livre", 1590);
	    List<Produto> compra = new LinkedList<>();
	    compra.add(livro);
	    compra.add(musica);

	    return new Compra(15, compra);
	}
	
	private XStream xstreamParaCompraEProdutoMusicaELivro() {
	    XStream xstream = new XStream();
	    xstream.alias("compra", Compra.class);
	    xstream.alias("produto", Produto.class);
	    xstream.alias("livro", Livro.class);
	    xstream.alias("musica", Musica.class);
	    xstream.aliasField("descrição", Produto.class, "descricao");
	    xstream.useAttributeFor(Produto.class, "codigo");
	    return xstream;
	}
}
