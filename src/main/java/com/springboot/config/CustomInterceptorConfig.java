package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.interceptor.CustomLoggerInterceptor;
import com.springboot.interceptor.CustomInterceptor;

@Configuration
public class CustomInterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	private CustomLoggerInterceptor customLoggerInterceptor;

	@Autowired
	private CustomInterceptor myCustomInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// Custom interceptor, add intercept path and exclude intercept path
		registry.addInterceptor(customLoggerInterceptor).addPathPatterns("/**");
		registry.addInterceptor(myCustomInterceptor).addPathPatterns("/**");
	}
}
