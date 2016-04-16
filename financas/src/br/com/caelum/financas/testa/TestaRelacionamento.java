package br.com.caelum.financas.testa;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.financas.dao.Dao;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.Movimentacao;
import br.com.caelum.financas.model.TipoMovimentacao;

public class TestaRelacionamento {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(4);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Agua");
		movimentacao.setTipoMovimetacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("124.50"));

		movimentacao.setConta(conta);

		Dao dao = new Dao();
		
		
		dao.insert(movimentacao);

	}
}
