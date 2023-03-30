package com.emresezer.human.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.emresezer.human.entity.Department;
import com.emresezer.human.entity.Employee;

public class RelationPersist {
	public static void main(String[] args) {

		Department departmentA = new Department(0,"Satış");
		departmentA.setEmployeeList(new ArrayList<Employee>());
		
		Employee employee1=new Employee(0,"Furkan",1700);
		employee1.setDepartment(departmentA);
		departmentA.getEmployeeList().add(employee1);
		
		Employee employee2=new Employee(0,"Hasan",2000);
		employee2.setDepartment(departmentA);
		departmentA.getEmployeeList().add(employee2);
		
		Employee employee3=new Employee(0,"Hakan",1500);
		employee3.setDepartment(departmentA);
		departmentA.getEmployeeList().add(employee3);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		
		entityManager.persist(departmentA);

		entityManager.getTransaction().commit();

		entityManager.close();

	}
}
