package com.emresezer.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.emresezer.inventory.entity.Product;

public class ProductRemove {
	public static void main(String[] args) {
		//silmek için önce bulmak gerek o yüzden ilk önce find ile bulduk

		long productId = 2;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Product product = entityManager.getReference(Product.class, productId);
		entityManager.remove(product);

		entityManager.getTransaction().commit();

		entityManager.close();

	}
}
