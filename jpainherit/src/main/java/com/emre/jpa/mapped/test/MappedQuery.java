package com.emre.jpa.mapped.test;

import com.emre.jpa.mapped.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MappedQuery {
    public static void main(String[] args) {

        double totalDebitMin = 10;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String jpql = "select customer from Customer as customer "
                + "where customer.totalDebit > :totalDebitMin";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("totalDebitMin", totalDebitMin);
        List<Customer> customerList = query.getResultList();
        entityManager.close();
        for (Customer customer : customerList) {
            System.out.println(customer.getPartnerId() + " "
                    + customer.getTotalDebit() + " "
                    + customer.getPartnerName() + " "

            );
        }
    }
}
