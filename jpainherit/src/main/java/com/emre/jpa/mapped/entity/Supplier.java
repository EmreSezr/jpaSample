package com.emre.jpa.mapped.entity;

import javax.persistence.Entity;

@Entity
public class Supplier extends Partner {
    private double totalCredit;

    public Supplier() {
    }

    public Supplier(long partnerId, String partnerName, double totalCredit) {
        super(partnerId, partnerName);
        this.totalCredit = totalCredit;
    }

    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }
}
