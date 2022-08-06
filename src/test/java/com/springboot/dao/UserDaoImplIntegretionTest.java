package com.springboot.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.SpringBootSpringMvcNoDBJspWarApp;
import com.springboot.model.UserRegistration;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringBootSpringMvcNoDBJspWarApp.class)
public class UserDaoImplIntegretionTest {

	@Autowired // mark here
	private UserDao userDao;

	@Test
	public void testSaveUserRegistration() {
		assertThat(this.userDao).isNotNull();
		UserRegistration newUser =  new UserRegistration(99L,"punyasmruti","Nayak", "punyasmruti99@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		UserRegistration savedUser = userDao.saveUserRegistration(newUser);
		assertNotNull(savedUser.getUserId());
		assertThat(savedUser.getFirstname()).isNotNull();
		assertThat(savedUser.getEmailId()).isNotNull();
	}

	@Ignore
	@Test
	public void testGetUserByUserId() throws Exception {
		assertThat(this.userDao).isNotNull();
		UserRegistration exsistingUser = userDao.getUserByUserId2(1L);
		assertThat(exsistingUser.getUserId()).isNotNull();
		assertThat(exsistingUser.getFirstname()).isNotNull();
		assertThat(exsistingUser.getEmailId()).isNotNull();
	}

	@Test
	public void testGetAllUsers() {
		assertThat(this.userDao).isNotNull();
		int totalNoOfUsers = userDao.getAllUsers().size();
		assertEquals(1, totalNoOfUsers);
	}

	@Ignore
	@Test
	public void testUpdateUserRegistration() {
		assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		UserRegistration u = userDao.updateUserRegistration(user);
		assertEquals(user.getFirstname(), u.getFirstname());
		assertEquals(user.getAge(), u.getAge());
		assertEquals(user.getEmailId(), u.getEmailId());
	}

	@Test
	public void testDeleteUuserByUserId() throws Exception {
		assertThat(this.userDao).isNotNull();
		userDao.deleteUserById(2L);
	}

	/*
	 * @Test public void testDeleteAllUsers() throws Exception {
	 * assertThat(this.userDao).isNotNull(); userDao.deleteAllUsers(); }
	 */
}
