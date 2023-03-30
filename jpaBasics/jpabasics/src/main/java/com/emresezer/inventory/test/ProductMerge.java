package com.emresezer.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.emresezer.inventory.entity.Product;

public class ProductMerge {
	public static void main(String[] args) {
		//güncellemek için önce bulmak gerek o yüzden ilk önce find ile bulduk

		long productId = 1;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Product product = entityManager.find(Product.class, productId);
		product.setProductName("PC");
		product.setSalesPrice(22500);
		entityManager.merge(product);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

}
