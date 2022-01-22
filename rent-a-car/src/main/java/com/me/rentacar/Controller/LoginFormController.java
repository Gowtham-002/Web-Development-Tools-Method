package com.me.rentacar.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentacar.DAO.UserDAO;
import com.me.rentacar.pojo.User;
import com.me.rentacar.pojo.Person;
import com.me.rentacar.Validator.UserValidator;

@Controller
public class LoginFormController {

//	@Autowired
//	@Qualifier("userDao")
//	UserDAO userDao;

	@PostMapping("/UserloginPage.htm")
	protected String UserloginPage(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest req)
			throws Exception {

		HttpSession session = req.getSession(true);

		try {

			UserDAO uDAO = new UserDAO();


			User userobj = uDAO.getUser(user.getUsername());
			if (userobj == null || !(userobj.getPassword().equals(user.getPassword()))) {
				req.setAttribute("loginErr", "Invalid Credentials!!!, Please enter correct credentails");
				System.out.print("invalid password");
				return "UserloginPage";
			} else if (userobj.getUserrole().equalsIgnoreCase("admin") || userobj.getUsername().equalsIgnoreCase("admin")
					|| userobj.getPassword().equalsIgnoreCase("admin@123")) {
				session.setAttribute("admin", userobj);
				return "AdminWelcome";
			} else {
				session.setAttribute("user", userobj);
				return "UserWelcome";
			}

		} catch (Exception exp) {
			
			System.out.println("Exception" + exp.getMessage());
		}
		return "UserloginPage";
	}

	@GetMapping("/UserSignup.htm")
	public String UserSignupPage(@ModelAttribute("user")User user, BindingResult result) {
		
		return "UserSignup";
	}
	
	@PostMapping("/UserSignup.htm")
	public String UserSignupPageSubmit(@Valid @ModelAttribute("user")User user, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			System.out.print("error in sign up");
			return "UserSignup";
		}
		try {

			UserDAO uDao = new UserDAO();

			
			uDao.AddNewUser(user.getUsername(), user.getPassword(),user.getUserrole() ,user.getEmailId() , user.getFirstname(), user.getLastname(), user.getPhonenumber(),user.getAddress(),user.getAge());
			
			
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		return "useradded";
	}
	
	@GetMapping("/index.htm")
	public String indexloginpage(@ModelAttribute("user") User user, BindingResult result) {
		
		return "UserloginPage";
	}

	@GetMapping("/AdminWelcome.htm")
	public String adminWelcomePage() {
		return "AdminWelcome";
	}


}