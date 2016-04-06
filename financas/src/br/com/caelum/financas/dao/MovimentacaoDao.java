package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.JPAUTIL.JPAUtil;
import br.com.caelum.financas.model.Movimentacao;

public class MovimentacaoDao {

	public List<Movimentacao> localizaMovimentacoes() {

		TypedQuery<Movimentacao> query = manager().createQuery(("from Movimentacao"), Movimentacao.class);

		return queryResult(query);
	}

	public List<Movimentacao> localizaMovimentacao(Integer id) {

		TypedQuery<Movimentacao> query = manager().createQuery(("from Movimentacao m where conta_id = :mId"),
				Movimentacao.class);

		query.setParameter("mId", id);

		return queryResult(query);
	}

	public List<Movimentacao> localizaMovimentacaoPorTitular(String titular) {

		TypedQuery<Movimentacao> query = manager()
				.createQuery(("from Movimentacao m where m.conta.titular = :cTitular"), Movimentacao.class);

		query.setParameter("cTitular", titular);

		return queryResult(query);
	}

	private List<Movimentacao> queryResult(TypedQuery<Movimentacao> query) {
		List<Movimentacao> movimentacoes = query.getResultList();

		manager().close();

		return movimentacoes;
	}

	public static EntityManager manager() {
		EntityManager manager = new JPAUtil().getEntityManager();
		return manager;
	}
}
