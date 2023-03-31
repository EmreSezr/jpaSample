package com.emre.named.test;

import com.emre.jpaquery.entity.Example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class NamedTest {
    public static void main(String[] args) {

        double exampleValueMin=2000;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        TypedQuery<Example> query = entityManager.createNamedQuery("Example.findAllMin", Example.class);
        query.setParameter("exampleValueMin",exampleValueMin);
        List<Example> exampleList = query.getResultList();

        entityManager.close();

        for (Example example : exampleList) {
            System.out.println(example.getExampleId() + " "
                    + example.getExampleName() + " "
                    + example.getExampleValue() + " "
            );
        }


    }
}
