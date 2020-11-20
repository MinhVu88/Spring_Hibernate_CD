package com.springhb.crms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.springhb.crms.daos.CustomerDAO;
import com.springhb.crms.entities.Customer;
import com.springhb.crms.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/*
	// inject the Customer data access object (DAO)
	@Autowired
	private CustomerDAO custDAO;
	*/
	
	// inject the customer service layer, which sits between the controllers & the DAOs
	@Autowired
	private CustomerService custService;
	
	//@RequestMapping("/list")
	//@PostMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		// get the Customer objects from CustomerServiceImpl (controllers <-> services <-> DAOs <-> database)
		List<Customer> customers = custService.getCustomers();
		
		// add the objects to model
		model.addAttribute("custList", customers);
		
		return "customerList";
	}
	
	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		
		model.addAttribute("cust", new Customer());
		
		return "customerForm";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("cust") Customer c) {
		
		custService.saveClient(c);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("id") int id, Model model) {
		
		// get the customer data from customer service & set it as model attribute 
		// to pre-populate the form with the data when user clicks the Update link
		model.addAttribute("cust", custService.getCustomer(id));
		
		return "customerForm";
	}
	
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") int id) {
		
		// delete the customer data from the service
		custService.removeCustomer(id);
		
		return "redirect:/customer/list";
	}
}
