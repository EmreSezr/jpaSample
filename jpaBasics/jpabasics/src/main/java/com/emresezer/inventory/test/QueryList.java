package com.emresezer.inventory.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.emresezer.inventory.entity.Product;

public class QueryList {

	public static void main(String[] args) {

		double salesPriceMin = 22000;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		String jpql = "select product from Product as product "
				+ "where product.salesPrice > :salesPriceMin";
		// burdaki Product class ismi
		// OOP düşünerek Product as product demek Product product = new Product(); demektir

		Query query = entityManager.createQuery(jpql);
		query.setParameter("salesPriceMin", salesPriceMin);
		List<Product> productList = query.getResultList();
		
		/*25. satırda yazdığımız kodun daha tip güvenli hali şu şekildedir
		 * TypedQuery<Product> query=entityManager.createQuery(jpql, Product.class);
		 * query.setParameter("salesPriceMin",salesPriceMin);
		 * List<Product> productList = query.getResultList();
		 * */

		entityManager.close();

		for (Product product : productList) {
			System.out.println(
					product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice() + " ");
		}

	}

}
