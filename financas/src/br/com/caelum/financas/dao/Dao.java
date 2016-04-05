package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.JPAUTIL.JPAUtil;
import br.com.caelum.financas.model.Conta;

public class Dao {

	public void persistenceManager(Object object) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		manager.persist(object);

		manager.getTransaction().commit();

		manager.close();
	}

	public Object findObject(Object object, Integer integer) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		object = manager.find(object.getClass(), integer);

		/* updateObjetoConta(object, integer, manager); */

		manager.getTransaction().commit();
		manager.close();

		return object;
	}

	/*
	 * private void updateObjetoConta(Object object, Integer integer,
	 * EntityManager manager) { Conta conta; conta = (Conta)
	 * manager.find(object.getClass(), integer);
	 * 
	 * System.out.println(conta.getTitular());
	 * 
	 * conta.setTitular("Caelum Ensino e Inovação");
	 * 
	 * manager.merge(conta); manager.getTransaction().commit();
	 * 
	 * manager.close();
	 * 
	 * 
	 * }
	 */
}
