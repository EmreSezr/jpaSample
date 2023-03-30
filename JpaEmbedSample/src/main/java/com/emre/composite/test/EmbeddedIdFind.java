package com.emre.composite.test;

import com.emre.composite.entity.Participant;
import com.emre.composite.entity.ParticipantId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmbeddedIdFind {
    public static void main(String[] args) {
        long employeeId = 1;
        long projectId = 1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        ParticipantId participantId = new ParticipantId(employeeId, projectId);
        Participant participant = entityManager.find(Participant.class, participantId);
        entityManager.close();
        System.out.println(participant.getParticipantId()
                + " "
                + participant.getRoleName()
                + " ");
    }
}


