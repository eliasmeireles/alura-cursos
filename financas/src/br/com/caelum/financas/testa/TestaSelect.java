package br.com.caelum.financas.testa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.JPAUTIL.JPAUtil;
import br.com.caelum.financas.model.Conta;
import br.com.caelum.financas.model.Movimentacao;

public class TestaSelect {
	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		TypedQuery<Conta> query = manager.createQuery("select c from Conta c join fetch c.movimentacoes", Conta.class);

		List<Conta> contas =  query.getResultList();
		
		manager.close();

		List<Movimentacao> movimentacaos = null;
		
		
		for (Conta conta : contas) {
			movimentacaos = conta.getMovimentacoes();
		}
		System.out.println(movimentacaos.size());
		for (Movimentacao movimentacao : movimentacaos) {
			System.out.println("=====================================");
			System.out.println(movimentacao.getConta().getTitular());
			System.out.println(movimentacao.getDescricao());
			System.out.println(movimentacao.getTipoMovimetacao());
			
		}

	}

}
