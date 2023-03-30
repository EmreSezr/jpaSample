package com.emre.composite.entity;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    private String taskName;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "projectIdParticipant", referencedColumnName = "projectId"),
            @JoinColumn(name = "employeeIdParticipant", referencedColumnName = "employeeId"),
    })
    private Participant participant;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "projectIdDirector", referencedColumnName = "projectId"),
            @JoinColumn(name = "employeeIdDirector", referencedColumnName = "employeeId"),
    })
    private Director director;

    public Task() {
    }

    public Task(long taskId, String taskName, Participant participant, Director director) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.participant = participant;
        this.director = director;
    }

    public double getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
