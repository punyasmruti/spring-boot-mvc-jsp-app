package com.springboot.mvccontroller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.custompropertyeditor.UserNameEditor;
import com.springboot.model.UserLogin;
import com.springboot.model.UserRegistration;
import com.springboot.model.UserRegistrationWithAddress;

@Controller
@RequestMapping("/tutorial/springmvc")
//@SessionAttributes("loginUsername")
//@SessionAttributes({"firstname","lastname"})
public class SpringMvcTutorialsController {

	// private Log logger = LogFactory.getLog(SpringMvcTutorialsController.class);
	Logger logger = LoggerFactory.getLogger(this.getClass()); // slf4j logging

	/**
	 * Custom data binding, Working with @InitBinder and WebDataBinder as method arg
	 * and buildt in property editor classes like
	 * CustomDateEditor,CustomNumberEditor,CustomBooleanEditor,FileEditor,LocaleEditor...
	 * etc.
	 */

	/**
	 * Working with our own custom property editor class.
	 */

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// This mobileno property will be ignored by spring mvc.
		// binder.setDisallowedFields(new String[] { "mobileno" });

		// Default Date format is yyyy/MM/dd
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dob_dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dob_dateFormat, false));

		// using custom property editor class for the property namw.
		binder.registerCustomEditor(String.class, "name", new UserNameEditor());
	}

	/**
	 * ############################################################# Displaying
	 * static content in view page.
	 * #############################################################
	 */

	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/hi01") // Works for Spring 4.3.x onwords
	// @RequestMapping(path = "/hi1", method = RequestMethod.GET)
	// @RequestMapping(value ="/hi1")
	// @RequestMapping("/hi1")
	public String sayHi1() {
		logger.info("sayHi1() executed");
		return "hi1";
	}

	/**
	 * ############################################################# sending data
	 * from controller to view page using way-1. HttpServletRequest obj way-2.
	 * HttpSession obj way-3. Model obj way-4. ModelMap obj way-5. ModelAndView
	 * #############################################################
	 */

	/**
	 * ############################################################# way-01 sending
	 * data from controller to view page using HttpServletRequest obj
	 * #############################################################
	 */

	@RequestMapping("/hi03")
	public String sayHi2(HttpServletRequest request) {
		logger.info("sayHi2() executed with input request");
		request.setAttribute("msg", "Hey How are you !!!!");// ok
		return "hi2";
	}

	/**
	 * ############################################################# way-02 sending
	 * data from controller to view page using HttpSession obj
	 * #############################################################
	 */

	@RequestMapping("/hi04")
	public String sayHi4(HttpSession session) {
		logger.info("sayHi4() executed with input request");
		session.setAttribute("msg", "Hey How are you !!!!");// ok
		return "hi2";
	}

	/**
	 * ############################################################# way-03 sending
	 * data from controller to view page Using Model class addAttribute method
	 * #############################################################
	 * 
	 */

	@GetMapping("/hi08")
	public String sayHi8(Model model) {
		model.addAttribute("msg", "Welcome To Spring  MVC");
		return "hi2";
	}

	/**
	 * way-04 ############################################################# sending
	 * data from controller to view page using ModelMap and return type as String .
	 * #############################################################
	 */

	// @RequestMapping(value = "/hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	public String sayHello2(ModelMap modelMap) {
		modelMap.addAttribute("greeting", "Hello World from Spring  MVC");
		modelMap.put("msg", "Welcome To Spring  MVC");
		return "hi2";
	}

	@GetMapping(value = { "/", "/index" })
	public ModelAndView welcomePage2() {
		logger.debug("welcomePage2() executed");

		/*
		 * ModelAndView view = new ModelAndView(); view.setViewName("welcome");
		 * view.addObject("greeting", "Hello from Spring MVC");
		 */
		// OR
		/*
		 * ModelAndView view = new ModelAndView("welcome"); view.addObject("greeting",
		 * "Hello from Spring MVC");
		 */
		// OR
		return new ModelAndView("index", "msg", "Welcome To Spring  MVC");

	}

	/**
	 * sending data from controller to view page Using addObject method of
	 * ModelAndView
	 * 
	 */

	@GetMapping("/hi2")
	public ModelAndView sayHi() {
		ModelAndView view = new ModelAndView("index");
		view.addObject("headerMsg", "This is Header Msg");
		view.addObject("msg", "Welcome To Spring  MVC");
		return view;
	}

	/**
	 * sending data from controller to view page Using Map object
	 */

	@GetMapping("/hi3")
	public ModelAndView sayHi4(Map<String, Object> map) {
		ModelAndView view = new ModelAndView("index");
		map.put("msg", "Welcome To Spring  MVC");
		return view;
	}

	/**
	 * ############################################### Sending data from UI to
	 * Controller ###############################################
	 */

	@RequestMapping("/hi06")
	public String test2(HttpServletRequest req) {
		String reqParam = req.getParameter("msg");
		req.setAttribute("msg", reqParam);
		return "hi3";
	}// http://localhost:8081/tutorial/springmvc/hi06?msg=hello

	@RequestMapping("/hi07")
	public String test3(HttpServletRequest req) {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String msg = "Your name is:" + name + " and age is:" + age;
		req.setAttribute("msg", msg);
		return "hi3";
	}// http://localhost:8081/tutorial/springmvc/hi07?name=punya&age=35

	// ##############################################################################
	/**
	 * Here Only client side form validation using Java script and
	 * using @RequestParam annotation to gather input data from client.
	 * 
	 */

	@GetMapping("/addPage2")
	public String showAddPage() {
		return "addForm";
	}

	@PostMapping(value = "/add2")
	public String doAdd(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap model) {
		int res = i + j;
		model.addAttribute("addResult", res);
		return "addResult";
	}

	// ##################################################################################
	/**
	 * working with @RequestParam annotation to gather input data from client.
	 */
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public ModelAndView hi2(@RequestParam("name") String name, @RequestParam("age") int age) {
		return new ModelAndView("hi1", "msg", "Hi Your name is:" + name + " and age:" + age);

	}// http://localhost:8888/sprin_webmvc_with_springjdbc_using_xml_based_cfgn/test4?name=punya&age=36

	// ##################################################################################
	/**
	 * working with @RequestParam annotation with Map to gather input data from
	 * client.
	 */
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public ModelAndView hi2(@RequestParam Map<String, String> reqParamMap) {
		String name = reqParamMap.get("name");
		int age = Integer.parseInt(reqParamMap.get("age"));
		return new ModelAndView("hi2", "msg", "Hi Your name is:" + name + " and age:" + age);
	}// http://localhost:8888/sprin_webmvc_with_springjdbc_using_xml_based_cfgn/test5?name=punya&age=36

	// ##################################################################################
	/**
	 * working with @PathVariable annotation to gather input data from client.
	 */
	@RequestMapping(value = "/user/{name}/{age}", method = RequestMethod.GET)
	public ModelAndView hi(@PathVariable("name") String name, @PathVariable("age") int age) {
		return new ModelAndView("hi2", "msg", "Hi Your name is:" + name + " and age:" + age);
	}// http://localhost:8888/sprin_webmvc_with_springjdbc_using_xml_based_cfgn/user/punya/36
		// http://localhost:8888/sprin_webmvc_with_springjdbc_using_xml_based_cfgn/user/www.yahho.com/25

	// ##################################################################################

	/**
	 * working with both @PathVariable and @RequestParam annotation together to
	 * gather input data from client.
	 */
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ModelAndView hi3(@PathVariable("name") String name, @RequestParam("age") int age) {
		return new ModelAndView("hi2", "msg", "Hi Your name is:" + name + " and age:" + age);
	}// http://localhost:8888/sprin_webmvc_with_springjdbc_using_xml_based_cfgn/user/punya?age=36

	// ##################################################################################
	/**
	 * using @PathVariable with Map to gather input data from client.. For this use
	 * <mvc:annotation-driven /> in spring cfg xml file
	 */

	@RequestMapping(value = "/userDetails/{name}/{age}", method = RequestMethod.GET)
	public ModelAndView hi4(@PathVariable Map<String, String> pathVariablesMap) {
		String name = pathVariablesMap.get("name");
		int age = Integer.parseInt(pathVariablesMap.get("age"));
		return new ModelAndView("hi2", "msg", "Hi Your name is:" + name + " and age:" + age);
	}// http://localhost:8888/sprin_webmvc_with_springjdbc_using_xml_based_cfgn/userDetails/punyasmruti/44

	// ##################################################################################

	/**
	 * Working with @ModelAttribute - Both Client side validation using java script
	 * and server side form validation/Bean validation using HB validator
	 * api(JSR303/349). and Using @ModelAttribute annotation. Working with Bean
	 * validation using HB validator, Working with Binding errors.
	 */

	@RequestMapping(value = "/userRegister1", method = RequestMethod.GET)
	public String showRegisterPage(ModelMap model) {
		model.addAttribute("userRegistration", new UserRegistration());
		return "userRegistrationForm";
	}

	@RequestMapping(value = "/userRegister1", method = RequestMethod.POST)
	public String submitRegisterPage(@Valid @ModelAttribute("userRegistration") UserRegistration userRegistration,
			BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "userRegistrationForm1";
		}

		// boolean isSuccess = userService.saveUser(user);
		// OR
		boolean isSuccess = true;

		if (!isSuccess) {
			model.put("errorMessage", "Error Occured .... Try Again");
			return "userRegistrationForm1";
		} else {
			model.put("userRegistration", userRegistration);
			return "userRegistrationSuccess";
		}
	}

	// ##################################################################################
	/**
	 * working with String,date,arraylist - buildt in type type with @ModelAttribute
	 * annotations also server side Form validation using Hb validator(Bean
	 * validation) framework(JSR 303/349).
	 * 
	 * @return
	 */
	@GetMapping("/userRegister2")
	public String getDetails(Model model) {
		model.addAttribute("userRegistration", new UserRegistration());
		return "userRegistrationForm2";
	}

	@RequestMapping(value = "/userRegister2", method = RequestMethod.POST)
	public ModelAndView showWelcomePage2(@Valid @ModelAttribute("userRegistration") UserRegistration userRegistration,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("userRegistrationForm2");
		}

		model.addAttribute("userRegistration", userRegistration);
		return new ModelAndView("userRegistrationSuccess");
	}

	// ##################################################################################
	/**
	 * working with string,date,arraylist - buildt in type type and user defined
	 * data type (using Address class ) with @ModelAttribute annotations but no
	 * client side and server side validation.
	 * 
	 * @return
	 */

	@GetMapping("/userRegister3")
	public String getDetailsWithAddress(Model model) {
		model.addAttribute("userDetailsWithAddress", new UserRegistrationWithAddress());
		return "userRegistrationDetailsWithAddressForm";
	}

	@RequestMapping(value = "/userRegister3", method = RequestMethod.POST)
	public ModelAndView getDetailsWithAddress(
			@Valid @ModelAttribute("userDetailsWithAddress") UserRegistrationWithAddress userDetailsWithAddress,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("userRegistrationDetailsWithAddressForm");
		}
		model.addAttribute("userRegistration", userDetailsWithAddress);
		return new ModelAndView("userRegistrationSuccess");
	}

	// ##################################################################################

	/**
	 * Here Only client side form validation using Java script and
	 * using @RequestParam annotation to gather input data from client.
	 * 
	 */

	/**
	 * Working with Interceptors use HandlerInterceptorAdaptor class or
	 * HandlerInterceptor interface.
	 */

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String showLoginPage() {
		return "userLoginForm";
	}

	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	@PostMapping(value = "/login")
	public String showWelcomePage(@RequestParam String loginUsername, @RequestParam String loginPassword,
			ModelMap model) {

		// boolean isValidUser =
		// userService.validateUserLogin(loginUsername,loginPassword, usertype);
		// boolean isValidUser = userService.validateUserLogin(loginUsername,
		// loginPassword);
		/*
		 * if (!isValidUser) { model.put("errorMessage", "Invalid Credentials"); return
		 * "login2"; }
		 */

		if (loginUsername.equals("admin") && loginPassword.equals("admin"))
			model.put("loginUsername", loginUsername);
		// OR
		// model.addAttribute("loginUsername", loginUsername);
		// model.addAttribute("loginPassword", loginPassword);
		return "userLoginSuccess";
	}

	// OR
	// THis is not used
	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	/*
	 * @PostMapping(value = "/login2") public ModelAndView
	 * showWelcomePage2(@RequestParam String loginUsername, @RequestParam String
	 * loginPassword,
	 * 
	 * @RequestParam String usertype, ModelMap model) {
	 * 
	 * // boolean isValidUser = userService.validateUserLogin(loginUsername, //
	 * loginPassword, usertype); boolean isValidUser =
	 * userService.validateUserLogin(loginUsername, loginPassword);
	 * 
	 * if (!isValidUser) { model.put("errorMessage", "Invalid Credentials"); return
	 * new ModelAndView("login2"); }
	 * 
	 * ModelAndView view = new ModelAndView("userWelcome"); // UserLogin u = new
	 * UserLogin(loginUsername, loginPassword, usertype); CustomerLogin u = new
	 * CustomerLogin(loginUsername, loginPassword); view.addObject("user", u);
	 * return view; }
	 */

	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String showLoginPage2(ModelMap model) {
		model.addAttribute("userLogin", new UserLogin());
		return "userLogin";
	}

	/*
	 * @RequestMapping(value = "/userLogin", method = RequestMethod.POST) public
	 * String showWelcomePage2(@Valid @ModelAttribute("userLogin") CustomerLogin
	 * user, BindingResult bindingResult, ModelMap model) {
	 * 
	 * if (bindingResult.hasErrors()) { return "userLogin"; }
	 * 
	 * // boolean isValidUser =
	 * userService.validateUserLogin2(user.getLoginUsername(), //
	 * user.getLoginPassword(),user.getUsertype()); boolean isValidUser =
	 * userService.validateUserLogin(user.getUsername(), user.getPassword()); if
	 * (!isValidUser) { model.put("errorMessage",
	 * "Invalid Credentials...Try Again....or....Please Contact Admin Team...");
	 * return "userLogin"; } //if (user.getUsertype().equals("1")) return
	 * "adminWelcome"; else return "userWelcome"; return "userWelcome"; // return
	 * "redirect:/welcome"; }
	 */

	// ############################# User Login Operation
	// ##########################################################

	/*
	 * only client side form validation using js. without servside form validation
	 * using hb validator and db connectivity.
	 */

	@RequestMapping("/login01")
	public String loginForm01() {
		return "userLoginForm1";
	}

	@PostMapping("/login01")
	public String doLogin01(@RequestParam("loginUsername") String loginUsername,
			@RequestParam("loginPassword") String loginPassword, Model model) {
		model.addAttribute("msg", loginUsername);
		// model.addAttribute("password", loginPassword);
		return "userLoginSuccess1";
	}

	// ############################## User Login Operation
	// #########################################################

	/*
	 * only client side form validation using js. and db connectivity.
	 * 
	 * 
	 */
	@RequestMapping(value = "/login04", method = RequestMethod.GET)
	public String doLogin04(ModelMap model) {
		return "userLoginForm2";
	}

	/*
	 * @RequestMapping(value = "/login04", method = RequestMethod.POST) public
	 * String doLogin04(@RequestParam String username, @RequestParam String
	 * password, ModelMap modelMap) { boolean isValidUser =
	 * userService.validateUserLogin(username, password); if (!isValidUser) {
	 * modelMap.put("errorMessage", "Invalid Credentials"); return "loginForm04"; }
	 * modelMap.put("msg", username); // modelMap.addAttribute("username",
	 * username);//ok // modelMap.put("password", password);//ok //
	 * modelMap.addAttribute("password", password);//ok return "loginSuccess"; }
	 */

	// ############################# User Login Operation
	// ##########################################################
	/*
	 * both client and server side validation. and serverside form validation using
	 * hb validator.
	 * 
	 */

	@RequestMapping("/login02")
	public String loginForm02(Model m) {
		m.addAttribute("userform", new UserLogin());
		return "userLoginForm2";
	}

	/*
	 * @RequestMapping(value = "/login02", method = RequestMethod.POST) public
	 * String doLogin02(@Valid @ModelAttribute("userform") UserLogin user,
	 * BindingResult result, Model model) { if (result.hasErrors()) { return
	 * "loginForm02"; } else { boolean b =
	 * userService.validateUserLogin(user.getUsername(), user.getPassword()); if (b
	 * == true) { model.addAttribute("msg", user.getUsername()); //
	 * model.addAttribute("password", user.getPassword()); } else {
	 * model.addAttribute("msg", "Sorry you are not a valid user"); } } return
	 * "loginSuccess"; }
	 */

	// ############################# User Login Operation
	// ##########################################################
	// both client and server side validation.
	// using @Valid , @Validated annotations

	@RequestMapping("/login03")
	public String loginForm03(Model m) {
		m.addAttribute("userLogin", new UserLogin());
		return "userLoginForm2";
	}

	// mark here , using @Validated annotation from spring
	@RequestMapping(value = "/login03", method = RequestMethod.POST)
	public String doLogin03(@Validated @ModelAttribute("loginForm") UserLogin userLogin, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "spring_mvc_tutorial/userLoginForm2";
		} else {
			model.addAttribute("msg", userLogin.getLoginUsername());
			return "userLoginSuccess2";
		}
	}

	// ##################################################################################

	/**
	 * Displaying some static content in view page through HttpServletRequest obj.
	 * 
	 * @return
	 */

	@RequestMapping("/hi02")
	public String sayHi02(HttpServletRequest request) {
		logger.info("sayHi2() executed with input request");
		// request scoped attr will be avialable in req cycle.
		request.setAttribute("msg", "Hey How are you !!!!");
		return "hi2";
	}

	@RequestMapping("/hi002")
	public String sayHi002(HttpServletRequest request) {
		logger.info("sayHi2() executed with input request");
		// session scoped attr can be aviable in other controllers
		HttpSession session = request.getSession();
		session.setAttribute("msg", "Hey How are you !!!!");
		return "hi2";
	}

	@RequestMapping("/hi0002")
	public String sayHi0002(@SessionAttribute("msg") String msg, Model model) {
		logger.info("sayHi2() executed with input request");
		String modified = msg + " modified";
		model.addAttribute("msg", modified);
		return "hi2";
	}

	/**
	 * Working with @ModelAttribute at method level to display the common messges in
	 * every view pages.
	 */

	@ModelAttribute
	public void webSiteHeaderLocal(Model model) {
		model.addAttribute("headerMsg",
				"This is header msg for all jsp pages using ModelAttribute annotation at method level");
	}

	@ModelAttribute(name = "myname")
	public String myname() {
		return "punya";
	}

	// This modelAttribute is only accessible inside this controller class.
	@ModelAttribute(name = "local")
	public UserRegistration addObjectLocal() {
		UserRegistration user = new UserRegistration(11L, "punyasmruti", "Nayak", "punyasmruti@gmail.com", 40,
				new Date(), Arrays.asList(1234L, 2345L),  "male",Arrays.asList("study", "music"),
				Arrays.asList("java", "oracle"));
		return user;
	}

	@RequestMapping("/getLocalObj")
	public String getObjectLocal(@ModelAttribute("local") UserRegistration user, Model model) {
		model.addAttribute("userRegistration", user);
		return "userRegistrationSuccess";
	}

	@RequestMapping("/getGlobalObj")
	public String getDetailsWithAddress(@ModelAttribute("userRegistrationGlobal") UserRegistration user, Model model) {
		model.addAttribute("userRegistration", user);
		return "userRegistrationSuccess";
	}
	
	/**
	 * ######################################################################################
	 * Others
	 * ######################################################################################
	 */

	@RequestMapping(value = "/locale", method = RequestMethod.GET)
	public String locale() {
		return "locale";
	}
	// http://localhost:8081/locale
	// http://localhost:8081/locale?language=fr

	// ##################################################################################
	/*
	 * Working with themes
	 */
	// ##################################################################################
	/**
	 * Working with I18N
	 */

	@RequestMapping("/i18nDemo")
	public ModelAndView usingI18N() {

		ModelAndView modelview = new ModelAndView();
		modelview.addObject("welcome_msg", "Spring Mvc Internationalization Example");
		modelview.setViewName("welcome_I18n");
		return modelview;
	}

	// ##################################################################################
	// working with Exception Handling
	// ##################################################################################

	/**
	 * Working with Exception Handling in spring MVC by
	 * using @ExceptionHandler,@ControllerAdvice and @HandlerExceptionResolver.
	 */

	@RequestMapping("/exceptionDemo")
	public String exceptionDemo(@RequestParam("msg") String msg, Model model) {

		if (null == msg || msg.isEmpty())
			// throw new NullPointerException();
			throw new RuntimeException();

		model.addAttribute("msg", msg);
		return "hi2";

	}
	// http://localhost:8081/exceptionDemo?msg=

	/**
	 * This method for this controller only. This Below method has moved to
	 * MyControllerAdvice.java class to make as global for all controller classes.
	 */

	/*
	 * @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	 * @ExceptionHandler(value = NullPointerException.class) public ModelAndView
	 * handleNullPoointerException(Model model) { 
	 * model.addAttribute("errMsg", "NullPointerException Occured .. plz try after some time"); 
	 * return new ModelAndView("error/RuntimeException"); 
	 * }
	 */
	
	/*
	 * @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	 * @ExceptionHandler(value = NullPointerException.class) 
	 * public ModelAndView runtimeExceptionHandler(Model model) { 
	 * model.addAttribute("errMsg","RuntimeException Occured .. plz try after some time"); 
	 * return new ModelAndView("error/RuntimeException"); }
	 */

	/*
	 * @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	 * @ExceptionHandler(value = RuntimeException.class) 
	 * public ModelAndView runtimeExceptionHandler(Model model) { 
	 * model.addAttribute("errMsg","RuntimeException Occured"); 
	 * return new ModelAndView("error/RuntimeException .. plz try after some time"); }
	 */

	// ##################################################################################
	/**
	 * Working with SimpleMappingExceptionResolver. This bean has been configured in
	 * spring-root-config.xml, This is not good approach because we can not generate
	 * logs in log file related to that exception.
	 */

	// ##################################################################################
	/**
	 * Working with File Uploading
	 */

	// ##################################################################################
	/**
	 * Working with File downloading
	 */

	// #######################################################################################

	//@RequestMapping("/hello2")
	@RequestMapping(value="/hello2", method = RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}
}
