package com.emre.jpa.mapped.test;

import com.emre.jpa.mapped.entity.Customer;
import com.emre.jpa.mapped.entity.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MappedPersist {
    public static void main(String[] args) {

        Customer customer1 = new Customer(0, "Emre Sezer alıcı", 12);
        Customer customer2 = new Customer(0, "Ali Veli alıcı", 4300);
        Supplier supplier1 = new Supplier(0, "Mr Szr sup.", 11);
        Supplier supplier2 = new Supplier(0, "Deneme Soyad sup.", 9987);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(customer1);
        entityManager.persist(customer2);
        entityManager.persist(supplier1);
        entityManager.persist(supplier2);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
