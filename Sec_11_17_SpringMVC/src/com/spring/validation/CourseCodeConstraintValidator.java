package com.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		
		this.coursePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		
		if (code != null) {
			return code.startsWith(coursePrefix);
		} else {
			return false;
		}
		
	}

}
