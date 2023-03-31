package com.emre.jpaquery.test;

import com.emre.jpaquery.entity.Example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExamplePersist {
    public static void main(String[] args) {
        Example example1 = new Example(0, "Emre 1", 1111);
        Example example2 = new Example(0, "Emre 2", 2222);
        Example example3 = new Example(0, "Emre 3", 3333);


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(example1);
        entityManager.persist(example2);
        entityManager.persist(example3);

        entityManager.getTransaction().commit();


        entityManager.close();
    }
}
