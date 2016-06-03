package br.com.caelum.calculaimposto.model;

public class TesteDeTemplate {
	public static void main(String[] args) {
		TemplateDeImpostoCondicional icpp = new ICPP();
		TemplateDeImpostoCondicional ikcv = new IKCV();
		TemplateDeImpostoCondicional ihit = new IHIT();
		
		Orcamento orcamento = new Orcamento(1000);
		Item caneta = new Item("Caneta", 120);
		orcamento.adiciona(caneta);
		orcamento.adiciona(caneta);
		
		System.out.println(icpp.calcula(orcamento));
		System.out.println(ikcv.calcula(orcamento));
		System.out.println(ihit.calcula(orcamento));
	}
}
