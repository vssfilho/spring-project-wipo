package com.java.wipo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao {

	protected static EntityManager em;
	
	public void create() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql-persistence-unit");
		GenericDao.em = emf.createEntityManager();	
	}
	
	public void begin() {
		GenericDao.em.getTransaction().begin();
	}
	
	public void close() {
		GenericDao.em.close();
	}
	
	public void rollback() {
		GenericDao.em.getTransaction().rollback();
	}
	
	public void commit() {
		GenericDao.em.getTransaction().commit();
	}
	
}
