package com.springboot.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserRestControllerCrud {

	Logger log = LoggerFactory.getLogger(this.getClass()); // slf4j logging

	@RequestMapping(value = "/api/rest/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		log.info("Inside UserRestController hello()");
		return "Hello Spring Boot";
	}// http://localhost:8081/api/rest/hello

}
