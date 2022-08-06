package com.springboot.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.springboot.model.UserRegistration;

public class UserDaoImplUnitTest1 {

	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		userDao = new UserDaoImplUsingMap();
	}

	@Test
	public void testSaveUserRegistration() {
		assertThat(this.userDao).isNotNull();
		UserRegistration user =  new UserRegistration(101L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(), Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		UserRegistration savedUser = userDao.saveUserRegistration(user);
		assertNotNull(savedUser.getUserId());
		assertThat(savedUser.getFirstname()).isNotNull();
		assertThat(savedUser.getEmailId()).isNotNull();

	}

	@Test
	public void getUserByUserIdTest() {
		assertThat(this.userDao).isNotNull();
		UserRegistration user = userDao.getUserByUserId2(1L);
		assertThat(user.getFirstname().equals("Punya"));
		assertThat(user.getEmailId().equals("Punya@gmail.com"));
	}

	@Test
	public void getAllUsersTest() {
		assertThat(this.userDao).isNotNull();
		List<UserRegistration> list = userDao.getAllUsers();
		assertThat(list).hasSize(2);
		UserRegistration user = list.get(0);
		assertThat(user.getFirstname().equals("Punya"));
		assertThat(user.getEmailId().equals("Punya@gmail.com"));
	}

	@Test
	public void testUpdateUserRegistration() {
		assertThat(this.userDao).isNotNull();
		UserRegistration exsistingUser =  new UserRegistration(1L,"punyasmruti","Nayak", "punyasmruti@gmail.com",40,new Date(),Arrays.asList(992428121L,6383609193L),"male",Arrays.asList("study","music"),Arrays.asList("java","oracle"));
		UserRegistration u = userDao.updateUserRegistration(exsistingUser);
		assertEquals(exsistingUser.getFirstname(), u.getFirstname());
		assertEquals(exsistingUser.getAge(), u.getAge());
		assertEquals(exsistingUser.getEmailId(), u.getEmailId());
	}

	@Test
	public void testDeleteUuserByUserId() throws Exception {
		assertThat(this.userDao).isNotNull();
		userDao.deleteUserById(2L);
	}
}
