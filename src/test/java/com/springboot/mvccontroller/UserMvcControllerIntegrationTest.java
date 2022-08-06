package com.springboot.mvccontroller;
/*
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.springboot.SpringBootSpringMvcNoDBJspWarApp;

//@AutoConfigureMockMvc //OK
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSpringMvcNoDBJspWarApp.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserMvcControllerIntegrationTest {
	
	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	// @Autowired //OK
	MockMvc mockMvc;
	
	@LocalServerPort
	private int port;

	//@Autowired
	//UserMvcController userMvcController; //OK , optional
	
	//for testing rest api
	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setUp() {
		//this.mockMvc = MockMvcBuilders.standaloneSetup(this.userMvcController).build(); //Ok
		//OR
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //Ok
	}
	
	@Test
	public void testShowUserRegisterform() throws Exception {
		assertThat(this.mockMvc).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/register"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("userRegistrationForm1"))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testSaveUser() throws Exception {
		assertThat(this.mockMvc).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.post("/register"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("userRegistrationForm1"))
		.andDo(MockMvcResultHandlers.print());
	}
	

	@Test
	public void testShowAllUsers() throws Exception {
		assertThat(this.mockMvc).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("viewAllRegisteredUsers"))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Ignore
	@Test
	public void editUserForm() throws Exception {
		assertThat(this.mockMvc).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/edituser/1"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("userEditRegistrationForm"))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate).isNotNull();
		Assertions.assertThat(this.restTemplate).isNotNull();
		Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/rest/hello",String.class))
		.contains("Hello Spring Boot");
	}
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		assertThat(this.mockMvc).isNotNull();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/rest/hello"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello Spring Boot")));
	}
}
*/