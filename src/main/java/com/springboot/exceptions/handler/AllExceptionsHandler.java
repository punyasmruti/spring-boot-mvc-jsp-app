package com.springboot.exceptions.handler;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.UserRegistration;

//@Controller
//@Controller("/error")
@ControllerAdvice
//@ControllerAdvice(assignableTypes = { SpringMvcTutorialsController.class})
public class AllExceptionsHandler {

	private Log log = LogFactory.getLog(AllExceptionsHandler.class);
	
	@ModelAttribute(name="userRegistrationGlobal")
	public UserRegistration getCommonObjectGlobal() {
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(),Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		return user;
	}

	// if any RuntimeException occurs at run time then , it will redirect to
	// error.jsp view page.
	/*
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handleUserNotFoundException(UserNotFoundException ex) {
		Map<String, UserNotFoundException> model = new HashMap<String, UserNotFoundException>();
		model.put("exception", ex);
		return new ModelAndView("404", model);
	}*/
	
	/*
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleUserNotFoundException(NullPointerException ex) {
		Map<String, NullPointerException> model = new HashMap<String, NullPointerException>();
		model.put("exception", ex);
		return new ModelAndView("500", model);
	}*/
	

	/*if any RuntimeException occurs at run time then , it will redirect to RuntimeException.jsp view page.*/
	// ExceptionHandler({NullPointerException.class,ArrayIndexOutOfBoundsException.class, IOException.class})
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = RuntimeException.class)
	public ModelAndView handleException(HttpServletRequest req, HttpServletResponse res, Exception exception) {
		log.error("Request : " + req.getRequestURI() + " has raised an exception", exception);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/RuntimeException");
		modelAndView.addObject("exception", exception.getMessage());
		modelAndView.addObject("url", req.getRequestURL());
		return modelAndView;
		// return new ModelAndView("error");// view page
	}
	
}
