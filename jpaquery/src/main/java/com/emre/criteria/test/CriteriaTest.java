package com.emre.criteria.test;

import com.emre.jpaquery.entity.Example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaTest {
    public static void main(String[] args) {

        /* Criteria Query bize string ile sorgu yazmak yerine
        dinamik java kodu ile çalıştırabilmeyi sağlar */

        double exampleValueMin = 2000;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Example> criteria = builder.createQuery(Example.class);
        Root<Example> root = criteria.from(Example.class);
        Predicate condition = builder
                .gt(root.get("exampleValue"), exampleValueMin);
        criteria.where(condition);
        TypedQuery<Example> query = entityManager.createQuery(criteria);
        List<Example> exampleList = query.getResultList();

        entityManager.close();

        for (Example example : exampleList) {
            System.out.println(example.getExampleId() + " "
                    + example.getExampleName() + " "
                    + example.getExampleValue());
        }

    }
}
