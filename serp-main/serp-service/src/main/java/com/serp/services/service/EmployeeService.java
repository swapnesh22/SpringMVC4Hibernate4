package com.serp.services.service;

import java.util.Set;

import com.serp.data.model.Employee;

public interface EmployeeService {
	
	public Set<Employee> listAllEmployees();
	
	public void saveOrUpdate(Employee employee);
	
	public Employee findEmployeeById(int id);
	
	public void deleteEmployee(int id);
}
