package com.springboot.mvccontroller;
/*
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyErrorController implements ErrorController {

	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {

		String errorPage = "error"; // default error page

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.BAD_REQUEST.value()) {
				// handle HTTP 400 bad request
				errorPage = "error/400";

			} else if (statusCode == HttpStatus.NOT_FOUND.value()) {
				// handle HTTP 404 Not Found error
				errorPage = "error/404";

			} else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
				// handle HTTP 401 unauthorized error
				errorPage = "error/401";

			} else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				// handle HTTP 403 Forbidden error
				errorPage = "error/403";

			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				// handle HTTP 500 Internal Server error
				errorPage = "error/500";
			}
		}

		return errorPage;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}*/
