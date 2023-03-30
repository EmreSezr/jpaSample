package com.emre.jpalife.cashe.entity;

import javax.persistence.*;

@Entity
@Cacheable()
public class Frequent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long frequentId;
    private String frequentName;

    public Frequent() {
    }

    public Frequent(long frequentId, String frequentName) {
        this.frequentId = frequentId;
        this.frequentName = frequentName;
    }

    public long getFrequentId() {
        return frequentId;
    }

    public void setFrequentId(long frequentId) {
        this.frequentId = frequentId;
    }

    public String getFrequentName() {
        return frequentName;
    }

    public void setFrequentName(String frequentName) {
        this.frequentName = frequentName;
    }
}
