package com.emre.composite.test;

import com.emre.composite.entity.Director;
import com.emre.composite.entity.DirectorId;
import com.emre.composite.entity.Participant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IdClassFind {
    public static void main(String[] args) {
        long employeeId = 2;
        long projectId = 2;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        DirectorId directorId = new DirectorId(employeeId, projectId);
        Director director = entityManager.find(Director.class, directorId);
        entityManager.close();
        System.out.println(director.getEmployeeId()
                + " "
                + director.getProjectId()
                + " "
                + director.getDirectoryTitle()
                + " "
        );
    }
}
