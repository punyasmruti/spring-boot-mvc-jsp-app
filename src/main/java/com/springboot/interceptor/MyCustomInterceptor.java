package com.springboot.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
//public class MyCustomInterceptor implements HandlerInterceptor {
public class MyCustomInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger log = LoggerFactory.getLogger(MyCustomInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long startTime = System.currentTimeMillis();

        //System.out.println("preHandle interceptor is called");
        log.info("Request URL: " + request.getRequestURL());
        //System.out.println("Start Time: " + startTime);

        request.setAttribute("startTime", startTime);

        // write ur own login here for specic requirement.
        Calendar c = Calendar.getInstance();
        @SuppressWarnings("static-access") int dayOfweek = c.get(c.DAY_OF_WEEK);
        if (dayOfweek == 1) {
            response.getWriter().write("Please visit this website except sunday");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle interceptor is called");
        log.info("Request URL: " + request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("afterCompletion interceptor is called");
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        //System.out.println("Request URL: " + request.getRequestURL());
        //System.out.println("End Time: " + endTime);
        log.info("Time Taken: " + (endTime - startTime));
    }
}
