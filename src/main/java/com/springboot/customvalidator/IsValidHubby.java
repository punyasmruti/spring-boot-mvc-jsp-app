package com.springboot.customvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HubbyValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHubby {

	String message() default "Please provide a valid hubby (accepted hubbies are Music,Cricket,Study)";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
