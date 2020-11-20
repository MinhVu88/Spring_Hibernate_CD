package com.spring.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	@NotNull(message = "is required")
	@Min(value = 0, message = "Must be equal to or greater than 0")
	@Max(value = 100, message = "Must be equal to or less than 100")
	private Integer age;
	
	@NotNull(message = "is required")
	@Min(value = 0, message = "Must be equal to or greater than 0")
	@Max(value = 9, message = "Must be equal to or less than 9")
	private int id;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 characters/digits")
	private String postalCode;

	public Customer() {}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {return firstName;}

	public void setFirstName(String firstName) {this.firstName = firstName;}

	public String getLastName() {return lastName;}

	public void setLastName(String lastName) {this.lastName = lastName;}

	public String getPostalCode() {return postalCode;}

	public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

	public Integer getAge() {return age;}

	public void setAge(Integer age) {this.age = age;}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}
	
	
}
