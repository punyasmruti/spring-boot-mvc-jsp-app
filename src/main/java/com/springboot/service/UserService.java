package com.springboot.service;

import java.util.List;

import com.springboot.model.UserRegistration;

public interface UserService {
	
	public UserRegistration saveUserRegistration(UserRegistration userRegistration) ;
	public UserRegistration getUserByUserId(Long userId) ;
	
	public List<UserRegistration> getAllUsers();
	
	public UserRegistration updateUserRegistration(UserRegistration userRegistration);
	
	public void deleteUserByUserId(Long userId);
	public void deleteAllUsers();
	public boolean validateUserLogin(String username, String password);

}
