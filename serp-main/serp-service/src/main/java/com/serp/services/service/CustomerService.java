package com.serp.services.service;

import java.util.List;

import com.serp.data.model.Customer;

public interface CustomerService {
	
	public List<Customer> listAllCustomers();
	
	public void saveOrUpdate(Customer customer);
	
	public Customer findCustomerById(int id);
	
	public void deleteCustomer(int id);
}
