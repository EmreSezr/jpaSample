package com.emre.jpalife.listen.entity;

import javax.persistence.PostPersist;

public class LivingListener {
    @PostPersist
    public void onPostPersist(Living living) {
        System.out.println("Varlık Dizeliyor...  " + living.getLivingId());
    }
}
