package com.emresezer.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class QueryAggregate {
	public static void main(String[] args) {

		double salesPriceMin = 20000;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		String jpql = "select count(product.productId) from Product as product "
				+ "where product.salesPrice > :salesPriceMin";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("salesPriceMin", salesPriceMin);
		long count = (long) query.getSingleResult();

		
		
		String jpql2 = "select sum(product.salesPrice) from Product as product "
				+ "where product.salesPrice > 1000";
		// sum yerine avg,min,max vs kullanabiliriz
		Query query2 = entityManager.createQuery(jpql2);
		double sum = (double) query2.getSingleResult();

		entityManager.close();

		System.out.println("Query'den Çıkan Toplam Veri Sayısı: " + count);
		System.out.println("Query'den Çıkan Verilerin Toplamı: " + sum);

	}
}
