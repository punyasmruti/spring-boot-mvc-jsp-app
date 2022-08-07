package com.springboot.dao;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.springboot.exceptions.EmiailAlreadyExistsException;
import com.springboot.model.UserRegistration;
import com.springboot.mvccontroller.SpringMvcTutorialsController;

//@Profile({"default","dev", "qa","uat","prod"})
@Primary
@Repository
//@Slf4j
public class UserDaoImplUsingList implements UserDao {
	
	private Log log = LogFactory.getLog(SpringMvcTutorialsController.class);
	
	//private static List<UserRegistration> usersList = new ArrayList<>();
	private List<UserRegistration> usersList = null;
	private static Long id = 0l;


	/*static {
	
	UserRegistration user1 = new UserRegistration();
	user1.setUserId(++id);
	user1.setFirstname("Punyasmruti");
	user1.setLastname("Nayak");
	user1.setEmailId("punyasmruti@gmail.com");
	user1.setAge(40);
	try {
		//user1.setDob(new SimpleDateFormat("dd MMM yyyy").parse("11 May 1980"));
		user1.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1980-05-11"));//ok , default format of date
	} catch (ParseException e) {
		e.printStackTrace();
	}
	user1.setMobileNos(Arrays.asList(9962428121L, 6383609193L));
	user1.setHubbies(Arrays.asList("study","music"));
	user1.setGender("male");
	
	
	UserRegistration user2 = new UserRegistration();
	user2.setUserId(++id);
	user2.setFirstname("Parthasarathi");
	user2.setLastname("Beuria");
	user2.setEmailId("parthasarathi@gmail.com");
	user2.setAge(41);
	try {
		//user2.setDob(new SimpleDateFormat("dd MMM yyyy").parse("25 Nov 1979"));
		user2.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1979-09-26"));//ok , default format of date
	} catch (ParseException e) {
		e.printStackTrace();
	}
	user2.setGender("male");
	user2.setHubbies(Arrays.asList("study","cricket"));
	user2.setMobileNos(Arrays.asList(12345L,23578L));
	
	usersList.add(user1);
	usersList.add(user2);
	// usersList.add(null);
	
}*/


	public UserDaoImplUsingList() {
		this.usersList = new ArrayList<>();
		//this.usersList = new LinkedList<>();
		//this.usersList = new CopyOnWriteArrayList<>();
	}
	
	
	@PostConstruct
	public void init() {

		log.info("UserDaoImplUsingList obj has created");
		
		UserRegistration user1 = new UserRegistration();
		user1.setUserId(++id);
		user1.setFirstname("Punyasmruti");
		user1.setLastname("Nayak");
		user1.setEmailId("punyasmruti@gmail.com");
		user1.setAge(40);
		try {
			//user1.setDob(new SimpleDateFormat("dd MMM yyyy").parse("11 May 1980"));
			user1.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1980-05-11"));//ok , default format of date
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user1.setMobileNos(Arrays.asList(9962428121L, 6383609193L));
		user1.setHubbies(Arrays.asList("study","music"));
		user1.setGender("male");
		
		
		UserRegistration user2 = new UserRegistration();
		user2.setUserId(++id);
		user2.setFirstname("Parthasarathi");
		user2.setLastname("Beuria");
		user2.setEmailId("parthasarathi@gmail.com");
		user2.setAge(41);
		try {
			//user2.setDob(new SimpleDateFormat("dd MMM yyyy").parse("25 Nov 1979"));
			user2.setDob(new SimpleDateFormat("yyyy-MM-dd").parse("1979-09-26"));//ok , default format of date
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user2.setGender("male");
		user2.setHubbies(Arrays.asList("study","cricket"));
		user2.setMobileNos(Arrays.asList(12345L,23578L));
		
		usersList.add(user1);
		usersList.add(user2);
		// usersList.add(null);

	}
	
	/**
	 * ##########################
	 * INSERT Oerations
	 * ##########################
	 */

	@Override
	public UserRegistration saveUserRegistration(UserRegistration userRegistration) {
		log.info("Inside UserDaoImplUsingList saveUserRegistration: ");
		if (null != userRegistration && null != userRegistration.getEmailId()) {
			UserRegistration exsistingUser = getUserByEmailID1(userRegistration.getEmailId());
			if (null != exsistingUser) {
				throw new EmiailAlreadyExistsException("An user is aleady exists with email : " + userRegistration.getEmailId());
			} else {
				if (userRegistration.getUserId() == null) {
					userRegistration.setUserId(++id);
					usersList.add(userRegistration);
				}
			}
		}
		//log.debug("Inside UserDaoImplUsingList saveUserRegistration, userRegistration:{}", userRegistration);
		return userRegistration;

	}
	

	/**
	 * ##########################
	 * SELECT By userId
	 * ##########################
	 */
	
	@Override
	public UserRegistration getUserByUserId1(Long userId) {
		log.info("Inside UserDaoImplUsingList getUserByUserId1 :");
		UserRegistration result = null;
		Iterator<UserRegistration> it = usersList.iterator();
		while (it.hasNext()) {
			UserRegistration user = it.next();
			if (user.getUserId() == userId) {
				result = user;
				break;
			}
		}
		return result;
	}

	@Override
	public UserRegistration getUserByUserId2(Long userId) {
		log.info("inside UserDaoImplUsingList getUserByUserId2 :");
		//return usersList.stream().filter(user -> user.getUserId() == userId).collect(Collectors.toList()).get(0);//OK
		//return usersList.stream().filter(user -> user.getUserId() == userId).findAny().get();
		return usersList.stream().filter(user -> user.getUserId() == userId).findFirst().get();
	}
	

	@Override
	public List<String> getUserEmails() {
		return usersList.stream()
        //.filter(student -> student.getGpa() >= 3.9)
        .map(UserRegistration::getEmailId)
        .collect(Collectors
                .collectingAndThen(
                    Collectors.toList(),
                    Collections::<String> unmodifiableList));
	}


	/**
	 * ##########################
	 * SELECT by firstname
	 * ##########################
	 */
	

	@Override
	public List<UserRegistration> getUsersByFirstname(String firstname) {
		//Predicate<UserRegistration> predicate = user -> user.getFirstname().equals(firstname);
		return usersList
				.stream()
				.filter(user -> user.getFirstname().equals(firstname))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UserRegistration> getUsersByFirstname_WithLastnameInAscendingOrder(String firstname) {
		//Predicate<UserRegistration> predicate = user -> user.getFirstname().equals(firstname);
		//Comparator<UserRegistration> comparator = Comparator.comparing(UserRegistration::getLastname);
		return usersList
				.stream()
				.filter(user -> user.getFirstname().equals(firstname))
				.sorted(Comparator.comparing(UserRegistration::getLastname))
				.collect(Collectors.toList());
	}

	@Override
	public List<UserRegistration> getUserssByFirstname_WithLastnameInDescendingOrder(String firstname) {
		Predicate<UserRegistration> predicate = user -> user.getFirstname().equals(firstname);
		Comparator<UserRegistration> comparator = Comparator.comparing(UserRegistration::getLastname).reversed();
		return usersList
				.stream()
				.filter(predicate)
				.sorted(comparator)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UserRegistration> getUsersByFirstname_WithEmailInAscendingOrder(String firstname) {
		Predicate<UserRegistration> predicate = (UserRegistration user) -> user.getFirstname().equals(firstname);
		//Comparator<UserRegistration> comparator = Comparator.comparing(UserRegistration::getEmailId); //Ok
		Comparator<UserRegistration> comparator = (UserRegistration u1 , UserRegistration u2) -> u1.getEmailId().compareTo(u2.getEmailId());
		return usersList
				.stream()
				.filter(predicate)
				.sorted(comparator)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UserRegistration> getUsersByFirstname_WithEmailInDescendingOrder(String firstname) {
		Predicate<UserRegistration> predicate = userRegistration -> userRegistration.getFirstname().equals(firstname);
		Comparator<UserRegistration> comparator = Comparator.comparing(UserRegistration::getEmailId).reversed();
		return usersList
				.stream()
				.filter(predicate)
				.sorted(comparator)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UserRegistration> getUsersByFirstname_WithAgeInAscendingOrder(String firstname) {
		Predicate<UserRegistration> predicate = user -> user.getFirstname().equals(firstname);
		Comparator<UserRegistration> comparator = Comparator.comparing(UserRegistration::getAge);
		return usersList
				.stream()
				.filter(predicate)
				.sorted(comparator)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UserRegistration> getUsersByFirstname_WithAgeInDescendingOrder(String firstname) {
		Predicate<UserRegistration> predicate = user -> user.getFirstname().equals(firstname);
		Comparator<UserRegistration> comparator = Comparator.comparing(UserRegistration::getAge).reversed();
		return usersList
				.stream()
				.filter(predicate)
				.sorted(comparator)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<String> tansformAllFirstnamesToUppercase() {
		return usersList
				.stream()
				.map(UserRegistration::getFirstname)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
	}
	
	@Override
	public Long countByFirstname(String firstname) {
		return usersList
				.stream()
				.filter(user -> user.getFirstname().equalsIgnoreCase(firstname)).count();
				
	}
	
	@Override
	public Map<Long, String> getUserIdAndEmailIDByFirstname(String firstname) {
		Predicate<UserRegistration> predicate1 = (user) -> user.getFirstname().equalsIgnoreCase(firstname);
		Map<Long, String> map = usersList
				.stream()
				.filter(predicate1)
				// .filter(predicate2) //ok
				.collect(Collectors.toMap(UserRegistration::getUserId,UserRegistration::getEmailId));
		return map;
	}
	
	@Override
	public Map<String, String> getFirstnameAndEmailIDByFirstnameWhereAgeGreaterThan30(String firstname) {
		Predicate<UserRegistration> predicate1 = (user) -> user.getFirstname().equalsIgnoreCase(firstname);
		Predicate<UserRegistration> predicate2 = (user) -> user.getAge() > 30 ;
		Comparator<UserRegistration> comparator = Comparator.comparing(UserRegistration::getAge).reversed();
		Map<String, String> map = usersList
				.stream()
				.filter(predicate1)
				.filter(predicate2)
				.sorted(comparator)
				.collect(Collectors.toMap(UserRegistration::getFirstname,UserRegistration::getEmailId));
		return map;
	}
	
	@Override
	public Map<String, String> getLastnameAndEmailIdByFirstname(String firstname) {
		Predicate<UserRegistration> predicate1 = (user) -> user.getFirstname().equalsIgnoreCase(firstname);
		Predicate<UserRegistration> predicate2 = (user) -> user.getAge() > 30 ;
		Map<String, String> map = usersList
				.stream()
				.filter(predicate1)
				.filter(predicate2)
				.collect(Collectors.toMap(UserRegistration::getLastname,UserRegistration::getEmailId));
		return map;
	}
	
	@Override
	public Map<Long, String> getUserIdAndEmailIDByLastname(String firstname) {
		Predicate<UserRegistration> predicate = (contact) -> contact.getFirstname().equalsIgnoreCase(firstname);
		Comparator<UserRegistration> comparator = Comparator.comparing(UserRegistration::getAge).reversed();
		Map<Long, String> map = usersList.stream()
				.filter(predicate)
				// .filter(p2) //ok
				.sorted(comparator)
				.collect(Collectors.toMap(UserRegistration::getUserId, UserRegistration::getEmailId));
		return map;
	}
	
	/**
	 * ##########################
	 * SELECT by lastname
	 * ##########################
	 */
	
	@Override
	public List<UserRegistration> getUsersByLastname(String lastname) {
		return usersList
				.stream()
				.filter(user -> user.getLastname().equals(lastname))
				.collect(Collectors.toList());
	}
	
	@Override
	public Long countByLastname(String lastname) {
		return usersList
				.stream()
				.filter(user -> user.getFirstname().equalsIgnoreCase(lastname)).count();
				
	}
	
	
	@Override
	public List<UserRegistration> getUsersByLastname_WithFirstnameInAscendingOrder(String lastname) {
		return usersList
				.stream()
				.filter(user -> user.getLastname().equals(lastname))
				.sorted(Comparator.comparing(UserRegistration::getFirstname))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UserRegistration> getUsersByLastname_WithFirstnameInDescendingOrder(String lastname) {
		return usersList
				.stream()
				.filter(user -> user.getLastname().equals(lastname))
				.sorted(Comparator.comparing(UserRegistration::getFirstname).reversed())
				.collect(Collectors.toList());
	}
	
	
	@Override
	public Map<Long, String> getContactIdAndEmailIDByLastname(String lastname) {
		Predicate<UserRegistration> predicate1 = (user) -> user.getLastname().equalsIgnoreCase(lastname);
		Map<Long, String> map = usersList.stream()
				.filter(predicate1)
				// .filter(predicate2) //ok
				.collect(Collectors.toMap(UserRegistration::getUserId, UserRegistration::getEmailId));
		return map;
	}
	
	@Override
	public Map<String, String> getFirstnameAndEmailIDByLastname(String lastname) {
		Predicate<UserRegistration> predicate1 = (contact) -> contact.getLastname().equalsIgnoreCase(lastname);
		Map<String, String> map = usersList.stream()
				.filter(predicate1)
				// .filter(predicate2) //ok
				.collect(Collectors.toMap(UserRegistration::getEmailId,UserRegistration::getFirstname));
		return map;
	}
	
	/**
	 * ##########################
	 * by emailID
	 * ##########################
	 */
		
	
	@Override
	public UserRegistration getUserByEmailID1(String email) {
		log.info("inside UserDaoImplUsingList getUserByEmailID :"+email);
		UserRegistration u = null;
		Iterator<UserRegistration> iterator = usersList.iterator();
		while (iterator.hasNext()) {
			UserRegistration user = iterator.next();
			if (user.getEmailId().equals(email)) {
				u = user;
				break;
			}
		}
		//log.debug("Inside UserDaoImplUsingList getUserByEmailID, userRegistration : {}", u);
		return u;
	}
	
	@Override
	public UserRegistration getUserByEmailID2(String email) {
		Predicate<UserRegistration> predicate1 = (user) -> user.getEmailId().equalsIgnoreCase(email);
		UserRegistration user  = usersList.stream()
				.filter(predicate1)
				// .filter(predicate2) //ok
				.collect(Collectors.toList()).get(0);
		return user;
	}
	
	@Override
	public String joiningAllEmailsWithDelimiter(){
        return usersList.stream()
                .map(UserRegistration::getEmailId)
                .collect(Collectors.joining(";"));
    }
	
	@Override
	public List<String> getAllEmails(){
		return usersList
        .stream()
        .collect(Collectors.mapping(UserRegistration::getEmailId,toList()));
	}
	
	@Override
	public Map<String,Integer> getUserEmailAngAgeByEmailID(String email) {
		Predicate<UserRegistration> predicate1 = (user) -> user.getEmailId().equalsIgnoreCase(email);
		Map<String, Integer> map = usersList.stream()
				.filter(predicate1)
				// .filter(predicate2) //ok
				.collect(Collectors.toMap(UserRegistration::getEmailId, UserRegistration::getAge));
		return map;
		
	}
	

	/**
	 * ##########################
	 * by age
	 * ##########################
	 */
	

    public Optional<UserRegistration> minByAge(){
        Optional<UserRegistration> studentOptional = usersList
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(UserRegistration::getAge)));

        return studentOptional;
    }

    public Optional<UserRegistration> maxByAge(){
        Optional<UserRegistration> studentOptional = usersList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(UserRegistration::getAge)));
        return studentOptional;
    }
	
	@Override
	public List<UserRegistration> getUsersByAge_WithFirstnameInDescendingOrder(int age1,int age2) {
		
		return usersList
				.stream()
				.filter(user -> user.getAge() > age1 && user.getAge() < age2)
				.sorted(Comparator.comparing(UserRegistration::getFirstname).reversed())
				.collect(Collectors.toList());
	}
	
	@Override
	public Map<String, Integer> getUsersEmailAndAgeByAge(int age) {
		Predicate<UserRegistration> p1 = user -> user.getAge() > age;
		Comparator<UserRegistration> c1 = Comparator.comparing(UserRegistration::getFirstname).reversed();
		return usersList.stream().filter(p1).sorted(c1)
				.collect(Collectors.toMap(UserRegistration::getEmailId, UserRegistration::getAge));
	}
	
	@Override
	public Long countUsersByAgeRange(int age1, int age2) {
		Predicate<UserRegistration> p1 = user -> user.getAge() > age1 && user.getAge() < age2;
		return usersList.stream().filter(p1).count();
	}
	
	@Override
	public Long countUsersByAge(int age) {
		// Predicate<UserRegistration> p1 = user -> user.getAge() > age;
		return usersList.stream().filter(user -> user.getAge() > age).count();
	}
	
	@Override
	public Map<String, List<UserRegistration>> groupUserByAge(Integer age) {
		return usersList.stream().collect(Collectors.groupingBy(user -> user.getAge() >= age ? "Senior" : "Junior"));

	}
	
	@Override
	public Map<Boolean, Map<String, List<String>>> partitioningByAge() {
		Predicate<UserRegistration> gpaPredicate = (userRegistration) -> userRegistration.getAge() >= 50;
		return usersList.stream().collect(
				partitioningBy(gpaPredicate, toMap(UserRegistration::getFirstname, UserRegistration::getHubbies)));
	}

	@Override
	public Double averageAge() {
		double avgAge = usersList.stream().collect(Collectors.averagingDouble(UserRegistration::getAge));
		return avgAge;
	}
	

	/**
	 * ##########################
	 * SELECT Users by DOB
	 * ##########################
	 */
	
	@Override
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder(Date date) {
		return usersList
				.stream()
				.filter(user -> user.getDob().equals(date))
				.sorted(Comparator.comparing(UserRegistration::getFirstname).reversed())
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UserRegistration> getUsersByBirthDate_WithFirstnameInDescendingOrder2(String date) {
		return usersList
				.stream()
				.filter(user -> user.getDob().toString().contains("11/05"))
				.sorted(Comparator.comparing(UserRegistration::getFirstname).reversed())
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UserRegistration> getUsersByBirthYear(String year) {
		return usersList
				.stream()
				.filter(user -> user.getDob().toString().contains(year))
				.sorted(Comparator.comparing(UserRegistration::getFirstname).reversed())
				.collect(Collectors.toList());
	}
	
	@Override
	public List<UserRegistration> getUsersByBirthDate_WithDobInDescendingOrder() {
		return usersList
				.stream()
				.sorted(Comparator.comparing(UserRegistration::getDob).reversed())
				.collect(Collectors.toList());
	}
	

	/**
	 * ##########################
	 * SELECT Users by mobileNo
	 * ##########################
	 */
	
	@Override
	public List<UserRegistration> getUsersByMobileNo(Long MobileNo) {
		//Predicate<UserRegistration> predicate = user -> user.getMobileNos().contains(MobileNo);
		return usersList.stream()
				.filter(user -> user.getMobileNos().contains(MobileNo))
				.collect(Collectors.toList());
	}
	
	@Override
	public Map<String,String> getEmailAndFirstNameByMobileNo(Long MobileNo) {
		//Predicate<UserRegistration> predicate = user -> user.getMobileNos().contains(MobileNo);
		//Comparator<UserRegistration> comparator = Comparator.comparing(UserRegistration::getFirstname);
		return usersList.stream()
				.filter(user -> user.getMobileNos().contains(MobileNo))
				.sorted(Comparator.comparing(UserRegistration::getFirstname))
				.collect(Collectors.toMap(UserRegistration::getEmailId,UserRegistration::getFirstname));
	}
	
	@Override
	public List<UserRegistration> getAllUsers() {
		log.info("inside UserDaoImplUsingList getAllUsers :");
		return usersList;
	}
	
	
	/**
	 * ##########################
	 * SELECT Users by Hobbies
	 * ##########################
	 */
	
	@Override
	public Long countUsersByHobby(String hobby) {
		 return usersList
				 .stream()
				 .filter(user -> user.getHubbies().contains(hobby)).count();
	}
	

	/**
	 * ##########################
	 * UPDATE Opern
	 * ##########################
	 */

	@Override
	public UserRegistration updateUserRegistration(UserRegistration userRegistration) {
		log.info("inside UserDaoImplUsingList updateUserRegistration:");
		Iterator<UserRegistration> iterator = usersList.iterator();
		UserRegistration user = null;
		while (iterator.hasNext()) {
			user = iterator.next();
			if (userRegistration.getUserId() != null && user.getUserId() == userRegistration.getUserId()) {
				user.setFirstname(userRegistration.getFirstname());
				user.setLastname(userRegistration.getLastname());
				user.setEmailId(userRegistration.getEmailId());
				user.setAge(userRegistration.getAge());
				user.setDob(userRegistration.getDob());
				user.setMobileNos(userRegistration.getMobileNos());
				user.setHubbies(userRegistration.getHubbies());
				iterator.remove();
				usersList.add(user);
				break;
			}
		}
		//log.debug("inside UserDaoImplUsingList updateUserRegistration: After update :{}", user);
		return user;
	}
	
	/**
	 * ##########################
	 * DELETE User by userId
	 * ##########################
	 */

	@Override
	public void deleteUserById(Long userId) {
		log.info("inside UserDaoImplUsingList deleteUserById :"+userId);
		Iterator<UserRegistration> iterator = usersList.iterator();
		while (iterator.hasNext()) {
			UserRegistration user = iterator.next();
			if (user.getUserId() == userId) {
				iterator.remove();
			}
		}
	}

	@Override
	public void deleteAllUsers() {
		log.info("inside UserDaoImplUsingList deleteAllUsers :");
		usersList.clear();

	}

	@PreDestroy
	public void destroy() {
		log.info("UserDaoImplUsingList obj has destroyed");
	}
}
