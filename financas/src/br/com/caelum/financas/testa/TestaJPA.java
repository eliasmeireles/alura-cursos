package br.com.caelum.financas.testa;

import br.com.caelum.financas.dao.Dao;
import br.com.caelum.financas.model.Conta;

public class TestaJPA {
	public static void main(String[] args) {
		double inicio = System.currentTimeMillis();
		
	Conta conta = new Conta();
//		conta.setTitular("Joao Ferreira");
//        conta.setBanco("HSBC");
//        conta.setNumero("123345");
//        conta.setAgencia("321");
        
        Dao dao = new Dao();
        
        conta = (Conta) dao.findObject(conta, 3);
        
        System.out.println(conta.getTitular());
        System.out.println(conta.getNumero());
        System.out.println(conta.getBanco());
        System.out.println(conta.getAgencia());
        
        
        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
        
	}
}
