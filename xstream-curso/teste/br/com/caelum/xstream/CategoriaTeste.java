package br.com.caelum.xstream;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.TreeMarshaller.CircularReferenceException;

public class CategoriaTeste {
	
	@Test
    public void deveSerializarUmCiclo() {
        Categoria esporte = criaCicloDeCategorias();

        XStream xstream = sxtremConf();

        String xmlEsperado = "<categoria id=\"1\">\n" +
                "  <pai id=\"2\">\n" +
                "    <pai id=\"3\">\n" +
                "      <pai reference=\"1\"/>\n" +
                "      <nome>futebol</nome>\n" +
                "    </pai>\n" +
                "    <nome>geral</nome>\n" +
                "  </pai>\n" +
                "  <nome>esporte</nome>\n" +
                "</categoria>";
        assertEquals(xmlEsperado, xstream.toXML(esporte));
    }
	
	@Test(expected=CircularReferenceException.class)
    public void naoDeveSerializarUmCicloSemReferencias() {
        Categoria esporte = criaCicloDeCategorias();

        XStream xstream = new XStream();
        
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.aliasType("categoria", Categoria.class);

        xstream.toXML(esporte);
    }

	private XStream sxtremConf() {
		XStream xstream = new XStream();
        xstream.setMode(XStream.ID_REFERENCES);
        xstream.aliasType("categoria", Categoria.class);
		return xstream;
	}

	private Categoria criaCicloDeCategorias() {
		Categoria esporte = new Categoria(null, "esporte");
        Categoria futebol = new Categoria(esporte, "futebol");
        Categoria geral = new Categoria(futebol, "geral");
        esporte.setPai(geral); // fechou o ciclo
		return esporte;
	}
	
	
}
