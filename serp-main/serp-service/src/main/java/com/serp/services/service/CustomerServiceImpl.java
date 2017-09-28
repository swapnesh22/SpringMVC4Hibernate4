package com.serp.services.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serp.data.dao.CustomerDao;
import com.serp.data.exception.CustomGenericException;
import com.serp.data.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;
		
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customer> listAllCustomers() {
		return customerDao.listAllCustomers();
	}

	public void saveOrUpdate(Customer customer) {
		customerDao.saveOrUpdate(customer);
	}

	public Customer findCustomerById(int id) {
		return customerDao.findCustomerById(id);
	}

	public void deleteCustomer(int id) throws CustomGenericException {
		throw new CustomGenericException("GEN001","Error in deleting record");
		//customerDao.deleteCustomer(id);
	}

	
}
