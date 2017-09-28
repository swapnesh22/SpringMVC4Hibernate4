package com.serp.data.dao;

import java.util.List;

import com.serp.data.exception.CustomGenericException;
import com.serp.data.model.Customer;

public interface CustomerDao {
	
	public List<Customer> listAllCustomers();
	
	public void saveOrUpdate(Customer customer);
	
	public Customer findCustomerById(int id);
	
	public void deleteCustomer(int id) throws CustomGenericException;
}
