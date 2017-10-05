package com.serp.services.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serp.data.dao.DepartmentDao;
import com.serp.data.model.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDao departmentDao;
		
	@Autowired
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public Set<Department> listAllDepartments() {
		return departmentDao.listAllDepartments();
	}
}
