package com.emre.metamodel.test;

import com.emre.jpaquery.entity.Example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

public class MetamodelTest {
    public static void main(String[] args) {

        /* Metamodel özelliği bize veritabanı değerlerimizi verir
         Bu örnek için Example.class'tan exampleId,exampleName ve exampleValue
        almış olduk ve ne tür veri olduğunu öğrendik. */

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Metamodel metamodel = entityManager.getMetamodel();
        EntityType<Example> example = metamodel.entity(Example.class);

        for (Attribute attribute : example.getAttributes()) {
            if (attribute instanceof SingularAttribute) {
                //Eğer attribute tek bir değer tutan alan ise
                System.out.println(attribute.getName()
                        + " " + attribute.getJavaType());
            }

        }

        entityManager.close();


    }
}
