package com.springboot.mvccontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.model.UserRegistration;
import com.springboot.service.UserService;

@Controller
// @SessionAttributes("loginUsername")
// @SessionAttributes({"firstname","lastname"})
// @Slf4j
public class UserMvcControllerCrud {

	// private static final Log log =
	// LogFactory.getLog(UserMvcControllerCrud.class); //apache commons logging
	Logger log = LoggerFactory.getLogger(this.getClass()); // slf4j logging

	// @Resource //OK
	// @Inject //OK
	// @Autowired
	private UserService userService;
	// private UserService userService = new UserServiceImpl();

	// OR

	// Constructor injection
	@Autowired
	public UserMvcControllerCrud(UserService userService) {
		this.userService = userService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, false));
	}

	/**
	 * ######################################################################################
	 * Home Page
	 * ######################################################################################
	 */

	// @GetMapping(value = { "/", "/home" }) //OK
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage() {
		log.info("Inside UserMvcController homePage :");
		return "homePage";
		// return "redirect:/users";
	}

	/**
	 * ######################################################################################
	 * User INSERT operations
	 * ######################################################################################
	 */

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showUserRegisterform(Model model) {
		// public ModelAndView showUserRegisterform(ModelMap map) {
		// public String showUserRegisterform(Model model) {
		// public String showUserRegisterform(ModelMap model) { //OK

		log.info("Inside UserMvcController, Accessing user register page");
		model.addAttribute("user", new UserRegistration());
		// map.put("user", new UserRegistration());
		return new ModelAndView("userRegistrationForm1");

	}
	
	// @PostMapping(value = "/register") //OK
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String saveUserRegistaration2(@Valid @ModelAttribute("userRegistration") UserRegistration userRegistration,
			BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {

		log.info("Inside UserMvcController saveUserRegistaration:{}", userRegistration);

		if (result.hasErrors()) {
			return "userRegistrationForm1";
		}

		UserRegistration u = userService.saveUserRegistration(userRegistration);

		if (u != null) {
			redirectAttributes.addFlashAttribute("successMessage", "User saved successfully");
		} else {
			model.addAttribute("errorMessage", "user  not saved successfully");
			model.addAttribute("user", userRegistration);
		}

		return "redirect:/users";
	}


	@RequestMapping(value = "/register2", method = RequestMethod.POST)
	public String saveUserRegistaration1(@Valid @ModelAttribute("userRegistration") UserRegistration user,
			BindingResult result) {

		log.info("Inside UserMvcController, saving user registration:{}", user);

		if (result.hasErrors()) {
			return "userRegistrationForm";
		}
		userService.saveUserRegistration(user);
		return "redirect:/users";
	}

	
	/**
	 * ######################################################################################
	 * SELECT operations
	 * ######################################################################################
	 */

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		// public String viewAllRegisteredUsers(ModelMap map) { //OK
		log.info("Inside UserMvcController getAllUsers :");
		List<UserRegistration> userslist = userService.getAllUsers();
		model.addAttribute("usersList", userslist);
		// map.put("usersList",userslist);
		return "viewAllRegisteredUsers";
		// return new ModelAndView("viewstudents","userslist",userslist); //OK
	}

	@RequestMapping(value = "/users2", method = RequestMethod.GET)
	public ModelAndView viewAllRegisteredUsers(Model model) {
		// public String viewAllRegisteredUsers(ModelMap map) { //OK

		log.info("Inside UserMvcController , Accessing all users");
		List<UserRegistration> userslist = userService.getAllUsers();
		model.addAttribute("usersList", userslist);
		// map.put("usersList",userslist);
		return new ModelAndView("viewAllRegisteredUsers");
	}

	/**
	 * ######################################################################################
	 * User UPDATE operations
	 * ######################################################################################
	 */

	@RequestMapping(value = "/edituser/{userId}", method = RequestMethod.GET)
	public String editUserRegistrationForm(@PathVariable Long userId, Model model) {
		// public String editUserRegistrationForm(@PathVariable Long userId, ModelMap map) { //OK
		log.info("Inside UserMvcController editUserRegistrationForm :");
		UserRegistration userRegistration = userService.getUserByUserId(userId);
		model.addAttribute("userRegistration", userRegistration);
		// map.put("userRegistration",userRegistration);
		return "userEditRegistrationForm";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String updateUserRegistrationDetails(@Valid @ModelAttribute("userRegistration") UserRegistration userRegistration, BindingResult result,
			ModelMap model, RedirectAttributes redirectAttributes) {
		log.info("Inside UserMvcController updateUserRegistrationDetails :");
		if (result.hasErrors()) {
			return "userEditRegistrationForm";
		}
		UserRegistration u = userService.updateUserRegistration(userRegistration);

		if (u != null) {
			redirectAttributes.addFlashAttribute("successMessage", "User saved successfully");
		} else {
			model.addAttribute("errorMessage", "user  not saved successfully");
			model.addAttribute("user", userRegistration);
		}
		return "redirect:/users";
	}

	@RequestMapping(value = "/edituser2/{userId}", method = RequestMethod.GET)
	public ModelAndView editUserRegistrationForm2(@PathVariable Long userId, Model model) {
	// public String editUserForm(@PathVariable Long id, ModelMap map) {

		log.info("Inside UserMvcController, Accessing user edit page for userId:{}", userId);
		UserRegistration user = userService.getUserByUserId(userId);
		model.addAttribute("user", user);
		// map.put("user",user);
		return new ModelAndView("userEditRegistrationForm");
	}

	@RequestMapping(value = "/editsave2", method = RequestMethod.POST)
	public String updateUserRegistration2(@Valid @ModelAttribute("user") UserRegistration user, BindingResult result) {

		log.info("Inside UserMvcController , updating user:{}", user);
		if (result.hasErrors()) {
			return "userEditRegistrationForm";
		}
		userService.updateUserRegistration(user);
		return "redirect:/users";
	}

	/**
	 * ######################################################################################
	 * User DELETE operations- It deletes record for the given id in URL and
	 * redirects to /users
	 * ######################################################################################
	 */

	@RequestMapping(value = "/deleteuser/{userId}", method = RequestMethod.GET)
	public String deleteUserRegistration(@PathVariable Long userId, RedirectAttributes redirectAttributes) {
		log.info("Inside UserMvcController deleteUserRegistration :");
		userService.deleteUserByUserId(userId);
		redirectAttributes.addFlashAttribute("successMessage", "user has been deleted successfully");
		return "redirect:/users";
	}

	@RequestMapping(value = "/deleteuser2/{userId}", method = RequestMethod.GET)
	public String deleteUserRegistration2(@PathVariable Long userId) {

		log.info("Inside UserMvcController , Deleting user with ID : {}", userId);
		userService.deleteUserByUserId(userId);
		return "redirect:/users";
	}
}
