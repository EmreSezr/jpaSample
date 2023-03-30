package com.emre.composite.test;

import com.emre.composite.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IdClassPersist {
    public static void main(String[] args) {
        Employee employee = new Employee(0, "İşalan 1");
        Project project = new Project(0, "proje 2");


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(project);
        entityManager.getTransaction().commit();


        Director director = new Director(
                employee.getEmployeeId(), project.getProjectId(),"PC MUH" );
        entityManager.getTransaction().begin();
        entityManager.persist(director);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}


