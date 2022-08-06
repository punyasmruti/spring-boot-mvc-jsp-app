package com.springboot.model;

import javax.validation.constraints.Size;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UserLogin {

	// @NotEmpty(message = "Please provide login Username")
	private String loginUsername;

	// @NotEmpty(message = "Please provide login Password")
	@Size(min = 5, max = 10, message = "{Size.userform.password}")
	private String loginPassword;

	// @NotNull(message = "Please provide user type")
	// private Integer usertype;

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

}
