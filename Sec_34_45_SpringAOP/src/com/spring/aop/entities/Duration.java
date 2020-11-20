package com.spring.aop.entities;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class Duration {

	public String getMethodProcessingDuration() {
		
		try {
			
			TimeUnit.SECONDS.sleep(5);
		
		} catch (InterruptedException e) {System.out.println("\n" + e.getMessage());}
		
		return "The method processing delayed time: 5 seconds";
	}

	public String getException(boolean problem) {
		
		if (problem) {
			
			throw new RuntimeException("some exception");
		}
		
		return getMethodProcessingDuration();
	}
}
