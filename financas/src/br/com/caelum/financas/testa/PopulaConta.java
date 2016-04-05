package br.com.caelum.financas.testa;

import br.com.caelum.financas.dao.Dao;
import br.com.caelum.financas.model.Conta;

public class PopulaConta {
	public static void main(String[] args) {
		Conta[] conta = new Conta[5];
		
		conta[0] = new Conta();
		conta[0].setBanco("001 - BANCO DO BRASIL");
		conta[0].setNumero("16987-8");
		conta[0].setAgencia("6543");
		conta[0].setTitular("Maria dos Santos");

		conta[1] = new Conta();
		conta[1].setBanco("237 - BANCO BRADESCO");
		conta[1].setNumero("86759-1");
		conta[1].setAgencia("1745");
		conta[1].setTitular("Paulo Roberto Souza");

		conta[2] = new Conta();
		conta[2].setBanco("341 - BANCO ITAU UNIBANCO");
		conta[2].setNumero("46346-3");
		conta[2].setAgencia("4606");
		conta[2].setTitular("Antonio Duraes");

		conta[3] = new Conta();
		conta[3].setBanco("033 - BANCO SANTANDER");
		conta[3].setNumero("12345-6");
		conta[3].setAgencia("9876");
		conta[3].setTitular("Leandra Marques");

		conta[4] = new Conta();
		conta[4].setBanco("104 - CAIXA ECONOMICA FEDERAL");
		conta[4].setNumero("98654-3");
		conta[4].setAgencia("1234");
		conta[4].setTitular("Alexandre Duarte");
		
		for (Conta contas : conta) {
			new Dao().persistenceManager(contas);
		}

	}
}
