package com.serp.data.dao;

import java.util.Set;

import com.serp.data.model.Department;

public interface DepartmentDao {
	
	public Set<Department> listAllDepartments();
}
