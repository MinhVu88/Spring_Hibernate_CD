package com.spring.front_controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/FormDataProcessing")
public class FormDataProcessing {

	// controller method to show the html form
	@RequestMapping("/showForm")
	public String showForm() {
		return "form";
	}
		
	// controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "formProcessing";
	}
	
	// controller method to read form data & add data to model
	@RequestMapping("/processModel0")
	public String processModel0(HttpServletRequest request, Model model) {
		
		String stuName = request.getParameter("studentName").toUpperCase();
		
		model.addAttribute("model", "Eyyo wassup, " + stuName + "!");
		
		return "formProcessing";
	}
	
	@RequestMapping("/processModel1")
	public String processModel1(@RequestParam("studentName") String stuName, Model model) {
		
		//String stuName = request.getParameter("studentName").toUpperCase();
		
		model.addAttribute("model", "what the f**k do you want, " + stuName.toUpperCase() + "?");
		
		return "formProcessing";
	}
}
