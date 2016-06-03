package br.com.caelum.calculaimposto.model;

public class ICPP extends TemplateDeImpostoCondicional {

	public ICPP() {
		
	}
	
	public ICPP(Imposto outroImposto) {
		super(outroImposto);
	}
	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500.0;
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

}
