package com.spring.aop.loggingAspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aop.entities.Account;

@Aspect
@Component
@Order(1)
public class Aspect1 {
	
	/* The @Before advice type */
	// @Before("execution(public void addAccount())")
	// @Before("execution(public void com.spring.aop.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(void add*())")
	// @Before("execution(* add*())")
	// @Before("execution(* add*(com.spring.aop.entities.Account))")
	// @Before("execution(* add*(com.spring.aop.entities.Account, ..))")
	// @Before("execution(* add*(..))")
	// @Before("execution(* com.spring.aop.daos.*.*(..))")
	// @Before("com.spring.aop.loggingAspects.PointcutDeclarations.DAOsPackage()")
	@Before("com.spring.aop.loggingAspects.PointcutDeclarations.excludeGetterSetter()")
	public void atBeforeAdvice1(JoinPoint joinPoint) {
		
		System.out.println("\n\t[ Aspect 1: using @Before advice on a method ]");
		
		// access & display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("\n-> Method signature: " + methodSignature);
		
		// access & display the method arguments
		Object[] args = joinPoint.getArgs();
		
		for (int i = 0; i < args.length; i++) {
			
			System.out.println("\n   * Argument #" + (i + 1) + ": " + args[i]);
			
			if (args[i] instanceof Account) {
				
				Account acc = (Account) args[i];
				
				System.out.println("\n\t-> Account name: " + acc.getName() + " & account level: " + acc.getLevel());
			}
		}
	}
	
	/* The @AfterReturning advice type */
	@AfterReturning(pointcut = "execution(* com.spring.aop.daos.AccountDAO.findAccounts(..))", returning = "result")
	public void atAfterReturningAdvice(JoinPoint joinPoint, List<Account> result) {
		
		System.out.println("\n\t[ Aspect 1: using @AfterReturning advice type on method: " + joinPoint.getSignature().toShortString());
		
		System.out.println("\n- The list of accounts with the lowercase names (Aspect1):");
		
		for (Account acc : result) {
			
			System.out.println(acc);
		}
		
		capitalizeAccNames(result);
		
		System.out.println("\n- The list of accounts with the capital names (Aspect1):");
		
		for (Account acc : result) {
			
			System.out.println(acc);
		}
	}

	private void capitalizeAccNames(List<Account> result) {
		
		for (Account acc : result) {
			
			acc.setName(acc.getName().toUpperCase());
		}
	}
	
	/* The @AfterThrowing advice type */
	@AfterThrowing(pointcut = "execution(* com.spring.aop.daos.AccountDAO.findAccounts(..))", throwing = "exception")
	public void atAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
		
		System.out.println("\n\t[ Aspect 1: using @AfterThrowing advice type on a method: " + joinPoint.getSignature().toShortString() + " ]");
		
		System.out.println("\n\t~ The exception (Aspect1): " + exception + " ~");
	}
	
	/* The @After advice type */
	@After("execution(* com.spring.aop.daos.AccountDAO.findAccounts(..))")
	public void atAfter(JoinPoint joinPoint) {
		
		System.out.println("\n\t[ Aspect 1: using @After advice type on a method: " + joinPoint.getSignature().toShortString() + " ]");
	}
	
	/* The @Around advice type */
	@Around("execution(* com.spring.aop.entities.*.get*(..))")
	public Object atAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		
		System.out.println("\n\t[ Aspect 1: using @Around advice type on a method: " + proceedingJoinPoint.getSignature().toShortString() + " ]");
		
		Object result = null;
		
		try {
			
			long start = System.currentTimeMillis();
			
			result = proceedingJoinPoint.proceed();
			
			long end = System.currentTimeMillis();
			
			System.out.println("\nThe method processing duration (Aspect1): " + ((end - start) / 1000.0) + " seconds");
		
		} catch (Throwable e) {
			
			System.out.println("\n@Around: " + e.getMessage());
			
			result = "Handled";
		}
		
		return result;
	}
	
}
