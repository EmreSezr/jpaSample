package com.emre.jpalife.listen.entity;

import javax.persistence.PostPersist;

public class HeritageListener {

    @PostPersist
    public void onPostPersist(Mother mother){
        System.out.println("Direme Sonrası...");
    }
}
