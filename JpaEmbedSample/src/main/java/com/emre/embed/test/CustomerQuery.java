package com.emre.embed.test;

import com.emre.embed.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerQuery {
    public static void main(String[] args) {

        String districtName = "çorlu";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaPersistenceUnit");
        EntityManager entityManager= factory.createEntityManager();
        //districtName sütunu değeri alıp sorgulayan


        String jpql="select customer from Customer as customer "+
                "where customer.address.districtName = :districtName ";
        TypedQuery<Customer> query=entityManager.createQuery(jpql, Customer.class);
        query.setParameter("districtName" , districtName);
        List<Customer> customerList=query.getResultList();

        entityManager.close();
        for (Customer customer : customerList){
            System.out.println(customer.getCustomerId()+ " "
                    +customer.getCustomerName()+ " "
                    +customer.getAddress().getDistrictName()+ " "
                    +customer.getAddress().getProvinceName()+ " "
                    +customer.getAddress().getAddressLine1()+ " "
                    +customer.getAddress().getAddressLine2()+ " "
                    );
        }
    }
}