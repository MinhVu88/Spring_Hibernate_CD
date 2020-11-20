package com.spring.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface CourseCode {

	// define the default value of the CourseCode annotation
	public String value() default "SCOPE";
	
	
	// define the default error message of the CourseCode annotation
	public String message() default "Must start with SCOPE";
	
	
	// define a group of related validation constraints
	public Class<?>[] groups() default {};
	
	
	// define the pay-loads, which give extra info regarding validation failure (severity level, error codes.,etc)
	public Class<? extends Payload>[] payload() default {};
	
}
