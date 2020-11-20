package com.spring.aop.loggingAspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class Aspect3 {

	@Before("com.spring.aop.loggingAspects.PointcutDeclarations.excludeGetterSetter()")
	public void atBeforeAdvice3() {
		
		System.out.println("\n\t[ Aspect 3: using @Order(some number) to order aspects ]");
	}

}
