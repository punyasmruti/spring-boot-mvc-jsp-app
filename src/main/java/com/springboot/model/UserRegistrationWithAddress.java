package com.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class UserRegistrationWithAddress implements Serializable {

	private static final long serialVersionUID = 1859237294441659023L;

	// @Pattern(regexp = "[^a-z]*")
	// @NotEmpty //Ok
	@NotEmpty(message = "{NotEmpty.userRegistration.firstname}")
	@Size(min = 4, max = 15, message = "Firstname should be of Min {min} and Max {max} characters")
	private String firstname;

	// @NotEmpty //Ok
	@NotEmpty(message = "{NotEmpty.userRegistration.lastname}")
	@Size(min = 4, max = 15, message = "Lastname should be of min {min} and max {max} characters")
	private String lastname;

	// @Email
	@NotEmpty(message = "{NotEmpty.userRegistration.email}")
	// @NotEmpty
	private String emailId;

	@Positive(message = "Age must be greater than 0")
	@Min(value = 1, message = "{age.user.min}")
	@Range(min = 1, max = 100, message = "Age should be of Min {min} and Max {max}")
	private int age;

	@NotNull(message = "{user.birthday.notNull}")
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	// @Past
	@Past(message = "Date of birth must be a past date")
	// @Past(message = "{user.birthday.past}")
	// @PresentOrPast(message = "Date of birth must be past date")
	private Date dob;

	// @Max(value = 999999999, message = "invalid mobile no")
	// @Max(999999999) //ok
	// @Min(value = 1000000000, message = "invalid mobile no")
	private List<Long> mobileNos;

	// @Size(min = 5, max = 10)
	// @IsValidHubby
	private List<String> hubbies;

	@NotEmpty(message = "please enter your gender")
	private String gender;

	@NotEmpty(message = "Please select skills")
	private List<String> skills;

	private Address address; // user defined type
}
