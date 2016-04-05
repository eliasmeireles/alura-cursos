package br.com.caelum.financas.testa;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.JPAUTIL.JPAUtil;
import br.com.caelum.financas.dao.Dao;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.model.TipoMovimentacao;

public class TestaRelacionamento {
	public static void main(String[] args) {
		Conta conta = new Conta();

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz");
		movimentacao.setTipoMovimetacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.9"));

		movimentacao.setConta(conta);

		Dao dao = new Dao();
		conta = (Conta) dao.findObject(conta, 1);
		
		System.out.println(conta.getId());
		
		
		dao.persistenceManager(conta);
		dao.persistenceManager(movimentacao);

	}
}
