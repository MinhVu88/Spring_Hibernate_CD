package demos;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopes {

	public static void main(String[] args) {
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScopes.xml")) {
			
			Coach bean1 = context.getBean("football", Coach.class);
			
			Coach bean2 = context.getBean("football", Coach.class);
			
			if (bean1 == bean2) {
				System.out.println("\n\treferencing the SAME object/pointing to the SAME memory area");
				
				System.out.println("\nmemory address of bean1: " + bean1);
				
				System.out.println("\nmemory address of bean2: " + bean2);
			} else {
				System.out.println("\n\treferencing DIFFERENT objects/pointing to DIFFERENT memory areas");
				
				System.out.println("\nmemory address of bean1: " + bean1);
				
				System.out.println("\nmemory address of bean2: " + bean2);
			}
			
		} catch (BeansException e) {System.out.println("\n" + e.getMessage());}
		
	}

}
