package com.emre.bulks.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BulkUpdate {
    public static void main(String[] args) {

        //Verileri toplu bir şekilde güncelleyebiliriz yığıt(bulk) sorgular ile

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        String jpql = "update Example as e " +
                "set e.exampleName = CONCAT('Güncel ', e.exampleName) ";
        //bütün verilerimizin başına "Güncel" ekledik
        Query query = entityManager.createQuery(jpql);
        int affected=query.executeUpdate();


        entityManager.getTransaction().commit();

        entityManager.close();

        System.out.println("Etkilenmiş : "+affected);
    }
}
