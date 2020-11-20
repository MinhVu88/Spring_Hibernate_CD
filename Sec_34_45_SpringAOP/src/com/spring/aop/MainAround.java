package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.entities.Duration;

public class MainAround {

	public static void main(String[] args) {
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
			
			Duration bean = context.getBean("duration", Duration.class);
			
			boolean problem = true;
			
			String result = bean.getException(problem);
			
			System.out.println("\nThe exception: " + result);
			
			System.out.println("\nMainAround: " + bean.getMethodProcessingDuration());
			
			System.out.println("\nFinished");
			
		} catch (Exception e) {System.out.println("\n" + e.getMessage());}
		
	}

}
