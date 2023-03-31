package com.emre.jpaquery.test;

import com.emre.jpaquery.entity.Department;
import com.emre.jpaquery.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class RelationPersist {
    public static void main(String[] args) {

        Department departmentA = new Department(0, "Müh");
        departmentA.setEmployeeList(new ArrayList<Employee>());

        Employee employee1 = new Employee(0, "Furkan", 1700);
        employee1.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee1);

        Employee employee2 = new Employee(0, "Hasan", 2000);
        employee2.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee2);

        Employee employee3 = new Employee(0, "Hakan", 1500);
        employee3.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee3);

        Employee employee4 = new Employee(0, "Emre", 22500);
        employee4.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee4);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(departmentA);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
