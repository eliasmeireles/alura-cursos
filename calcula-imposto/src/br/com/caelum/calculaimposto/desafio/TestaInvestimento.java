package br.com.caelum.calculaimposto.desafio;

public class TestaInvestimento {

	public static void main(String[] args) {
		Investimento arrojado = new Arrojado();
		Conta conta = new Conta();
		conta.deposita(3000.0);
		
		
		RealizadorDeInvestimentos investimentos = new RealizadorDeInvestimentos();
		
		investimentos.realiza(conta, arrojado);
	}

}
