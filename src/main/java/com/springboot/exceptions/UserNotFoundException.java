package com.springboot.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private String msg;

	public UserNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
}
