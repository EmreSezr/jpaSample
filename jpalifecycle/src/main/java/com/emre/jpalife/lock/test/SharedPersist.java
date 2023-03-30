package com.emre.jpalife.lock.test;

import com.emre.jpalife.lock.entity.Shared;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SharedPersist {
    public static void main(String[] args) {
        Shared shared=new Shared();
        shared.setSharedName("Paylaşılan Ad");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DenemePersistenceUnit");
        EntityManager entityManager=factory.createEntityManager();



        entityManager.persist(shared);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
