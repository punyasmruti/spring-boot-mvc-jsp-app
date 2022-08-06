package com.springboot.mvccontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.springboot.model.UserRegistration;
import com.springboot.service.UserService;

import java.util.Arrays;
import java.util.Date;

//@AutoConfigureMockMvc 
//Different ways:
//using MockMvc in stand alone mode , only with springRunner.. - This will not start the internal embedded tomcat server. and loading the entire context.
//@RunWith(MockitoJUnitRunner.class) //Not OK
//@RunWith(SpringJUnit4ClassRunner.class) //OK
@RunWith(SpringRunner.class) // OK
@WebMvcTest(controllers = UserMvcControllerCrud.class)
//@WebMvcTest(UserMvcController.class)//OK
public class UserMvcControllerUnitTest1 {

	@Autowired
	private WebApplicationContext webApplicationContext;

	// @Autowired //OK
	private MockMvc mockMvc;

	@InjectMocks
	private UserMvcControllerCrud userMvcController; //OK but optional

	@MockBean
	private UserService userService;
	// private UserServiceImpl userServiceImpl; //Ok

	private UserRegistration user = null;

	@Before
	public void setup() {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);
		// this.mockMvc = MockMvcBuilders.standaloneSetup(new UserMvcController()).build();//OK
		// this.mockMvc = MockMvcBuilders.standaloneSetup(userMvcController).build();//OK
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		UserRegistration exsistingUser =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
	}

	@Test
	public void testShowUserRegisterform() throws Exception {
		
		assertThat(this.userMvcController).isNotNull();
		assertThat(this.userService).isNotNull();
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/register"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(view().name("userRegistrationForm"))
				.andExpect(MockMvcResultMatchers.view().name("userRegistrationForm")).andDo(print());
	}

	@Test
	public void testsaveUserRegistration() throws Exception {
		// Mockito.when(userService.buy(any(User.class),6)).thenThrow(new
		// InsufficientProductsException("For Testing"));
		/*
		 * this.mockMvc.perform(post("/register") .param("email", "mvcemail@test.com")
		 * .param("firstName", "mvcfirst") .param("lastName", "mvclastname"))
		 * .andExpect(status().isOk())
		 * .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
		 * .andExpect(model().attributeExists("page_error"));
		 */
	}

	@Test
	public void testViewAllUsers() throws Exception {
		
		Assertions.assertThat(this.userService).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("viewAllRegisteredUsers"));
	}

	@Test
	public void testEditUserForm() throws Exception {

		Assertions.assertThat(this.userService).isNotNull();
		Mockito.when(userService.getUserByUserId(1L)).thenReturn(user);
		this.mockMvc.perform(get("/edituser/{userId}", 1))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("userEditRegistrationForm"))
				.andReturn();

		Mockito.verify(userService, times(1)).getUserByUserId(1L);
		Mockito.verifyNoMoreInteractions(userService);

	}
}
