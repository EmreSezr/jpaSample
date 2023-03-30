package com.emre.jpa.mapped.entity;

import javax.persistence.Entity;

@Entity
public class Customer extends Partner {

    private double totalDebit;

    public Customer() {
    }

    public Customer(long partnerId, String partnerName, double totalDebit) {
        super(partnerId, partnerName);
        this.totalDebit = totalDebit;
    }

    public double getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(double totalDebit) {
        this.totalDebit = totalDebit;
    }
}
