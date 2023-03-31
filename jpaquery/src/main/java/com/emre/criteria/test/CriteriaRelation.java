package com.emre.criteria.test;

import com.emre.jpaquery.entity.Department;
import com.emre.jpaquery.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class CriteriaRelation {
    public static void main(String[] args) {
        /*İlişkisel olan verilerin join edip birlikte sorgusunun yapıldığı örnek
         * Burda departmanNamesinin içinde "%üh%" geçen employeeleri bastırıyoruz.
         */

        double employeeSalaryMax = 5000;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueryPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        Join<Employee, Department> relation = root.join("department");
        Predicate condition = builder.like(relation.get("departmentName"), "%üh%");
        criteria.where(condition);
        TypedQuery<Employee> query = entityManager.createQuery(criteria);
        List<Employee> employeeList = query.getResultList();

        entityManager.close();

        for (Employee employee : employeeList) {
            System.out.println(employee.getEmployeeId() + " "
                    + employee.getEmployeeName() + " "
                    + employee.getEmployeeSalary() + " "
                    + employee.getDepartment().getDepartmentId() + " "
                    + employee.getDepartment().getDepartmentName() + " ");
        }

    }
}
