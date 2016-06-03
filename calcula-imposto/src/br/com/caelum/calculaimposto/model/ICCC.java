package br.com.caelum.calculaimposto.model;

public class ICCC extends Imposto {

	public ICCC(Imposto outroImposto) {
		super(outroImposto);
	}
	
	public ICCC() {
		
	}

	@Override
	public double calcula(Orcamento orcamento) {
		double valorDoOrcamento = orcamento.getValor();
		double valor = 0;
		
		if (valorDoOrcamento < 1000.0) {
			valor = valorDoOrcamento * 0.05;
		} else if (valorDoOrcamento <= 3000.0) {
			valor = valorDoOrcamento * 0.7;
		} else {
			valor = (valorDoOrcamento * 0.08) + 30;
		}
		
		return valor;
	}

}
