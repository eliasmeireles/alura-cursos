package br.com.caelum.calculaimposto.model;

public class CalculadorDeImpostos {
	public void realaizaCalculo(Orcamento orcamento, Imposto imposto) {
		double valor = imposto.calcula(orcamento);
		System.out.println(valor);
	}
}
