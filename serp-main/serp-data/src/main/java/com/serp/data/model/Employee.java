/**
 * 
 */
package com.serp.data.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author skarpe
 *
 */
@Entity
@Table (name="Employee")
public class Employee implements Serializable {
	
	public Employee() {
		
	}
	
	public Employee(String firstname, String lastname, int age, String email, String gender, String address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.email = email;
	}

	private int employeeId;
	
	private String firstname;
	
	private String lastname;
	
	private int age;
	
	private String address;
	
	private String gender;
	
	private String email;
	
	private Department department;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "departmentId")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
}
