package com.emre.jpaquery.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Example.findAll",
                query = "select example from Example as example "),

        @NamedQuery(
                name = "Example.findAllMin",
                query = "select example from Example as example where example.exampleValue> :exampleValueMin")

})

public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exampleId;
    private String exampleName;
    private double exampleValue;

    public Example() {
    }

    public Example(long exampleId, String exampleName, double exampleValue) {
        this.exampleId = exampleId;
        this.exampleName = exampleName;
        this.exampleValue = exampleValue;
    }

    public long getExampleId() {
        return exampleId;
    }

    public void setExampleId(long exampleId) {
        this.exampleId = exampleId;
    }

    public String getExampleName() {
        return exampleName;
    }

    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }

    public double getExampleValue() {
        return exampleValue;
    }

    public void setExampleValue(double exampleValue) {
        this.exampleValue = exampleValue;
    }
}
