package br.com.caelum.xstream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class CompraTest {

	@Test
	public void deveSerializarCadaUmDosProdutosDeUmaCompra() {

		String resultadoEsperado = "<compra>\n" 
				+ "  <id>15</id>\n" + "  <produtos>\n"
				+ "    <produto codigo=\"1587\">\n" 
				+ "      <nome>geladeira</nome>\n" 
				+ "      <preco>1000.0</preco>\n"
				+ "      <descrição>geladeira duas portas</descrição>\n"
				+ "    </produto>\n"
				+ "    <produto codigo=\"1588\">\n"
				+ "      <nome>ferro de passar</nome>\n"
				+ "      <preco>100.0</preco>\n"
				+ "      <descrição>ferro com vaporizador</descrição>\n"
				+ "    </produto>\n"
				+ "  </produtos>\n"
				+ "</compra>";

		Produto geladeira = geladeira();

		Produto ferro = ferro();

		Compra compra = compraGeladeiraEFerro(geladeira, ferro);

		XStream xstream = xstreamParaCompraEProduto();

		String xmlGerado = xstream.toXML(compra);

		assertEquals(resultadoEsperado, xmlGerado);

	}
	
	@Test
	public void deveGerarUmaCompraComCadaUmDosProdutosDoXml() {

	    String xmlDeorigem = "<compra>\n"+
	       "  <id>15</id>\n"+
	       "  <produtos>\n"+
	       "    <produto codigo=\"1587\">\n"+
	       "      <nome>geladeira</nome>\n"+
	       "      <preco>1000.0</preco>\n"+
	       "      <descrição>geladeira duas portas</descrição>\n"+
	       "    </produto>\n"+
	       "    <produto codigo=\"1588\">\n"+
	       "      <nome>ferro de passar</nome>\n"+
	       "      <preco>100.0</preco>\n"+
	       "      <descrição>ferro com vaporizador</descrição>\n"+
	       "    </produto>\n"+
	       "  </produtos>\n"+
	       "</compra>";
	    
	    Produto geladeira = geladeira();
	    
	    Produto ferro = ferro(); 
	    
	    Compra compraEsperada = compraGeladeiraEFerro(geladeira, ferro);
	    
	    XStream xstream = xstreamParaCompraEProduto();
	    
	    Compra compraDeserializada = (Compra) xstream.fromXML(xmlDeorigem);
	    
	    assertEquals(compraEsperada, compraDeserializada);
	}
	
	
	@Test
	public void deveSerializarDuasGeladeirasIguais() {
	    String resultadoEsperado = "<compra>\n" 
	            + "  <id>15</id>\n"
	            + "  <produtos>\n" 
	            + "    <produto codigo=\"1587\">\n"
	            + "      <nome>geladeira</nome>\n"
	            + "      <preco>1000.0</preco>\n"
	            + "      <descrição>geladeira duas portas</descrição>\n"
	            + "    </produto>\n"
	            + "    <produto codigo=\"1587\">\n"
	            + "      <nome>geladeira</nome>\n"
	            + "      <preco>1000.0</preco>\n"
	            + "      <descrição>geladeira duas portas</descrição>\n"
	            + "    </produto>\n"
	            + "  </produtos>\n" 
	            + "</compra>";

	    Compra compra = compraDuasGeladeirasIguais();

	    XStream xstream = xstreamParaCompraEProduto();
	    xstream.setMode(XStream.NO_REFERENCES);
	    
	    String xmlGerado = xstream.toXML(compra);

	    assertEquals(resultadoEsperado, xmlGerado);
	}
	@Test
    public void deveSerializarColecaoImplicita() {
        String resultadoEsperado = "<compra>\n" 
                + "  <id>15</id>\n"
                + "  <produto codigo=\"1587\">\n"
                + "    <nome>geladeira</nome>\n"
                + "    <preco>1000.0</preco>\n"
                + "    <descrição>geladeira duas portas</descrição>\n"
                + "  </produto>\n" 
                + "  <produto codigo=\"1588\">\n"
                + "    <nome>ferro de passar</nome>\n"
                + "    <preco>100.0</preco>\n"
                + "    <descrição>ferro com vaporizador</descrição>\n"
                + "  </produto>\n"
                + "</compra>";

        Compra compra = compraGeladeiraEFerro(ferro(), geladeira());

        XStream xstream = xstreamParaCompraEProduto();
        xstream.addImplicitCollection(Compra.class, "produtos");

        String xmlGerado = xstream.toXML(compra);

        assertEquals(resultadoEsperado, xmlGerado);
    }
	
	private Compra compraDuasGeladeirasIguais() {
	    Produto geladeira = geladeira();

	    List<Produto> produtos = new ArrayList<Produto>();
	    produtos.add(geladeira);
	    produtos.add(geladeira);

	    Compra compra = new Compra(15, produtos);
	    return compra;
	}
	private XStream xstreamParaCompraEProduto() {
		XStream xstream = new XStream();

		xstream.alias("compra", Compra.class);
		xstream.alias("produto", Produto.class);
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		return xstream;
	}

	private Compra compraGeladeiraEFerro(Produto geladeira, Produto ferro) {
		List<Produto> produtos = new ArrayList<Produto>();

		produtos.add(geladeira);
		produtos.add(ferro);

		Compra compra = new Compra(15, produtos);
		return compra;
	}

	private Produto ferro() {
		return new Produto("ferro de passar", 100, "ferro com vaporizador", 1588);
	}

	private Produto geladeira() {
		return new Produto("geladeira", 1000, "geladeira duas portas", 1587);
	}

	
}
