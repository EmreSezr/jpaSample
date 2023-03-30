package com.emre.jpalife.cashe.test;

import com.emre.jpalife.cashe.entity.Frequent;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SecondLevelFind {
    public static void main(String[] args) {

        long frequentId = 1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DenemePersistenceUnit");

        Cache cache = factory.getCache();

        EntityManager entityManager1 = factory.createEntityManager();

        Frequent frequent1a = entityManager1.find(Frequent.class, frequentId);
        System.out.println(frequent1a);
        System.out.println("Cachede mi?: " + cache.contains(Frequent.class, frequentId));
        cache.evict(Frequent.class, frequentId); // Frequent classındaki id'yi boşaltır
        // cache.evict(Frequent.class); --> Frequent classını boşaltır cacheden
        // cache.evictAll(); --> Bütün cacheyi boşaltır
        System.out.println("Cachede mi?: " + cache.contains(Frequent.class, frequentId));
        entityManager1.close();

    }
}

/* SECOND LEVEL CACHE AYARLARI
persistence.xml

	<property name="hibernate.cache.use_second_level_cache"
		value="true" />
	<property name="hibernate.cache.region.factory_class"
		value="org.hibernate.cache.ehcache.EhCacheRegionFactory" />

pom.xml

	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-ehcache</artifactId>
		<version>5.2.6.Final</version>
	</dependency>

 */