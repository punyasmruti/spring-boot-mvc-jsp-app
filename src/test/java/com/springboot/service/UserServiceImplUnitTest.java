package com.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import  org.junit.Assert;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springboot.dao.UserDao;
import com.springboot.model.UserRegistration;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplUnitTest {

	@InjectMocks
	//private UserService userService; // will not work, because this is unit test
	private UserServiceImpl userServiceImpl;
	
	// @MockBean //OK
	@Mock
	private UserDao userDao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * ##############################################################################################################################
	 * Insert Operation
	 * ##############################################################################################################################
	 */

	
	@Test
	public void testSaveUserRegistration() throws Exception {
		
		Assertions.assertThat(this.userServiceImpl).isNotNull();
		Assertions.assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.saveUserRegistration(user)).thenReturn(user);
		UserRegistration userCreated = userServiceImpl.saveUserRegistration(user);
		Assertions.assertThat(userCreated.getEmailId()).isSameAs(user.getEmailId());
		Mockito.verify(userDao, Mockito.times(1)).saveUserRegistration(user);
	}

	/**
	 * ##############################################################################################################################
	 * Select Operation
	 * ##############################################################################################################################
	 */

	// @Test(expected=NullPointerException.class)
	//// @Test(expected=UserNotFoundException.class)
	@Test
	public void testGetUserByUserId() throws Exception {
		Assertions.assertThat(this.userServiceImpl).isNotNull();
		Assertions.assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(),Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.getUserByUserId2(1L)).thenReturn(user);
		UserRegistration u = userServiceImpl.getUserByUserId(1L);
		Assertions.assertThat(u.getEmailId()).isNotEmpty();
		Assert.assertEquals("punyasmruti", u.getFirstname());
		Mockito.verify(userDao, Mockito.times(1)).getUserByUserId2(1L);
	}

	@Test
	public void testGetAllUsers() throws Exception {
		Assertions.assertThat(this.userServiceImpl).isNotNull();
		Assertions.assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(),Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		List<UserRegistration> list = new ArrayList<>();
		list.add(user);
		Mockito.when(userDao.getAllUsers()).thenReturn(list);
		List<UserRegistration> usersList = userServiceImpl.getAllUsers();
		Assert.assertEquals(1, usersList.size());
		Mockito.verify(userDao, Mockito.times(1)).getAllUsers();
	}

	/**
	 * ##############################################################################################################################
	 * Update Operation
	 * ##############################################################################################################################
	 */

	@Test
	public void testupdateUserRegistration() throws Exception {
		Assertions.assertThat(this.userServiceImpl).isNotNull();
		Assertions.assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(),Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.updateUserRegistration(user)).thenReturn(user);
		UserRegistration u = userServiceImpl.updateUserRegistration(user);
		Assertions.assertThat(user.getEmailId()).isSameAs(u.getEmailId());
		Mockito.verify(userDao, Mockito.times(1)).updateUserRegistration(user);
		
	}

	/**
	 * ##############################################################################################################################
	 * Delete Operation
	 * ##############################################################################################################################
	 * 
	 * 
	 */

	@Test
	public void deleteUserByUserId() throws Exception {
		Assertions.assertThat(this.userServiceImpl).isNotNull();
		Assertions.assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(),Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		Mockito.when(userDao.getUserByUserId2(1L)).thenReturn(user);
		Mockito.doNothing().when(userDao).deleteUserById(Mockito.anyLong());
		userServiceImpl.deleteUserByUserId(1L);
		Mockito.verify(userDao, Mockito.times(1)).deleteUserById(1L);
	}

	@Test
	public void deleteAllUsers() throws Exception {
		Assertions.assertThat(this.userServiceImpl).isNotNull();
		Assertions.assertThat(this.userDao).isNotNull();
		Mockito.doNothing().when(userDao).deleteAllUsers();
		userServiceImpl.deleteAllUsers();
		Mockito.verify(userDao, Mockito.times(1)).deleteAllUsers();
	}
}
