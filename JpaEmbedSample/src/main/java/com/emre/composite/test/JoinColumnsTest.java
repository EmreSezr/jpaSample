package com.emre.composite.test;

import com.emre.composite.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JoinColumnsTest {
    public static void main(String[] args) {

        long employeeId = 1;
        long projectId = 1;


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        ParticipantId participantId = new ParticipantId(employeeId, projectId);
        Participant participant = entityManager.find(Participant.class, participantId);

        DirectorId directorId = new DirectorId(employeeId, projectId);
        Director director = entityManager.find(Director.class, directorId);
        Task task = new Task(0, "0 işi bitir", participant, director);

        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
