package com.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
//public class CustomLoggerInterceptor implements HandlerInterceptor{
public class CustomLoggerInterceptor extends HandlerInterceptorAdapter{
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	//1
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		log.info("preHandle interceptor is called");
		
		log.info("Request URL: " + request.getRequestURL());
		log.info("Request Executing : "+request.getRequestURI());
		
		long startTime = System.currentTimeMillis();
		log.info("Start Time: " + startTime);

		request.setAttribute("startTime", startTime);

		// write ur own login here for specic requirement.
		/*Calendar c = Calendar.getInstance();
		
		int dayOfweek = c.get(c.DAY_OF_WEEK);
		if (dayOfweek == 4) {
			response.getWriter().write("Please visit this website except saturday");
			return false;
		} else {
			return true;
		}*/
		
		return true;
	}
	
	//2
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		log.info("Request URL: " + request.getRequestURL());
	}
	
	//3
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,@Nullable Exception ex) throws Exception {
		
		log.info("afterCompletion interceptor is called");
		log.info("Request URL: " + request.getRequestURL());
		
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();

		log.info("Time Taken: " + (endTime - startTime));
	}
}
