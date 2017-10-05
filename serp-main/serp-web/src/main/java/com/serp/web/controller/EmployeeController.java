package com.serp.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.serp.data.exception.CustomGenericException;
import com.serp.data.model.Customer;
import com.serp.data.model.Department;
import com.serp.data.model.Employee;
import com.serp.services.service.DepartmentService;
import com.serp.services.service.EmployeeService;
import com.serp.web.validator.EmployeeValidator;

@Controller
@RequestMapping (value="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeValidator employeeValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(employeeValidator);
	}

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
	public String listEmployee(Model model) {
		Set<Employee> listEmployee = employeeService.listAllEmployees();
		model.addAttribute("listEmployee", listEmployee);
		return "employee/listEmployee";
	}

	@ModelAttribute("departmentList")
	public Set<Department> departmentList() {
		Set<Department> departmentList = departmentService.listAllDepartments();
		return departmentList;
	}
	
	@RequestMapping (value="/addEmployee", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/employeeForm";
	}
	
	@RequestMapping (value="/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") 
								@Validated Employee employee, 
								BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "employee/employeeForm";
		}
		employeeService.saveOrUpdate(employee);
		return "redirect:/employee/listEmployee";
	}
	
	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") int id, @ModelAttribute("employee") Employee employee, Model model) {
		employee = employeeService.findEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employee/employeeForm";
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model model) {
		try {
			employeeService.deleteEmployee(id);
		} catch (CustomGenericException cge) {
			throw cge;
		}
	 	
		return "redirect:/employee/listEmployee";
	}

}
