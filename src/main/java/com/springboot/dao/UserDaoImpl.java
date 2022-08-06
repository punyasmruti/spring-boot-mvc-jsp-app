package com.springboot.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springboot.exceptions.UserNotFoundException;
import com.springboot.model.UserRegistration;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    private static Map<Long, UserRegistration> usersMap = new HashMap<>();
    // private static Map<Long, UserRegistration> usersMap = new ConcurrentHashMap<>();

    private static Long id = 0L;

    static {

        ++id;
        UserRegistration user1 = new UserRegistration();
        user1.setUserId(id);
        user1.setFirstname("Punyasmruti");
        user1.setAge(31);
        user1.setEmailId("punyasmruti@gmail.com");
        user1.setDob(new Date());
        usersMap.put(user1.getUserId(), user1);


        ++id;
        UserRegistration user2 = new UserRegistration();
        user2.setUserId(id);
        user2.setFirstname("Pankaj Kumar");
        user2.setAge(30);
        user2.setEmailId("Pankaj@gmail.com");
        user2.setDob(new Date());
        usersMap.put(user2.getUserId(), user2);
    }

    @PostConstruct
    public void init() {
        // System.out.println("inside init method");
    	log.info("Inside UserDaoImpl, Init method");
    }

    @Override
    public UserRegistration saveUserRegistration(UserRegistration user) {
        log.info("Insise UserDaoImpl saveUserRegistration:{}",user);
        ++id;
        user.setUserId(id);
        usersMap.put(id, user);
        return usersMap.get(user.getUserId());
    }

    @Override
    public UserRegistration getUserByUserId1(Long userId) {
        log.info("Indise UserDaoImpl , getUserByUserId for userId:{}",userId);
        return usersMap.get(userId);
    }

    @Override
    public List<UserRegistration> getAllUsers() {
        log.info("Indise UserDaoImpl getAllUsers");
        List<UserRegistration> usersAll = new ArrayList<>();
        Set<Long> set = usersMap.keySet();
        for (Long userId : set) {
            UserRegistration user = usersMap.get(userId);
            usersAll.add(user);
        }
        return usersAll;
    }

    @Override
    public UserRegistration updateUserRegistration(UserRegistration user) {
        log.info("Indise UserDaoImpl updateUserRegistration:{}",user);
        if (!usersMap.containsKey(user.getUserId())) throw new UserNotFoundException("User not found");
        usersMap.put(user.getUserId(), user);
        return usersMap.get(user.getUserId());
    }

    @Override
    public void deleteUserById(Long userId) {
        log.info("Indise UserDaoImpl deleteUserById:{}",userId);
        usersMap.remove(userId);
    }

    @Override
    public void deleteAllUsers() {
        log.info("Insise UserDaoImpl deleteAllUsers");
        usersMap.clear();
    }

    @PreDestroy
    public void destroy() {
        // System.out.println("User Dao impl obj destroyed");
    	log.info("Inside UserDaoImpl destroy method");
		usersMap = null;
    }

	@Override
	public UserRegistration getUserByUserId2(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithLastnameInAscendingOrder(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUserssByFirstname_WithLastnameInDescendingOrder(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithEmailInAscendingOrder(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithEmailInDescendingOrder(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithAgeInAscendingOrder(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithAgeInDescendingOrder(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> tansformAllFirstnamesToUppercase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Long, String> getUserIdAndEmailIDByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getLastnameAndEmailIdByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getFirstnameAndEmailIDByFirstnameWhereAgeGreaterThan30(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByLastname_WithFirstnameInAscendingOrder(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByLastname_WithFirstnameInDescendingOrder(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Long, String> getUserIdAndEmailIDByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Long, String> getContactIdAndEmailIDByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getFirstnameAndEmailIDByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRegistration getUserByEmailID1(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRegistration getUserByEmailID2(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getUserEmailAngAgeByEmailID(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByAge_WithFirstnameInDescendingOrder(int age1, int age2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getUsersEmailAndAgeByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countUsersByAgeRange(int age1, int age2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countUsersByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder2(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByMobileNo(Long MobileNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByBirthYear(String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserRegistration> getUsersByBirthDate_WithDobInDescendingOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUserEmails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countUsersByHobby(String hobby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Object, List<UserRegistration>> grouUserByAge(Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String joiningAllEmailsWithDelimiter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllEmails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserRegistration> minByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserRegistration> maxByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Boolean, Map<String, List<String>>> partitioningByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double averageAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, String> getEmailAndFirstNameByMobileNo(Long MobileNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
