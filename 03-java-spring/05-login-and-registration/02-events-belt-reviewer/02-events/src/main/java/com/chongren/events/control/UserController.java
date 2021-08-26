package com.chongren.events.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chongren.events.model.User;
import com.chongren.events.service.UserService;
import com.chongren.events.vlidator.UserValidator;


@Controller
public class UserController {
	
	@Autowired
	private UserService uServ;
	
	@Autowired
	private UserValidator validator;
	

	//================= Session ==================//
	public void setSessionSettings(HttpSession session) {
		session.setMaxInactiveInterval(-1);
	}
	

	
	//================== LogIn & Registration Page =================//
	@GetMapping("/")
	public String login(@ModelAttribute("user")User user, HttpSession session) {
//		 @Valid @ModelAttribute("userToLogIn")User userToLogIn,
		setSessionSettings(session);
		return "landing.jsp";
	}
	
	
	//================== LogIn =================//

 
	@PostMapping("/login")
	public String loggingIn(@RequestParam("loginemail")String email, @RequestParam("loginpassword")String password, HttpSession session, RedirectAttributes redirectAttr) {
		if(!this.uServ.authenicateUser(email, password)) {                              //Login based on email & pw
			redirectAttr.addFlashAttribute("error", "Invalid Credentials");
			return "redirect:/";
		}
		
		User user = this.uServ.geyByEmail(email);                        //if match from database, get uid by email and send to next step
		session.setAttribute("user___id", user.getId());
		return "redirect:/dashboard";
	}
	
	
	
	
	//================== Registration =================//
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "landing.jsp";
		}
		User newuser = this.uServ.registerUser(user);        //direct to the dashboard with registered info
		session.setAttribute("user___id", newuser.getId());
		return "redirect:/dashboard";
	}
	
	
	//================== Logout =================//
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttr) {
		redirectAttr.addFlashAttribute("message", "You have been successfully logged out!");
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
}
