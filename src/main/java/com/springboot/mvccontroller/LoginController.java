package com.springboot.mvccontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.UserRegistration;
import com.springboot.service.UserService;

public class LoginController {

	Logger log = LoggerFactory.getLogger(this.getClass()); // slf4j logging

	// @Resource //OK
	// @Inject //OK
	// @Autowired
	private UserService userService;
	// private UserService userService = new UserServiceImpl();

	// OR

	// Constructor injection
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		log.info("Inside UserMvcController showLoginPage :");
		return "userLoginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUserLogin(ModelMap model, @RequestParam String loginUsername,
			@RequestParam String loginPassword) {
		log.info("Inside UserMvcController validateUserLogin :");
		if (!userService.validateUserLogin(loginUsername, loginPassword)) {
			model.put("errorMessage", "Invalid Credentials");
			return "userLoginForm";
		}
		model.put("loginUsername", loginUsername);
		return "userLoginSuccess";
	}
	
	//#############################################################################################################

	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public ModelAndView showLoginPage2() {
		return new ModelAndView("userLogin");
	}

	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public ModelAndView showWelcomePage2(@RequestParam("username") String username,
			@RequestParam("password") String password, ModelMap map) {

		boolean isSuccess = userService.validateUserLogin(username, password);
		if (isSuccess) {
			// putting username to session attribute by using @SessionAttribute("username")
			map.put("username", username);
			map.put("msg", username);
			return new ModelAndView("userWelcome");

		} else {
			map.put("msg", "Invalid credentials");
			return new ModelAndView("userLogin");
		}
	}
	
	
	/* ######################################################################################
	 * @SessionAttributes("loginUsername")
	 * ######################################################################################
	 */
	
	@RequestMapping(value = "/getLoginUsernameFromSession", method = RequestMethod.GET)
	public String getLoginUsername(ModelMap map ) {
		String username = (String) map.get("loginUsername");
		System.out.println(username);
		return "userLoginSuccess";
		
	}
	
	@RequestMapping(value = "/getLoginUsernameFromSession2", method = RequestMethod.GET)
	public String getLoginUsername(HttpSession session ,SessionStatus status) {
		String username = (String) session.getAttribute("loginUsername");
		System.out.println(username);
		status.setComplete(); //removing all from session scope.
		return "userLoginSuccess";
	}
	
	@RequestMapping(value = "/users2", method = RequestMethod.GET)
	public String getAllUsers(Model model,@SessionAttribute("loginUsername") String loginUsername) {
		if(null != loginUsername) {
			List<UserRegistration> userslist = userService.getAllUsers();
			model.addAttribute("usersList", userslist);
		}
		return "viewAllRegisteredUsers";
	}

}
