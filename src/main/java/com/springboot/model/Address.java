package com.springboot.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Address implements Serializable {

	private static final long serialVersionUID = 6019348062635497048L;
	
	@NotBlank(message="Please provide city")
	private String city;
	
	@NotBlank(message="Please provide State")
	private String state;
	
	@NotBlank(message="Please provide Country")
	private String country;
}
