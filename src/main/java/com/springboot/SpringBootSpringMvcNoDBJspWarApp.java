package com.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//When packaging to jar
//java -jar --server.port=8081 springboot_springmvc.jar
//java -jar -Dspring.config.location = C:\application_properties.txt springboot_springmvc.jar
//java -jar spring.profiles.active=dev springboot_springmvc.jar

//When packaging to war
//java -jar  --server.port=8081 springboot_springmvc.war
//java -jar -Dspring.config.location = C:\application_properties.txt springboot_springmvc.war
//java -jar spring.profiles.active=dev springboot_springmvc.war


//@Controller //this is optional

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
		// SpringApplication app = new SpringApplication(SpringBootMvcApp.class);
		// app.setBannerMode(Banner.Mode.OFF);
		// app.setBanner(new ImageBanner(new UrlResource("spring-boot.png")));
		//app.run(args);
	}

	/**
	 * ###########################################################################
	 * Optional
	 * ###########################################################################
	 */

	// ################### here we have exposed some spring web mvc interfaces.##############
	// @RequestMapping("/")
	//@RequestMapping("/home2")
	//public String home2() {
	//return "index"; // view page
	//}// http://localhost:8081/home2

	// @RequestMapping("/")
	//@RequestMapping("/home3")
	//public ModelAndView home3() {
	//return new ModelAndView("index");
	//}// http://localhost:8081/home3

	// #####################################################
	// here we have exposed some spring3 style rest interfaces.
	// ######################################################
	//@Value("${server.application.name}")
	//private String appname;

	/*@RequestMapping("/sampleRestUrl")
	@ResponseBody
	public String getAppname() {
		// returning from application_properties.txt file.
		return appname;
	}*/// http://localhost:8081/sampleRestUrl

	// ############## here we have created a spring4 style rest controller
	// class(static inner class). ################
	// OK
	/*@RestController
	private static class TheRestController {
		@RequestMapping("/hello123")
		public String handle() {
			return "message from rest handler";
		}// http://localhost:8081/hello123
	}*/
}
