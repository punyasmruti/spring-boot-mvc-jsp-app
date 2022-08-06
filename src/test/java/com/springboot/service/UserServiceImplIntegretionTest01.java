package com.springboot.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.SpringBootSpringMvcNoDBJspWarApp;
import com.springboot.dao.UserDao;
import com.springboot.model.UserRegistration;
import com.springboot.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
// @RunWith(SpringRunner.class) //OK
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringBootSpringMvcNoDBJspWarApp.class)
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserServiceImplIntegretionTest01 {

	@Autowired
	private UserService userService;

	// @Mock //OK  , Here we are  mocking the dao layer.
	@MockBean 
	private UserDao userDao;

	/**
	 * ########################################################################################################################
	 * Insert Operation
	 * ########################################################################################################################
	 */

	@Test
	public void saveUserTest() {
		assertThat(this.userService).isNotNull();
		assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.saveUserRegistration(user)).thenReturn(user);
		assertEquals(user, userService.saveUserRegistration(user));
	}
	
	
	/**
	 * ########################################################################################################################
	 * Select Operation
	 * ########################################################################################################################
	 */

	@Test
	public void testGetUserById() {
		assertThat(this.userService).isNotNull();
		assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.getUserByUserId2(1L)).thenReturn(user);
		assertSame(user.getEmailId(), userService.getUserByUserId(1L).getEmailId());
	}

	@Test
	public void testGetAllUsers() {
		assertThat(this.userService).isNotNull();
		assertThat(this.userDao).isNotNull();

		UserRegistration user1 =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		UserRegistration user2 =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));

		List<UserRegistration> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);

		Mockito.when(userDao.getAllUsers()).thenReturn(userList);
		Assert.assertEquals(2, userService.getAllUsers().size());

	}

	/**
	 * ########################################################################################################################
	 * Update Operation
	 * ########################################################################################################################
	 */

	@Test
	public void updateUserTest() {
		assertThat(this.userService).isNotNull();
		assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.updateUserRegistration(user)).thenReturn(user);
		Assert.assertEquals(user, userService.updateUserRegistration(user));
	}

	/**
	 * ########################################################################################################################
	 * Delete Operation
	 * ########################################################################################################################
	 */
	@Test
	public void deleteUserById() throws Exception {
		assertThat(this.userService).isNotNull();
		assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.getUserByUserId2(1L)).thenReturn(user);
		Mockito.doNothing().when(userDao).deleteUserById(Mockito.anyLong());
		userService.deleteUserByUserId(1L);
		Mockito.verify(userDao, Mockito.times(1)).deleteUserById(1L);
	}

	@Test
	public void deleteAllUsers() throws Exception {
		assertThat(this.userService).isNotNull();
		assertThat(this.userDao).isNotNull();
		Mockito.doNothing().when(userDao).deleteAllUsers();
		userService.deleteAllUsers();
		Mockito.verify(userDao, Mockito.times(1)).deleteAllUsers();
	}
}
