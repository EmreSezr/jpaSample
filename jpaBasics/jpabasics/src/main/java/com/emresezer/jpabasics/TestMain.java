package com.emresezer.jpabasics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestMain {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		Data data= new Data();
		data.setDataName("emre");
		data.setDataValue(123.45);
		
		entityManager.getTransaction().begin();
		entityManager.persist(data);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
