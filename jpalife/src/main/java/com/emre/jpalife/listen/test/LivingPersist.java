package com.emre.jpalife.listen.test;

import com.emre.jpalife.listen.entity.Living;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LivingPersist {
    public static void main(String[] args) {
        Living living = new Living();
        living.setFirstName(null);
        living.setLastName("Sezer");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DenemePersistenceUnit");
        EntityManager entityManager=factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(living);

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Ad Boş Mu? : " + living.isEmptyName());
    }
}
