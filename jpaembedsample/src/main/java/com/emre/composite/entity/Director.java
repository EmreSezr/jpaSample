package com.emre.composite.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

//Same way with Participant
@Entity @IdClass(DirectorId.class)
public class Director {

    @Id
    private long employeeId;
    @Id
    private long projectId;
    private String directoryTitle;

    public Director() {

    }

    public Director(long employeeId, long projectId, String directoryTitle) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.directoryTitle = directoryTitle;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getDirectoryTitle() {
        return directoryTitle;
    }

    public void setDirectoryTitle(String directoryTitle) {
        this.directoryTitle = directoryTitle;
    }
}
