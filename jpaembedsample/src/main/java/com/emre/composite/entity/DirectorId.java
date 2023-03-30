package com.emre.composite.entity;

import java.io.Serializable;
import java.util.Objects;

public class DirectorId implements Serializable {
    private long employeeId;
    private long projectId;

    public DirectorId() {
    }

    public DirectorId(long employeeId, long projectId) {
        this.employeeId = employeeId;
        this.projectId = projectId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorId that = (DirectorId) o;
        return employeeId == that.employeeId && projectId == that.projectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectId);
    }

    @Override
    public String toString() {
        return employeeId
                + " @ " + projectId;
    }}