package com.emre.jpa.mapped.entity;

import javax.persistence.*;

@MappedSuperclass
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long partnerId;
    private String partnerName;

    public Partner() {
    }

    public Partner(long parentId, String parentName) {
        this.partnerId = parentId;
        this.partnerName = parentName;
    }

    public long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
}
