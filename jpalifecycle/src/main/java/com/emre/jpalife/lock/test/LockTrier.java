package com.emre.jpalife.lock.test;

import com.emre.jpalife.lock.entity.Shared;

import javax.persistence.*;

public class LockTrier {
    public static void main(String[] args) {
        long sharedId = 1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DenemePersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();
        long time = 0;
        long timeout = 20000;
        while (time < timeout) {

            try {
                Shared shared = entityManager.find(Shared.class, sharedId);
                System.out.println(time+ " " +shared.getSharedName());

                entityManager.getTransaction().begin();

                shared.setSharedName("Paylaşılan Ad 13");

                entityManager.merge(shared);
                entityManager.getTransaction().commit();

                Thread.sleep(1000);
            } catch (RollbackException e) {
                System.out.println("İyimser kilitleme");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        entityManager.close();
    }
}
