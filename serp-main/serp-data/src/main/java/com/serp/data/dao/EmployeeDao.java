package com.serp.data.dao;

import java.util.Set;

import com.serp.data.exception.CustomGenericException;
import com.serp.data.model.Employee;

public interface EmployeeDao {
	
	public Set<Employee> listAllEmployees();
	
	public void saveOrUpdate(Employee employee);
	
	public Employee findEmployeeById(int id);
	
	public void deleteEmployee(int id) throws CustomGenericException;
}
