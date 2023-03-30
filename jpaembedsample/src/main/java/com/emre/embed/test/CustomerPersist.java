package com.emre.embed.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.emre.embed.entity.Address;
import com.emre.embed.entity.Customer;

public class CustomerPersist {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setCustomerName("emre sezer");

        Address address = new Address();
        address.setProvinceName("tekirdağ");
        address.setDistrictName("çorlu");
        address.setAddressLine1("atatürk meydanı");
        address.setAddressLine2("no:12");
        customer.setAddress(address);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
