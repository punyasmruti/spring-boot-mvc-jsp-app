package com.springboot.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.springboot.model.UserRegistration;

public interface UserDao {
	
	
	/**
	 * #################
	 * Insert Operations
	 * #################
	 */
	
	public UserRegistration saveUserRegistration(UserRegistration userRegistration) ;
	
	/**
	 * #################
	 * Select Operations
	 * #################
	 */

	/**
	 * #################
	 * @param userId
	 * @return
	 * * #################
	 */

	//by userId
	public UserRegistration getUserByUserId1(Long userId) ;
	public UserRegistration getUserByUserId2(Long userId) ;

	public List<String> getUserEmails();
	
	//by firstname
	public List<UserRegistration> getUsersByFirstname(String firstname);
	public List<UserRegistration> getUsersByFirstname_WithLastnameInAscendingOrder(String firstname);
	public List<UserRegistration> getUserssByFirstname_WithLastnameInDescendingOrder(String firstname);
	public List<UserRegistration> getUsersByFirstname_WithEmailInAscendingOrder(String firstname);
	public List<UserRegistration> getUsersByFirstname_WithEmailInDescendingOrder(String firstname);
	public List<UserRegistration> getUsersByFirstname_WithAgeInAscendingOrder(String firstname);
	public List<UserRegistration> getUsersByFirstname_WithAgeInDescendingOrder(String firstname);
	public List<String> tansformAllFirstnamesToUppercase();
	public Long countByFirstname(String firstname) ;
	public Map<Long, String> getUserIdAndEmailIDByFirstname(String firstname);
	public Map<String, String> getLastnameAndEmailIdByFirstname(String firstname);
	public Map<String, String> getFirstnameAndEmailIDByFirstnameWhereAgeGreaterThan30(String firstname);
	
	//by lastname
	public List<UserRegistration> getUsersByLastname(String lastname);
	public List<UserRegistration> getUsersByLastname_WithFirstnameInAscendingOrder(String lastname);
	public List<UserRegistration> getUsersByLastname_WithFirstnameInDescendingOrder(String lastname);
	public Map<Long, String> getUserIdAndEmailIDByLastname(String lastname);
	public Long countByLastname(String lastname);
	
	//by email 
	public UserRegistration getUserByEmailID1(String email);
	public UserRegistration getUserByEmailID2(String email);
	public Map<String,Integer> getUserEmailAngAgeByEmailID(String email);
	public String joiningAllEmailsWithDelimiter();
	public List<String> getAllEmails();
	
	//by age
	public List<UserRegistration> getUsersByAge_WithFirstnameInDescendingOrder(int age1,int age2);
	public Map<String,Integer> getUsersEmailAndAgeByAge(int age);
	public Long countUsersByAgeRange(int age1,int age2) ;
	public Long countUsersByAge(int age);
	public Map<String,List<UserRegistration>> groupUserByAge(Integer age);
	public Optional<UserRegistration> minByAge();
	public Optional<UserRegistration> maxByAge();
	public  Map<Boolean,Map<String, List<String>>> partitioningByAge();
	public Double averageAge();
	
	//by dob
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder(Date date);
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder2(String date);
	public List<UserRegistration> getUsersByBirthYear(String year);
	public List<UserRegistration> getUsersByBirthDate_WithDobInDescendingOrder();
	
	//by mobileNo
	public List<UserRegistration> getUsersByMobileNo(Long MobileNo);
	public Map<String,String> getEmailAndFirstNameByMobileNo(Long MobileNo);
	
	public List<UserRegistration> getAllUsers();
	
	//hobby
	public Long countUsersByHobby(String hobby);
	
	/**
	 * #################
	 * Update Operations
	 * #################
	 */
	public UserRegistration updateUserRegistration(UserRegistration userRegistration);
	
	/**
	 * #################
	 * Delete Operations
	 * #################
	 */
	public void deleteUserById(Long userId);
	//public void deleteUserByEmailId(String emailId);
	public void deleteAllUsers();
}
