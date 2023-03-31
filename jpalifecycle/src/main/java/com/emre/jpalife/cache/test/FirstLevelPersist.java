package com.emre.jpalife.cashe.test;

import com.emre.jpalife.cashe.entity.Frequent;
import com.emre.jpalife.listen.entity.Kid;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FirstLevelPersist {
    public static void main(String[] args) {
        Frequent frequent = new Frequent(0, "Sıklık Adı");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DenemePersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(frequent);

        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
