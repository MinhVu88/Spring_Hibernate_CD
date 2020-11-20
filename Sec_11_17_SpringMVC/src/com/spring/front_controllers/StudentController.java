package com.spring.front_controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entities.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("stu", student);
		
		return "studentForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("stu") Student student, BindingResult result) {
		
		System.out.println("\nThe student's name: " + student.getFirstName() + " " + student.getLastName());
		
		System.out.println("\nThe student's gender: " + student.getGender());
		
		System.out.println("\nThe student's hometown: " + student.getHometown());
		
		System.out.println("\nThe student's fav programming language: " + student.getFavLang());
		
		System.out.println("\nThe student's experiecned with:");
		
		for(String os : student.getOSs()) {
			System.out.println("\n\t* " + os);
		}
		
		if (result.hasErrors()) {
			
			System.out.println("\nInvalid course code");
			
			return "studentForm";
		} else {
			
			System.out.println("\nThe student's course code: " + student.getCourseCode());
			
			return "studentInfo";
		}
		
	}
}
