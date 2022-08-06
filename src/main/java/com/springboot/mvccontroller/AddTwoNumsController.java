package com.springboot.mvccontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddTwoNumsController {

	/**
	 * Here Only client side form validation using Java script and using
	 * HttpServletRequest obj to gather input data from client.
	 */

	@GetMapping("/addPage1")
	public String showAddPage() {
		return "addForm";
	}

	@PostMapping(value = "/add1")
	public String doAdd(HttpServletRequest request) {
		int result = Integer.parseInt(request.getParameter("num1")) + Integer.parseInt(request.getParameter("num2"));
		request.setAttribute("addResult", result);
		return "addResult";
	}
}
