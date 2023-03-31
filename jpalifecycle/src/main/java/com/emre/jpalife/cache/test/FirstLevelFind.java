package com.emre.jpalife.cashe.test;

import com.emre.jpalife.cashe.entity.Frequent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FirstLevelFind {
    public static void main(String[] args) {
        long frequentId = 1;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DenemePersistenceUnit");
        EntityManager entityManager1 = factory.createEntityManager();

        Frequent frequent1a = entityManager1.find(Frequent.class, frequentId);
        System.out.println(frequent1a);
        entityManager1.refresh(frequent1a);
        Frequent frequent1b = entityManager1.find(Frequent.class, frequentId);
        System.out.println(frequent1b);
        entityManager1.close();


        EntityManager entityManager2 = factory.createEntityManager();

        Frequent frequent2 = entityManager2.find(Frequent.class, frequentId);
        System.out.println(frequent2);
        entityManager2.refresh(frequent2);
        entityManager2.close();
    }
}

/* Bu konu özetinde diyebiliriz ki her cache entitymanager bazında
değer tutar entitymanager1 ve entitymanager2 2 farklı Frequent@"idburada" değer
tutar
Bu konu first level cache'dir.
* */
