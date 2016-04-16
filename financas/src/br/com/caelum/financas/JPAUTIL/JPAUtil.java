package br.com.caelum.financas.JPAUTIL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
	

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
