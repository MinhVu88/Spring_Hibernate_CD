package com.spring.aop.loggingAspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class Aspect2 {

		// @Before("com.spring.aop.loggingAspects.PointcutDeclarations.DAOsPackage()")
		@Before("com.spring.aop.loggingAspects.PointcutDeclarations.excludeGetterSetter()")
		public void atBeforeAdvice2() {
			
			System.out.println("\n\t[ Aspect 2: reusing @Before advice on another method by using a Pointcut declaration ]");
		}

}
