package com.serp.data.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.serp.data.exception.CustomGenericException;
import com.serp.data.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> listAllCustomers() {
		Criteria criteria = getSession().createCriteria(Customer.class);
		return criteria.list();
	}

	public void saveOrUpdate(Customer customer) {
		getSession().saveOrUpdate(customer);
	}

	public Customer findCustomerById(int id) {
		Customer customer = (Customer) getSession().get(Customer.class, id);
		return customer;
	}

	public void deleteCustomer(int id) throws CustomGenericException {
		Customer customer = (Customer) getSession().get(Customer.class, id);
		getSession().delete(customer);
		//throw new CustomGenericException("GEN001","Error in deleting record");
	}

	

}
