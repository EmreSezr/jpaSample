package com.emre.jpa.inherit.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SISTER")
public class Sister extends Parent {

    private short sisterCode;

    public Sister() {
    }

    public Sister(long entityId, String entityName, double entityValue, short sisterCode) {
        super(entityId, entityName, entityValue);
        this.sisterCode = sisterCode;
    }

    public short getSisterCode() {
        return sisterCode;
    }

    public void setSisterCode(short sisterCode) {
        this.sisterCode = sisterCode;
    }
}
