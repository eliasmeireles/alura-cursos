package br.com.caelum.calculaimposto.model;

public class TestaImpostosMuitoAlto {
	public static void main(String[] args) {
		Imposto impostoAlto = new ImpostoMuitoAlto(new ISS());
	
		Orcamento orcamento = new Orcamento(500);
		double valor = impostoAlto.calcula(orcamento);
		
		System.out.println(valor);
	}
}
