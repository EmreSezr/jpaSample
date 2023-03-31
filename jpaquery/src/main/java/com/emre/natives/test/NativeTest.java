package com.emre.natives.test;

import com.emre.jpaquery.entity.Example;

import javax.persistence.*;
import java.util.List;

public class NativeTest {
    public static void main(String[] args) {
        //Klasik Sql dilidir -> native query

        double exampleValueMin = 2000;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String sql = "select * from Example where  exampleValue > ?";

        Query query = entityManager.createNativeQuery(sql, Example.class);
        query.setParameter(1, exampleValueMin);

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
