/**
 * 
 */
package com.serp.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author skarpe
 *
 */
@Entity
@Table (name="Customer")
@XmlRootElement
public class Customer implements Serializable {
	
	public Customer() {
		
	}
	
	public Customer(String firstname, String lastname, int age, String address, String gender, String type) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.type = type;
	}

	private int customernumber;
	
	private String firstname;
	
	private String lastname;
	
	private int age;
	
	private String address;
	
	private String gender;
	
	private String type;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "customernumber", nullable = false)
	public int getCustomernumber() {
		return customernumber;
	}

	public void setCustomernumber(int customernumber) {
		this.customernumber = customernumber;
	}

	@Column (name = "firstname", nullable = false)
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
