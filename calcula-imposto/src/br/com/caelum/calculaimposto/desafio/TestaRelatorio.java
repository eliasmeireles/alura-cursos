package br.com.caelum.calculaimposto.desafio;

import java.util.ArrayList;
import java.util.List;

public class TestaRelatorio {
	public static void main(String[] args) {
		Relatorio relatorioComplexo = new RelatorioComplexo();
		Conta conta1 = new Conta();
		conta1.deposita(24500);
		conta1.setNome("Roberto Santos");
		
		Conta conta2 = new Conta();
		conta2.setNome("Elias");
		conta2.deposita(3500.0);
		
		
		List<Conta> contas = new ArrayList<>();
		contas.add(conta1);
		contas.add(conta2);
		
		relatorioComplexo.imprime(contas);
	}
	
}
