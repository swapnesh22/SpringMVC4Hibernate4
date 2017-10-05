/**
 * 
 */
package com.serp.data.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author skarpe
 *
 */
@Entity
@Table (name="Department")
public class Department implements Serializable {
	
	public Department() {
		
	}
	
	public Department(String name) {
		this.name = name;
	}

	private int departmentId;
	
	private String name;
	
	private Set<Employee> employees = new HashSet<Employee>();

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(targetEntity=Employee.class, 
			mappedBy = "department", cascade = CascadeType.ALL, 
	        orphanRemoval = true)
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
