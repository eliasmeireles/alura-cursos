package br.com.caelum.calculaimposto.model;

public interface Desconto {
	double desconta(Orcamento orcamento);
	void setProximo(Desconto proximo);
}
