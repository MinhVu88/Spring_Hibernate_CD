package com.spring.aop.daos;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	
	public void addAccount() {
		
		System.out.println("\n" + getClass() + ": add a MEMBER account");
	}
	
	
	/*
	public void addMember() {
		
		System.out.println("\n" + getClass() + ": add a new MEMBER");
	}
	*/
	
	public boolean addMember() {
		
		System.out.println("\n" + getClass() + ": add a new MEMBER");
		
		return true;
	}
	
	public void wearUniform() {
		
		System.out.println("\n" + getClass() + ": wear military uniform");
	}
	
}
