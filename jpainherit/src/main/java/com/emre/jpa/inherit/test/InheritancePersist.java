package com.emre.jpa.inherit.test;

import com.emre.jpa.inherit.entity.Brother;
import com.emre.jpa.inherit.entity.Sister;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InheritancePersist {
    public static void main(String[] args) {
        Brother brother1 = new Brother(0, "Brother 1", 4500, true);
        Brother brother2 = new Brother(0, "Brother 2", 3400, false);
        Sister sister1 = new Sister(0, "Sister 1", 2465.0, (short) 327);
        Sister sister2 = new Sister(0, "Sister 2", 2465.0, (short) 450);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(brother1);
        entityManager.persist(brother2);
        entityManager.persist(sister1);
        entityManager.persist(sister2);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
