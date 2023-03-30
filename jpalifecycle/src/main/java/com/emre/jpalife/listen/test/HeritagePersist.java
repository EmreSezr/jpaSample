package com.emre.jpalife.listen.test;

import com.emre.jpalife.listen.entity.Kid;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HeritagePersist {
    public static void main(String[] args) {
        Kid kid=new Kid();
        kid.setNameField("Çocuk");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DenemePersistenceUnit");
        EntityManager entityManager=factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(kid);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
