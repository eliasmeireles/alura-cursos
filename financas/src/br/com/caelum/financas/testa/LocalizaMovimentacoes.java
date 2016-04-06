package br.com.caelum.financas.testa;

import java.util.List;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.Movimentacao;

public class LocalizaMovimentacoes {
	
	public void movimentacao() {
		MovimentacaoDao dao = new MovimentacaoDao();
		
		List<Movimentacao> movimentacoes = dao.localizaMovimentacaoPorTitular("Leandra Marques");
		
		executaAcao(movimentacoes);

		System.out.println("====================================");
	}

	private static void executaAcao(List<Movimentacao> movimentacoes) {
		if (movimentacoes.size() > 0) {
			dadosDaMovimentacao(movimentacoes);
		} else {
			System.out.println("====================================");

			System.out.println("Não consta nenhuma movimentação do titular solicitado!");
		}
	}

	private static void dadosDaMovimentacao(List<Movimentacao> movimentacoes) {
		
		Conta conta;
		
		for (Movimentacao movimentacao : movimentacoes) {

			conta = movimentacao.getConta();

			System.out.println("====================================");
			System.out.println(conta.getTitular());
			System.out.println(movimentacao.getDescricao());
			System.out.println(movimentacao.getValor());
			System.out.println(movimentacao.getTipoMovimetacao());
		}
	}
}
