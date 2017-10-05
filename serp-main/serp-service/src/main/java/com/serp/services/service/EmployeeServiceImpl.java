package com.serp.services.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serp.data.dao.EmployeeDao;
import com.serp.data.exception.CustomGenericException;
import com.serp.data.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao;
		
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Set<Employee> listAllEmployees() {
		return employeeDao.listAllEmployees();
	}

	public void saveOrUpdate(Employee employee) {
		employeeDao.saveOrUpdate(employee);
	}

	public Employee findEmployeeById(int id) {
		return employeeDao.findEmployeeById(id);
	}

	public void deleteEmployee(int id) throws CustomGenericException {
		employeeDao.deleteEmployee(id);
	}
	
	
}
