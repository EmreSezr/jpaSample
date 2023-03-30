package com.emre.jpalife.lock.entity;


import javax.persistence.*;

@Entity
@Cacheable
public class Shared {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sharedId;
    private String sharedName;
    @Version
    private long versionNumber;

    public long getSharedId() {
        return sharedId;
    }

    public void setSharedId(long sharedId) {
        this.sharedId = sharedId;
    }

    public String getSharedName() {
        return sharedName;
    }

    public void setSharedName(String sharedName) {
        this.sharedName = sharedName;
    }

    public long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(long versionNumber) {
        this.versionNumber = versionNumber;
    }
}
