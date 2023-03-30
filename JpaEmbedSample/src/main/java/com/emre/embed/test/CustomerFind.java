package com.emre.embed.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.emre.embed.entity.Customer;

public class CustomerFind {
	public static void main(String[] args) {
		long customerId = 1;

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		Customer customer = entityManager.find(Customer.class, customerId);
		entityManager.close();
		System.out.println(customer.getCustomerId() + " " + customer.getCustomerName() + " "
				+ customer.getAddress().getProvinceName() + " " 
				+ customer.getAddress().getDistrictName() + " ");
	}
}
