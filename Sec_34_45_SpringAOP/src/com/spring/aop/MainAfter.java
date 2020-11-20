package com.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.daos.AccountDAO;
import com.spring.aop.entities.Account;

public class MainAfter {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
			
			AccountDAO bean = context.getBean("accountDAO", AccountDAO.class);
			
			List<Account> accounts = null;
			
			try {
				
				boolean problem = false;
				
				accounts = bean.findAccounts(problem);
				
				System.out.println("\n- The list of accounts (MainAfterReturning):");
				
				for (Account acc : accounts) {
					
					System.out.println(acc);
				}
				
			} catch (Exception e) {System.out.println("\n\t< The exception (MainAfterThrowing): " + e + " >");}
			
		} catch (Exception e) {System.out.println("\n" + e.getMessage());}
	}

}
