package com.emre.jpalife.lock.test;

import com.emre.jpalife.lock.entity.Shared;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class LockApplier {
    public static void main(String[] args) {
        long sharedId = 1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DenemePersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        /* Shared shared = entityManager.find(Shared.class, sharedId);
        entityManager.lock(shared, LockModeType.PESSIMISTIC_FORCE_INCREMENT); */

        entityManager.getTransaction().begin();

        Shared shared = entityManager.find(Shared.class, sharedId, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
        System.out.println("Sürüm Sayısı: " + shared.getVersionNumber());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shared.setSharedName("Paylaşılan Ad 12");
        System.out.println("Süre geçti , güncelleniyor.");
        entityManager.merge(shared);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
