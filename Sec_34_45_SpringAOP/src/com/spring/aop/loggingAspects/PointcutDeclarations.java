package com.spring.aop.loggingAspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDeclarations {

		// a Pointcut declaration for all methods in the daos package, 
		// whose pointcut expression can be applied by multiple advice types
		@Pointcut("execution(* com.spring.aop.daos.*.*(..))")
		public void DAOsPackage() {}
		
		// a Pointcut declaration for getter methods
		@Pointcut("execution(* com.spring.aop.daos.*.get*(..))")
		public void getter() {}
		
		// a Pointcut declaration for setter methods
		@Pointcut("execution(* com.spring.aop.daos.*.set*(..))")
		public void setter() {}
		
		// a Pointcut declaration for all methods in the daos package, except getter & setter
		@Pointcut("DAOsPackage() && !(getter() || setter())")
		public void excludeGetterSetter() {}

}
