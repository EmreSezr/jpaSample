package com.emre.jpa.inherit.test;

import com.emre.jpa.inherit.entity.Brother;
import com.emre.jpa.inherit.entity.Parent;
import com.emre.jpa.mapped.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class InheritanceQuery {
    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String jpql1 = "select brother from Brother as brother ";
        TypedQuery<Brother> query1 = entityManager.createQuery(jpql1, Brother.class);
        List<Brother> brotherList = query1.getResultList();

        String jpql2 = "select parent from Parent as parent ";
        TypedQuery<Parent> query2 = entityManager.createQuery(jpql2, Parent.class);
        List<Parent> parentList = query2.getResultList();

        entityManager.close();

        for (Brother brother : brotherList) {
            System.out.println(brother.getEntityId() + " "
                    + brother.getEntityName() + " "
                    + brother.getEntityValue() + " "
                    + brother.isBrotherCheck() + " "

            );
        }
        System.out.println("*********//*********");

        for (Parent parent : parentList) {
            System.out.println(parent.getEntityId() + " "
                    + parent.getEntityName() + " "
                    + parent.getEntityValue() + " ");
            /*
            if (parent instanceof Brother) {
                Brother brother=(Brother) parent;
                System.out.println(brother.isBrotherCheck()); }
                */

        }

    }
}

