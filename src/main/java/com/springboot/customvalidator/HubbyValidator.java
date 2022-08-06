package com.springboot.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;

public class HubbyValidator implements ConstraintValidator<IsValidHubby, String> {

	@Valid
	public void invalidate(IsValidHubby hubby) {
	}

	@Override
	public boolean isValid(String hubby, ConstraintValidatorContext arg1) {
		if (hubby == null)
			return false;

		if (hubby.matches("Music|Cricket|Study"))
			return true;
		else
			return false;
	}

	@Override
	public void initialize(IsValidHubby constraintAnnotation) {
		
	}
}
