package com.emre.bulks.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BulkDelete {
    public static void main(String[] args) {

        //Verileri toplu bir şekilde silebiliriz yığıt(bulk) sorgular ile

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql = "delete Example as e " + "where e.exampleName LIKE :namePattern ";
        //içinde %Gün% geçen bütün verileri siliyoruz
        Query query = entityManager.createQuery(jpql);
        query.setParameter("namePattern", "%Gün%");
        int affected = query.executeUpdate();


        entityManager.getTransaction().commit();

        entityManager.close();

        System.out.println("Etkilenmiş : " + affected);
    }
}
