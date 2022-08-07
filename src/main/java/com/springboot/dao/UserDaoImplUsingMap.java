package com.springboot.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.catalina.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	private static Long userId = 0L;
	private static final Map<Long, UserRegistration> usersMap = new HashMap<>();
	// private static Map<Long, UserRegistration> usersMap = new ConcurrentHashMap<>();
	static {

		UserRegistration user1 = new UserRegistration();
		user1.setUserId(++userId);
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
		user2.setUserId(++userId);
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
		user.setUserId(++userId);
		usersMap.put(userId, user);
		UserRegistration u = usersMap.get(user.getUserId());
		return u;
	}

	@Override
	public UserRegistration getUserByUserId1(Long userId)  {
		return usersMap.get(userId);
	}

	@Override
	public UserRegistration getUserByUserId2(Long userId) {
		//log.info("Inside userDaoImpl getUserByUserId :");
		return  usersMap.get(userId);
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

	//@Override
	public List<UserRegistration> getAllUsers2() {
	return new ArrayList<>(usersMap.values());
	}


	@Override
	public List<UserRegistration> getUsersByFirstname(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithLastnameInAscendingOrder(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.sorted(Comparator.comparing(UserRegistration::getLastname))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserRegistration> getUserssByFirstname_WithLastnameInDescendingOrder(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.sorted(Comparator.comparing(UserRegistration::getLastname).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithEmailInAscendingOrder(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.sorted(Comparator.comparing(UserRegistration::getEmailId)).collect(Collectors.toList());
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithEmailInDescendingOrder(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.sorted(Comparator.comparing(UserRegistration::getEmailId).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithAgeInAscendingOrder(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.sorted(Comparator.comparing(UserRegistration::getAge)).collect(Collectors.toList());
	}

	@Override
	public List<UserRegistration> getUsersByFirstname_WithAgeInDescendingOrder(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.sorted(Comparator.comparing(UserRegistration::getAge).reversed()).collect(Collectors.toList());
	}

	@Override
	public Map<Long, String> getUserIdAndEmailIDByFirstname(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.collect(Collectors.toMap(UserRegistration::getUserId, UserRegistration::getEmailId ));
	}

	//@Override
	public List<String> getEmailIsDByFirstname(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.map(UserRegistration::getEmailId).sorted(Collections.reverseOrder()).collect(Collectors.toList());
	}

	@Override
	public List<String> tansformAllFirstnamesToUppercase() {
		return usersMap.values()
				.stream()
				.map(userRegistration -> userRegistration.getFirstname().toUpperCase())
				.collect(Collectors.toList());
	}

	@Override
	public Map<String, String> getLastnameAndEmailIdByFirstname(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.collect(Collectors.toMap(UserRegistration::getLastname, UserRegistration::getEmailId ));
	}

	@Override
	public List<UserRegistration> getUsersByLastname(String lastname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getLastname().equalsIgnoreCase(lastname))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserRegistration> getUsersByLastname_WithFirstnameInAscendingOrder(String lastname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getLastname().equalsIgnoreCase(lastname))
				.sorted((e1,e2) -> e2.getFirstname().compareTo(e1.getFirstname()))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserRegistration> getUsersByLastname_WithFirstnameInDescendingOrder(String lastname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getLastname().equalsIgnoreCase(lastname))
				.sorted((e1,e2) -> e2.getFirstname().compareTo(e1.getFirstname()))
				.collect(Collectors.toList());
	}

	@Override
	public Map<Long, String> getUserIdAndEmailIDByLastname(String lastname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getLastname().equalsIgnoreCase(lastname))
				.sorted((e1,e2) -> e2.getFirstname().compareTo(e1.getFirstname()))
				.collect(Collectors.toMap(UserRegistration::getUserId,UserRegistration::getEmailId));
	}

	@Override
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder(Date date) {
		return null;
	}

	@Override
	public UserRegistration getUserByEmailID1(String email) {
		return usersMap.values().stream()
				.filter(userRegistration -> userRegistration.getEmailId().equalsIgnoreCase(email))
				.collect(Collectors.toList())
				.get(1);
	}

	@Override
	public List<UserRegistration> getUsersByMobileNo(Long MobileNo) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getMobileNos().contains(MobileNo))
				.collect(Collectors.toList());
	}

	@Override
	public Long countByFirstname(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname)).count();
	}

	@Override
	public Long countByLastname(String lastname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(lastname)).count();
	}

	@Override
	public Map<String, Integer> getUsersEmailAndAgeByAge(int age) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getAge() ==age)
				.collect(Collectors.toMap(UserRegistration::getEmailId,UserRegistration::getAge));
	}

	@Override
	public Long countUsersByAgeRange(int age1, int age2) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getAge() > age1 && userRegistration.getAge() < age2)
				.count();
	}

	@Override
	public UserRegistration getUserByEmailID2(String email) {
		return usersMap
				.values()
				.stream().filter(userRegistration -> userRegistration.getEmailId().equalsIgnoreCase(email))
				.collect(Collectors.toList()).get(1);
	}

	@Override
	public Map<String, Integer> getUserEmailAngAgeByEmailID(String email) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getEmailId().equalsIgnoreCase(email))
				.collect(Collectors.toMap(UserRegistration::getEmailId, UserRegistration::getAge));
	}

	@Override
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder2(String date) {
		return null;
	}

	@Override
	public Map<String, String> getFirstnameAndEmailIDByFirstnameWhereAgeGreaterThan30(String firstname) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getAge() > 30)
				.filter(userRegistration -> userRegistration.getFirstname().equalsIgnoreCase(firstname))
				.collect(Collectors.toMap(UserRegistration::getEmailId,UserRegistration::getFirstname));
	}

	@Override
	public List<UserRegistration> getUsersByAge_WithFirstnameInDescendingOrder(int age1, int age2) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getAge() > age1 && userRegistration.getAge() < age2)
				.collect(Collectors.toList());
	}

	@Override
	public Long countUsersByAge(int age) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getAge() == age)
				.count();
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
		return usersMap.values()
				.stream()
				.map(UserRegistration::getEmailId).collect(Collectors.toList());
	}
	@Override
	public Long countUsersByHobby(String hobby) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getHubbies().contains(hobby))
				.count();
	}
	//@Override
	public Map<String, List<UserRegistration>> groupUserByAge(Integer age) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getAge()>age)
				.collect(Collectors.groupingBy(user -> user.getAge() >= age ? "Senior" : "Junior"));
	}
	@Override
	public String joiningAllEmailsWithDelimiter() {
		return usersMap.values()
				.stream()
				.map(UserRegistration::getEmailId)
				.collect(Collectors.joining(","));
	}
	@Override
	public List<String> getAllEmails() {
		return usersMap.entrySet().
				stream()
				.map(e -> e.getValue().getEmailId())
				.collect(Collectors.toList());
	}

	@Override
	public Optional<UserRegistration> minByAge() {
		return Optional.of(
				usersMap.entrySet()
				.stream()
				.min((e1, e2) -> e2.getValue().getAge().compareTo(e1.getValue().getAge()))
				.get()
				.getValue());
	}
	@Override
	public Optional<UserRegistration> maxByAge() {
		/*return Optional.of(usersMap.entrySet()
				.stream()
				.sorted((e1,e2) -> e2.getValue().getAge().compareTo(e1.getValue().getAge()))
				.max()
				.get()
				.getValue());*/
		return null;

	}
	@Override
	public Map<Boolean, Map<String, List<String>>> partitioningByAge() {
		return null;
	}

	public Map<String,  List<UserRegistration>> partitioningByFirstname() {
		return null;
	}

	public Map<String,  List<UserRegistration>> partitioningByLastname() {
		return null;
	}

	public Map<Integer,  List<UserRegistration>> partitioningByAge2() {
		return null;
	}

	@Override
	public Double averageAge() {
		return  usersMap.values().stream().collect(Collectors.averagingDouble(UserRegistration::getAge));
	}

	@Override
	public Map<String,String> getEmailAndFirstNameByMobileNo(Long MobileNo) {
		return usersMap.values()
				.stream()
				.filter(userRegistration -> userRegistration.getMobileNos().contains(MobileNo))
				.collect(Collectors.toMap(UserRegistration::getEmailId,UserRegistration::getFirstname));
	}

	@Override
	public UserRegistration updateUserRegistration(UserRegistration user) {
		//log.info("Indise UserDaoImpl updateUserRegistration:{}",user);
		if (!usersMap.containsKey(user.getUserId())) throw new UserNotFoundException("User not found");
		usersMap.put(user.getUserId(), user);
		return usersMap.get(user.getUserId());
	}


	@Override
	public void deleteAllUsers() {
		log.info("Inside userDaoImpl deleteAllUsers :");
		// usersMap.clear();
	}

	@Override
	public void deleteUserById(Long userId) {
		//log.info("Indise UserDaoImpl deleteUserById:{}",userId);
		usersMap.remove(userId);
	}

	@PreDestroy
	public void destroy() {
		log.info("userDaoImpl obj has destroyed");
	}
}
