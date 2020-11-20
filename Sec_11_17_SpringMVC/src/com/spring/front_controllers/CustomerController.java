package com.spring.front_controllers;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entities.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("cust", new Customer());
		
		return "customerForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("cust") Customer c, BindingResult result) {
		
		System.out.println("\nThe customer's name: " + c.getFirstName() + " *" + c.getLastName() + "*");
		
		System.out.println("\nThe customer's age: " + c.getAge());
		
		System.out.println("\nThe customer's postal code: " + c.getPostalCode());
		
		System.out.println("\nThe customer's ID: " + c.getId());
		
		System.out.println("\nThe binding result: " + result + "\n\n\n");
		
		if (result.hasErrors()) {
			return "customerForm";
		} else {
			return "customerInfo";
		}
	}
	
	
	// add @InitBinder to pre-process web requests in terms of removing whitespaces if there are any
	// and if requests are entirely composed of whitespaces, null will be returned
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		
		binder.registerCustomEditor(String.class, editor);
	}
}
