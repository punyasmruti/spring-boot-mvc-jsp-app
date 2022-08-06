package com.springboot.service;

//import static org.mockito.Mockito.times;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
//import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.SpringBootSpringMvcNoDBJspWarApp;
import com.springboot.dao.UserDao;
import com.springboot.model.UserRegistration;
import com.springboot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSpringMvcNoDBJspWarApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserServiceImplIntegretionTest02 {

	@LocalServerPort
	private int port;

	@Autowired // mark here , //OK , Here we are not mocking the dao layer.
	private UserService userService;
	
	// @Mock //OK  , Here we are  mocking the dao layer.
	@MockBean 
	private UserDao userDao;
	
	@Test
	public void saveUserTest() {
		assertThat(this.userService).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(),Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.saveUserRegistration(user)).thenReturn(user);
		assertEquals(user, userService.saveUserRegistration(user));
	}

	@Test
	public void testGetUserByUserId() throws Exception {
		assertThat(this.userService).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(),Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.getUserByUserId2(1L)).thenReturn(user);
		UserRegistration u = userService.getUserByUserId(1L);
		assertThat(u.getEmailId()).isNotEmpty();
		assertEquals("punya", u.getFirstname());
	}

	@Test
	public void testGetAllUsers() throws Exception {
		assertThat(this.userService).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		List<UserRegistration> list = new ArrayList<>();
		list.add(user);
		Mockito.when(userDao.getAllUsers()).thenReturn(list);
		List<UserRegistration> usersList = userService.getAllUsers();
		assertEquals(1, usersList.size());
	}
	
	@Test
	public void updateUserTest() {
		assertThat(this.userService).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(),Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userService.updateUserRegistration(user)).thenReturn(user);
		Assert.assertEquals(user, userService.updateUserRegistration(user));
	}

	/*
	 * @Test public void deleteUserById() throws Exception {
	 * userService.deleteUserById(1L); }
	 */
	/*
	 * @Test public void deleteAllUsers() throws Exception {
	 * userService.deleteAllUsers(); }
	 */
}
