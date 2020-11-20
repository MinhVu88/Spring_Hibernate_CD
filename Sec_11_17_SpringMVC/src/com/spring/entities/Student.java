package com.spring.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.spring.validation.CourseCode;

public class Student {
	
	private String firstName, lastName, gender, hometown, favLang;
	
	@CourseCode
	private String courseCode;
	
	private List<String> OSs;
	
	private LinkedHashMap<String, String> countries, languages;

	public Student() {
		
		countries = new LinkedHashMap<>();
		
		countries.put("Deutschland", "Germany");
		
		countries.put("Japan", "Japan");
		
		countries.put("Norway", "Norway");
		
		countries.put("Sweden", "Sweden");
		
		countries.put("Spain", "Spain");
		
		countries.put("Canada", "Canada");
		
		countries.put("Korea", "Korea");
		
		countries.put("Russia", "Russia");
		
		countries.put("Mexico", "Mexico");
		
		countries.put("Australia", "Australia");
		
		languages = new LinkedHashMap<>();
		
		languages.put("Java", "Java");
		
		languages.put("C++", "C++");
		
		languages.put("Python", "Python");
		
		languages.put("Swift", "Swift");
		
		languages.put("Javascript", "Javascript");
		
		languages.put("Ruby", "Ruby");
		
		languages.put("Go", "Go");
		
		OSs = new ArrayList<>();
	}

	public Student(String firstName, String lastName, String gender, String hometown, String favLang) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hometown = hometown;
		this.favLang = favLang;
	}

	public String getFirstName() {return firstName;}

	public void setFirstName(String firstName) {this.firstName = firstName;}

	public String getLastName() {return lastName;}

	public void setLastName(String lastName) {this.lastName = lastName;}

	public String getGender() {return gender;}

	public void setGender(String gender) {this.gender = gender;}
	
	public String getHometown() {return hometown;}

	public void setHometown(String hometown) {this.hometown = hometown;}
	
	public String getFavLang() {return favLang;}

	public void setFavLang(String favLang) {this.favLang = favLang;}
	
	public String getCourseCode() {return courseCode;}

	public void setCourseCode(String courseCode) {this.courseCode = courseCode;}

	public List<String> getOSs() {return OSs;}

	public void setOSs(List<String> oSs) {OSs = oSs;}

	public LinkedHashMap<String, String> getLanguages() {return languages;}

	public void setLanguages(LinkedHashMap<String, String> languages) {this.languages = languages;}

	public LinkedHashMap<String, String> getCountries() {return countries;}

	public void setCountries(LinkedHashMap<String, String> countries) {this.countries = countries;}
	
	
}
