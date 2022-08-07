package com.springboot.config;
/*package com.springboot.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@ConfigurationProperties(prefix = "message", value = "classpath:messages.properties")
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springboot")
// public class SpringWebMvcConfig implements WebMvcConfigurer {
// OR
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// for UI/view pages
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	// below 2 are for UI pages server side form validation.
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		//ResourceBundleMessageSource source = new org.springframework.context.support.ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:messages");
		return source;
	}
	
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	// for UI static resources(js,css,img) to use in jsp pages.
	//.js file for client side validations.
	// This static folder is under webapp folder.
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry resourceHandlerRegistry) {
		resourceHandlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/static/");
		// resourceHandlerRegistry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	}
	
	//configuring custom interceptor
	
	@Bean
    DemoInterceptor demoInterceptor() {
         return new DemoInterceptor();
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }
}
*/