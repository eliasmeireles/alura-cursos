package br.com.caelum.calculaimposto.testes;

import br.com.caelum.calculaimposto.model.CalculadorDeImpostos;
import br.com.caelum.calculaimposto.model.ICCC;
import br.com.caelum.calculaimposto.model.ICMS;
import br.com.caelum.calculaimposto.model.ISS;
import br.com.caelum.calculaimposto.model.Imposto;
import br.com.caelum.calculaimposto.model.Orcamento;

public class TesteDeImpostos {
	public static void main(String[] args) {
		Imposto iss = new ISS();
		Imposto icms = new ICMS();
		Imposto iccc = new ICCC();
		
		Orcamento orcamento = new Orcamento(500);
		
		CalculadorDeImpostos calculadorDeImpostos = new CalculadorDeImpostos();
		calculadorDeImpostos.realaizaCalculo(orcamento, iss);
		calculadorDeImpostos.realaizaCalculo(orcamento, icms);
		calculadorDeImpostos.realaizaCalculo(orcamento, iccc);
	}
}
