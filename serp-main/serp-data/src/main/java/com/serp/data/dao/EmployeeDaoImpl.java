package com.serp.data.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.serp.data.exception.CustomGenericException;
import com.serp.data.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public Set<Employee> listAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		Set<Employee> employees = new HashSet<Employee>();
		employees.addAll(criteria.list());
		return employees;
	}

	public void saveOrUpdate(Employee employee) {
		getSession().saveOrUpdate(employee);		
	}

	public Employee findEmployeeById(int id) {
		Employee employee = (Employee) getSession().get(Employee.class, id);
		return employee;
	}

	public void deleteEmployee(int id) throws CustomGenericException {
		Employee employee = (Employee) getSession().get(Employee.class, id);
		getSession().delete(employee);
	}

	

}
