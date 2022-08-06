package com.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT) //409
public class EmiailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -4632443851454903594L;

	private String msg;

	public EmiailAlreadyExistsException() {
	}

	public EmiailAlreadyExistsException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}