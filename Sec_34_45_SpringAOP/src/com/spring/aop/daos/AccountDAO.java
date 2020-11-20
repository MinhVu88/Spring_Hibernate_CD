package com.spring.aop.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aop.entities.Account;

@Component
public class AccountDAO {
	
	private String id, name;
	
	public String getId() {
		
		System.out.println("\n# " + getClass() + ": getId()");
		
		return id;
	}

	public void setId(String id) {
		
		System.out.println("\n# " + getClass() + ": setId()");
		
		this.id = id;
	}

	public String getName() {
		
		System.out.println("\n# " + getClass() + ": getName()");
		
		return name;
	}

	public void setName(String name) {
		
		System.out.println("\n# " + getClass() + ": setName()");
		
		this.name = name;
	}

	/*
	public void addAccount() {
		
		System.out.println("\n" + getClass() + ": add a new ACCOUNT");
	}
	*/

	public void addAccount(Account acc, boolean status) {
		
		System.out.println("\n" + getClass() + ": add a new ACCOUNT");
	}
	
	public boolean deposit() {
		
		System.out.println("\n" + getClass() + ": add a new DEPOSIT");
		
		return false;
	}
	
	public List<Account> findAccounts() {
		
		List<Account> accounts = new ArrayList<>();
		
		accounts.add(new Account("Adam Jones", "Metal"));
		
		accounts.add(new Account("Maynard James Keenan", "Fire"));
		
		accounts.add(new Account("Danny Carey", "Earth"));
		
		accounts.add(new Account("Justin Chancellor", "Wood"));
		
		accounts.add(new Account("Paul D'Amore", "Water"));
		
		return accounts;
	}
	
	public List<Account> findAccounts(boolean problem) {
		
		if (problem) {
			
			throw new RuntimeException("Something's wrong");
		}
		
		List<Account> accounts = new ArrayList<>();
		
		accounts.add(new Account("Adam Jones", "Metal"));
		
		accounts.add(new Account("Maynard James Keenan", "Fire"));
		
		accounts.add(new Account("Danny Carey", "Earth"));
		
		accounts.add(new Account("Justin Chancellor", "Wood"));
		
		accounts.add(new Account("Paul D'Amore", "Water"));
		
		return accounts;
	}
}
