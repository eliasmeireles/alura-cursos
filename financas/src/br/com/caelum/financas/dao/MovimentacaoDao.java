package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.JPAUTIL.JPAUtil;
import br.com.caelum.financas.model.Movimentacao;

public class MovimentacaoDao {

	public List<Movimentacao> localizaMovimentacoes() {

		TypedQuery<Movimentacao> query = manager().createQuery(("from Movimentacao"), Movimentacao.class);

		return query.getResultList();
	}

	public List<Movimentacao> localizaMovimentacao(Integer id) {

		TypedQuery<Movimentacao> query = manager().createQuery(("from Movimentacao m where conta_id = :pId"),
				Movimentacao.class);

		query.setParameter("pId", id);

		return query.getResultList();
	}

	public List<Movimentacao> localizaMovimentacaoPorTitular(String titular) {

		TypedQuery<Movimentacao> query = manager()
				.createQuery(("from Movimentacao m where m.conta.titular = :pTitular"), Movimentacao.class);

		query.setParameter("pTitular", titular);

		return query.getResultList();
	}

	public static EntityManager manager() {
		EntityManager manager = JPAUtil.getEntityManager();
		return manager;
	}
}
