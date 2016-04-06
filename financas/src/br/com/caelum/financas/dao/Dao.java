package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.JPAUTIL.JPAUtil;

public class Dao {

	EntityManager manager;

	public void insert(Object object) {

		manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		manager.persist(object);

		manager.getTransaction().commit();

		manager.close();
	}

	public Object findObject(Object object, Integer integer) {

		manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		object = manager.find(object.getClass(), integer);

		manager.getTransaction().commit();
		manager.close();

		return object;
	}

	public Object selectObject(String querySelect, List<Object> object) {
		manager = new JPAUtil().getEntityManager();

		TypedQuery<Object> query = manager.createQuery(querySelect, Object.class);

		object = query.getResultList();
		
		manager.close();
		
		return object;

	}
}
