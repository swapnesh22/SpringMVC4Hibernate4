package com.serp.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.serp.data.exception.CustomGenericException;
import com.serp.data.model.Customer;
import com.serp.services.service.CustomerService;
import com.serp.web.validator.CustomerValidator;

@Controller
@RequestMapping
public class CustomerController {

	@Autowired
	private CustomerValidator customerValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(customerValidator);
	}

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/listCustomer", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		List<Customer> listCustomer = customerService.listAllCustomers();
		model.addAttribute("listCustomer", listCustomer);
		return "listCustomer";
	}

	@GetMapping("/addCustomer")
	public String customerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerForm";
	}

	/*
	 * Save user object
	 */
	// @PostMapping("/saveCustomer")
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "customerForm";
		}
		customerService.saveOrUpdate(customer);
		// return "success";//Send to success page with employee details only
		return "redirect:/listCustomer";
	}

	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") int id, @ModelAttribute("customer") Customer customer, Model model) {
		customer = customerService.findCustomerById(id);
		model.addAttribute("customer", customer);
		return "customerForm";
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model model) {
		try {
			customerService.deleteCustomer(id);
		} catch (CustomGenericException cge) {
			throw cge;
		}
	 	
		return "redirect:/listCustomer";
	}
	
	@ExceptionHandler({CustomGenericException.class})
    public ModelAndView handleSQLException(CustomGenericException ex) {
		ModelAndView model = new ModelAndView("/listCustomer");
		model.addObject("exception", ex);
		model.addObject("listCustomer", listCustomers());
        return model;
    }
	
	@ModelAttribute("listCustomer")
	public List<Customer> listCustomers() {
		List<Customer> listCustomer = customerService.listAllCustomers();
		return listCustomer;
	}

	@ModelAttribute("typeList")
	public List<String> typeList() {
		List<String> typeList = new ArrayList<String>();
		typeList.add("Admin");
		typeList.add("App User");
		typeList.add("Super");
		typeList.add("User");
		return typeList;
	}

}
