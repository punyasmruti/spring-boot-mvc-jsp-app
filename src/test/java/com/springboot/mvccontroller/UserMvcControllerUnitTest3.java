package com.springboot.mvccontroller;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.model.UserRegistration;
import com.springboot.service.UserService;

import java.util.Arrays;
import java.util.Date;

@AutoConfigureMockMvc(secure = false) // added this
//@RunWith(MockitoJUnitRunner.class) //Not OK
//@RunWith(SpringJUnit4ClassRunner.class)//OK
@RunWith(SpringRunner.class) // OK
@SpringBootTest
public class UserMvcControllerUnitTest3 {

	// @Autowired
	// private WebApplicationContext webApplicationContext;

	@Autowired // added @Autowired here., becoz we are using @AutoConfigureMockMvc.
	private MockMvc mockMvc;

	@Autowired
	UserMvcControllerCrud userMvcController; //optional

	// @Mock //OK
	@MockBean
	private UserService userService;
	// private UserServiceImpl userServiceImpl; //Ok

	private UserRegistration user = null;

	@Before
	public void setUp() {
		// This is not required here.
		// this.mockMvc = MockMvcBuilders.standaloneSetup(new UserMvcController()).build();//OK
		// this.mockMvc = MockMvcBuilders.standaloneSetup(userMvcController).build();//OK
		// this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //Ok
		 user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
	}

	@Test
	public void testShowUserRegisterform() throws Exception {
		Assertions.assertThat(this.userMvcController).isNotNull();
		Assertions.assertThat(this.userService).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/register"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("userRegistrationForm"));
	}

	@Test
	public void testViewAllUsers() throws Exception {
		Assertions.assertThat(this.userMvcController).isNotNull();
		Assertions.assertThat(this.userService).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("viewAllRegisteredUsers"));
	}

	@Test
	public void testEditUserForm() throws Exception {
		Assertions.assertThat(this.userMvcController).isNotNull();
		Assertions.assertThat(this.userService).isNotNull();
		Mockito.when(userService.getUserByUserId(1L)).thenReturn(user);
		mockMvc.perform(get("/edituser/{userId}", 1))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("userEditRegistrationForm"));

		Mockito.verify(userService, times(1)).getUserByUserId(1L);
		Mockito.verifyNoMoreInteractions(userService);

	}
}
