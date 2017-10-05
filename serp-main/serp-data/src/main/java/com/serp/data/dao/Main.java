package com.serp.data.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.serp.data.model.Department;
import com.serp.data.model.Employee;
//Temporary class which is for testing purpose
public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Department dept1 = new Department();
			dept1.setName("Finance");
			Set<Employee> employees1 = new HashSet<Employee>();
			Employee emp1 = new Employee("Swapnesh", "Karpe", 37, 
					"swapnesh.karpe@capgemini.com", "Male", "Mumbai");
			employees1.add(emp1);
			Employee emp2 = new Employee("Rajendra", "Sharma", 27, 
					"rajendra.sharma@capgemini.com", "Male", "Mumbai");
			employees1.add(emp2);
			dept1.setEmployees(employees1);
			
			session.save(dept1);
			
			Department dept2 = new Department();
			dept2.setName("HR");
			Set<Employee> employees2 = new HashSet<Employee>();
			Employee emp3 = new Employee("Rahul", "Shirwadkar", 40, 
					"rahul.shirwadkar@capgemini.com", "Male", "Mumbai");
			employees2.add(emp3);
			Employee emp4 = new Employee("Meera", "Desai", 32, 
					"meera.desai@capgemini.com", "Female", "Mumbai");
			employees2.add(emp4);
			dept2.setEmployees(employees2);
			session.save(dept2);
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
