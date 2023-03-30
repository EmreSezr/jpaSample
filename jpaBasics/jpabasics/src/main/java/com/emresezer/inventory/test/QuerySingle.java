package com.emresezer.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.emresezer.inventory.entity.Product;

public class QuerySingle {

	public static void main(String[] args) {
		Product productSingle;
		try {
			double salesPriceMin = 28000;
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
			EntityManager entityManager = factory.createEntityManager();
			String jpql = "select product from Product as product " + "where product.salesPrice > :salesPriceMin";

			TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
			query.setParameter("salesPriceMin", salesPriceMin);
			productSingle = query.getSingleResult();
			entityManager.close();

		} catch (NoResultException e) {
			productSingle = null;
		}

		if (productSingle != null) {
			System.out.println(productSingle.getProductId() + " " + productSingle.getProductName() + " "
					+ productSingle.getSalesPrice() + " ");
		} else {

			System.out.println("Query Uygun Veri Bulunamadı");
		}
		
		/* Eğer çoklu bir veri isteseydik single result query olduğu için hata verecekti
		fakat bu duruma önlem almamak daha iyi olur çünkü hiç olmamasıyla birden fazla olması aynı durum
		değildir.Single Result Query için çoklu durum kullanmak zaten doğru kullanım değildir.
		*/
	}
}
