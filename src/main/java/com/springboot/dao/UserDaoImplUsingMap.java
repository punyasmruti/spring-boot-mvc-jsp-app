package com.springboot.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.springboot.exceptions.UserNotFoundException;
import com.springboot.model.UserRegistration;
import com.springboot.mvccontroller.SpringMvcTutorialsController;


//@Profile({"default","dev", "qa","uat","prod"})
//@Primary
@Repository
//@Slf4j
public class UserDaoImplUsingMap implements UserDao {
	
	private Log log = LogFactory.getLog(SpringMvcTutorialsController.class);
	private static Long id = 0L;
	private static Map<Long, UserRegistration> usersMap = new HashMap<>();
	// private static Map<Long, UserRegistration> usersMap = new ConcurrentHashMap<>();
	static {

		UserRegistration user1 = new UserRegistration();
		user1.setUserId(++id);
		user1.setFirstname("Punyasmruti");
		user1.setLastname("Nayak");
		user1.setAge(31);
		user1.setEmailId("Punyasmruti@gmail.com");
		try {
			user1.setDob(new SimpleDateFormat("dd MMM yyyy").parse("11 May 1980"));
			//user1.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("11/05/1980"));//ok
		} catch (ParseException e) {
			e.printStackTrace();
		}

		UserRegistration user2 = new UserRegistration();
		user2.setUserId(++id);
		user2.setFirstname("Pankaj kumar");
		user2.setLastname("Prajapati");
		user2.setAge(30);
		user2.setEmailId("Pankaj@gmail.com");
		try {
			user2.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("18/05/1990"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		usersMap.put(user1.getUserId(), user1);
		usersMap.put(user2.getUserId(), user2);
	}

	@PostConstruct
	public void init() {
		log.info("userDaoImpl obj has created");
	}

	@Override
	public UserRegistration saveUserRegistration(UserRegistration user) {
		log.info("Inside userDaoImpl saveUserRegistration :");
		++id;
		user.setUserId(id);
		usersMap.put(id, user);
		UserRegistration u = usersMap.get(user.getUserId());
		//log.debug("UserRegistration = {}",u);
		return u;
	}
	@Override
	public UserRegistration getUserByUserId1(Long userId)  {
		return null;
	}

	@Override
	public UserRegistration getUserByUserId2(Long userId) {
		//log.info("Inside userDaoImpl getUserByUserId :");
		UserRegistration user = usersMap.get(userId);
		//log.debug("user = {}",user);
		return user;
	}
	@Override
	public List<UserRegistration> getAllUsers() {
		log.info("Inside userDaoImpl getAllUsers :");
		List<UserRegistration> usersAll = new ArrayList<UserRegistration>();
		Set<Long> set = usersMap.keySet();
		for (Long userId : set) {
			UserRegistration user = usersMap.get(userId);
			usersAll.add(user);
		}
		//log.debug("All users = {}",usersAll);
		return usersAll;
	}
	@Override
	public UserRegistration updateUserRegistration(UserRegistration user) {
		log.info("Inside userDaoImpl updateUserRegistration :");
		if (!usersMap.containsKey(user.getUserId()))
			throw new UserNotFoundException("User not found");
		usersMap.put(user.getUserId(), user);
		return usersMap.get(user.getUserId());
	}

	@Override
	public void deleteUserById(Long userId) {
		log.info("Inside userDaoImpl deleteUserById :");
		usersMap.remove(userId);
	}

	@Override
	public void deleteAllUsers() {
		log.info("Inside userDaoImpl deleteAllUsers :");
		// usersMap.clear();
	}
	@Override
	public UserRegistration getUserByEmailID1(String email) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname(String firstname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithLastnameInAscendingOrder(String firstname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUserssByFirstname_WithLastnameInDescendingOrder(String firstname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithEmailInAscendingOrder(String firstname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithEmailInDescendingOrder(String firstname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithAgeInAscendingOrder(String firstname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithAgeInDescendingOrder(String firstname) {
		return null;
	}

	@Override
	public Map<Long, String> getUserIdAndEmailIDByFirstname(String firstname) {
		return null;
	}

	@Override
	public List<String> tansformAllFirstnamesToUppercase() {
		return null;
	}

	@Override
	public Map<String, String> getLastnameAndEmailIdByFirstname(String firstname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByLastname(String lastname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByLastname_WithFirstnameInAscendingOrder(String lastname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByLastname_WithFirstnameInDescendingOrder(String lastname) {
		return null;
	}

	@Override
	public Map<Long, String> getUserIdAndEmailIDByLastname(String lastname) {
		return null;
	}

	@Override
	public Map<Long, String> getContactIdAndEmailIDByLastname(String lastname) {
		return null;
	}

	@Override
	public Map<String, String> getFirstnameAndEmailIDByLastname(String lastname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder(Date date) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByMobileNo(Long MobileNo) {
		return null;
	}

	@Override
	public Long countByFirstname(String firstname) {
		return null;
	}

	@Override
	public Long countByLastname(String lastname) {
		return null;
	}

	@Override
	public Map<String, Integer> getUsersEmailAndAgeByAge(int age) {
		return null;
	}

	@Override
	public Long countUsersByAgeRange(int age1, int age2) {
		return null;
	}

	@Override
	public UserRegistration getUserByEmailID2(String email) {
		return null;
	}

	@Override
	public Map<String, Integer> getUserEmailAngAgeByEmailID(String email) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder2(String date) {
		return null;
	}

	@Override
	public Map<String, String> getFirstnameAndEmailIDByFirstnameWhereAgeGreaterThan30(String firstname) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByAge_WithFirstnameInDescendingOrder(int age1, int age2) {
		return null;
	}

	@Override
	public Long countUsersByAge(int age) {
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByBirthYear(String year) {
		return null;
	}
	@Override
	public List<UserRegistration> getUsersByBirthDate_WithDobInDescendingOrder() {
		return null;
	}
	@Override
	public List<String> getUserEmails() {
		return null;
	}
	@Override
	public Long countUsersByHobby(String hobby) {
		return null;
	}
	@Override
	public Map<Object, List<UserRegistration>> grouUserByAge(Integer age) {

		return null;
	}
	@Override
	public String joiningAllEmailsWithDelimiter() {
		return null;
	}
	@Override
	public List<String> getAllEmails() {
		return null;
	}

	@Override
	public Optional<UserRegistration> minByAge() {
		return null;
	}
	@Override
	public Optional<UserRegistration> maxByAge() {
		return null;
	}
	@Override
	public Map<Boolean, Map<String, List<String>>> partitioningByAge() {
		return null;
	}

	@Override
	public double averageAge() {
		return 0;
	}

	@Override
	public Map<String, String> getEmailAndFirstNameByMobileNo(Long MobileNo) {
		return null;
	}

	@PreDestroy
	public void destroy() {
		log.info("userDaoImpl obj has destroyed");
	}
}
