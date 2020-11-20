package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.daos.AccountDAO;
import com.spring.aop.daos.MembershipDAO;
import com.spring.aop.entities.Account;

public class MainBefore {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
			
			AccountDAO bean0 = context.getBean("accountDAO", AccountDAO.class);
			
			MembershipDAO bean1 = context.getBean("membershipDAO", MembershipDAO.class);
			
			// bean0.addAccount();
			
			// bean0.addAccount(new Account());
			
			Account acc = new Account();
			
			acc.setName("Tool");
			
			acc.setLevel("God");
			
			bean0.addAccount(acc, true);
			
			bean0.deposit();
			
			bean0.setId("007");
			
			bean0.setName("James Bond");
			
			bean0.getId();
			
			bean0.getName();
			
			System.out.println("\n------------------------------------------------------------------------------------------------------");
			
			//bean1.addAccount();
			
			bean1.addMember();
			
			bean1.wearUniform();
			
			/*
			System.out.println("\n---------------------------------------------------------");
			
			bean0.addAccount();
			*/
			
		} catch (Exception e) {System.out.println("\n" + e.getMessage());}
	}

}
