package com.emresezer.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.emresezer.inventory.entity.Product;

public class ProductPersist {
	public static void main(String[] args) {

		Product product = new Product(0, "cep tel", 1340.0);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(product);

		entityManager.getTransaction().commit();

		entityManager.close();
		
		System.out.println("ürün özdeşliği: " +product.getProductId());

	}
}
