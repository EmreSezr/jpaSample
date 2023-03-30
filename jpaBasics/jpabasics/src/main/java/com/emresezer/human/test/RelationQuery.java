package com.emresezer.human.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.emresezer.human.entity.Employee;

public class RelationQuery {
	public static void main(String[] args) {

		long departmenId=2;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		String jpql = "select employee from Employee as employee"
				+ " where employee.department.departmentId= :departmentId";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("departmentId", departmenId);
		List<Employee> employeeList = query.getResultList();
		entityManager.close();

		for (Employee employee : employeeList) {
			System.out.println(employee.getEmployeeId() + " " + employee.getEmployeeName() + " "
					+ employee.getEmployeeSalary() + " " + employee.getDepartment().getDepartmentId() + " "
					+ employee.getDepartment().getDepartmentName());
		}
	}
}
