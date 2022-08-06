package com.springboot.service;

import java.util.List;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserDao;
import com.springboot.exceptions.UserNotFoundException;
import com.springboot.model.UserRegistration;
import com.springboot.mvccontroller.SpringMvcTutorialsController;

//@Profile("dev")
//@Profile("!dev")
//@Profile({"default","dev", "qa","uat","prod"})
@Service
//@Slf4j
public class UserServiceImpl implements UserService {

	// private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	// //apache commons
	// logging
	private Logger log = LoggerFactory.getLogger(SpringMvcTutorialsController.class);

	@Autowired
	private UserDao userDao;

	@Override
	public UserRegistration saveUserRegistration(UserRegistration user) {
		log.info("inside UserServiceImpl saveUserRegistration :");
		return userDao.saveUserRegistration(user);
	}

	@Override
	public UserRegistration getUserByUserId(Long userId) {
		log.info("inside UserServiceImpl getUserByUserId :");
		return userDao.getUserByUserId2(userId);
	}

	@Override
	public List<UserRegistration> getAllUsers() {
		log.info("inside UserServiceImpl getAllUsers :");
		return userDao.getAllUsers();
	}

	@Override
	public boolean validateUserLogin(String username, String password) {
		log.info("inside UserServiceImpl validateUserLogi n:");
		if (username.equalsIgnoreCase("punya") && password.equalsIgnoreCase("punya"))
			return true;
		else
			return false;
	}

	@Override
	public UserRegistration updateUserRegistration(UserRegistration user) {
		log.info("inside UserServiceImpl updateUserRegistration :");
		if (null != user.getUserId())
			return userDao.updateUserRegistration(user);
		else
			throw new UserNotFoundException("Invalid User:");
	}

	@Override
	public void deleteUserByUserId(Long userId) {

		log.info("Inside UserServiceImpl: Delete user:{}", userId);
		UserRegistration user = userDao.getUserByUserId2(userId);
		if (null != user)
			userDao.deleteUserById(userId);
		else
			throw new UserNotFoundException("User not found with ID :" + userId);
	}

	@Override
	public void deleteAllUsers() {
		log.info("Inside UserServiceImpl: Delete all users ");
		userDao.deleteAllUsers();
	}
}
