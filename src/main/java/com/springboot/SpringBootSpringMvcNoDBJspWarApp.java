package com.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springboot")
@Configuration */
//OR
@SpringBootApplication
public class SpringBootSpringMvcNoDBJspWarApp extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootSpringMvcNoDBJspWarApp.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootSpringMvcNoDBJspWarApp.class);
	}

	public static void main(String[] args) {
		//logger.error("this is a error message");
		SpringApplication.run(SpringBootSpringMvcNoDBJspWarApp.class, args);
		// OR
		// To disable banner
		// SpringApplication app = new SpringApplication(SpringBootThymeleafWarApp.class);
		// app.setBannerMode(Banner.Mode.OFF);
	}
}
