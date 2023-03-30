package com.emre.composite.test;

import com.emre.composite.entity.Employee;
import com.emre.composite.entity.Participant;
import com.emre.composite.entity.ParticipantId;
import com.emre.composite.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmbeddedIdTest {
    public static void main(String[] args) {
        Employee employee = new Employee(0, "emre sezer");
        Project project = new Project(0, "proje 1");


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(project);
        entityManager.getTransaction().commit();

        ParticipantId participantId = new ParticipantId(employee.getEmployeeId(), project.getProjectId());
        Participant participant = new Participant(participantId,"Müh");
        entityManager.getTransaction().begin();
        entityManager.persist(participant);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
