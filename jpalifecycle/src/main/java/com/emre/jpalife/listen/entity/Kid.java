package com.emre.jpalife.listen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kid extends Mother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idField;

    public long getIdField() {
        return idField;
    }

    public void setIdField(long idField) {
        this.idField = idField;
    }
}
