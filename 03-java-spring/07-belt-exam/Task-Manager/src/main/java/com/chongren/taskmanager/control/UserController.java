package com.chongren.taskmanager.control;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chongren.taskmanager.model.Task;
import com.chongren.taskmanager.model.User;
import com.chongren.taskmanager.service.TManagerService;
import com.chongren.taskmanager.service.UserService;
import com.chongren.taskmanager.validator.UserValidator;


@Controller
public class UserController {
	

	@Autowired
	private UserService uServ;
	
	@Autowired
	private TManagerService tServ;
	
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
		return "redirect:/tasks";
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
		return "redirect:/tasks";
	}
	
	
	//================== Logout =================//
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttr) {
		redirectAttr.addFlashAttribute("message", "You have been successfully logged out!");
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	//================== All Task Dashboard after logged in =================//
	@GetMapping("/tasks")
	public String index(@ModelAttribute("task")Task task, Model viewModel, HttpSession session, RedirectAttributes redirectAttr) {
		if(session.getAttribute("user___id") == null) {
			redirectAttr.addFlashAttribute("message", "You need to log in first!");
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user___id");
		List<Task> allTasks = this.tServ.showAllTask();
		System.out.println(allTasks);
		viewModel.addAttribute("allTasks", allTasks);
		viewModel.addAttribute("user", this.uServ.getOneUser(userId));;
		return "AllTasks.jsp";
		
	}  
	

	
	
	
	


}
