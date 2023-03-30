package com.emre.jpalife.listen.entity;

import javax.persistence.*;

@Entity
public class Living {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long livingId;
    private String firstName;
    private String lastName;
    private boolean emptyName;

    @PrePersist
    public void onPrePersist() {
        //PrePersist anotasyonu persist etmeden önce çalışır.
        System.out.println("Çalışıyor...");
        if (firstName == null || firstName.equals("") || lastName == null || lastName.equals("")) {
            emptyName = true;
        }

    }

    public long getLivingId() {
        return livingId;
    }

    public void setLivingId(long livingId) {
        this.livingId = livingId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEmptyName() {
        return emptyName;
    }

    public void setEmptyName(boolean emptyName) {
        this.emptyName = emptyName;
    }
}
