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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistration implements Serializable {

	private static final long serialVersionUID = 1293337135503757716L;

	private Long userId;

	// @Pattern(regexp = "[^a-z]*")
	// @NotEmpty //Ok
	@NotEmpty(message = "{NotEmpty.userRegistration.firstname}")
	@Size(min=4,max=15,message="Firstname should be of Min {min} and Max {max} characters")
	//@Size(min = 4, max = 15)
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

	@NotEmpty
	private String gender;

	//@NotEmpty
	private List<String> skills;
	
	// @Size(min = 5, max = 10)
	// @IsValidHubby
	private List<String> hubbies;

	
	
	/*public UserRegistration() {
		super();
	}

	public UserRegistration(Long userId,
			@NotEmpty(message = "{NotEmpty.userRegistration.firstname}") @Size(min = 4, max = 15) String firstname,
			@NotEmpty(message = "{NotEmpty.userRegistration.lastname}") @Size(min = 4, max = 15, message = "Lastname should be of min {min} and max {max} characters") String lastname,
			@NotEmpty(message = "{NotEmpty.userRegistration.email}") String emailId,
			@Positive(message = "Age must be greater than 0") @Min(value = 1, message = "{age.user.min}") @Range(min = 1, max = 100, message = "Age should be of Min {min} and Max {max}") int age,
			@NotNull(message = "{user.birthday.notNull}") @Past(message = "Date of birth must be a past date") Date dob,
			List<Long> mobileNos, List<String> hubbies, @NotEmpty String gender, @NotEmpty List<String> skills) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailId = emailId;
		this.age = age;
		this.dob = dob;
		this.mobileNos = mobileNos;
		this.hubbies = hubbies;
		this.gender = gender;
		this.skills = skills;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Long> getMobileNos() {
		return mobileNos;
	}

	public void setMobileNos(List<Long> mobileNos) {
		this.mobileNos = mobileNos;
	}

	public List<String> getHubbies() {
		return hubbies;
	}

	public void setHubbies(List<String> hubbies) {
		this.hubbies = hubbies;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "UserRegistration [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", emailId=" + emailId + ", age=" + age + ", dob=" + dob + ", mobileNos=" + mobileNos + ", gender="
				+ gender + ", skills=" + skills + ", hubbies=" + hubbies + "]";
	}*/

}
//9121291212
//757 rs 
//2104602 - acc no
//www.youbradband.com
// punya193 - username
// mobile app - quick pay
