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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chongren.taskmanager.model.Task;
import com.chongren.taskmanager.model.User;
import com.chongren.taskmanager.service.TManagerService;
import com.chongren.taskmanager.service.UserService;

@Controller
public class TManagerController {
	
	@Autowired
	private UserService uServ;
	
	@Autowired
	private TManagerService tServ;
	
//	@Autowired
//	private UserValidator validator;
	
	
	//================== Create Task =================//
	
	@GetMapping("/tasks/new")
	public String newTask(@ModelAttribute("task")Task task, Model viewModel, HttpSession session, RedirectAttributes redirectAttr) {
		if(session.getAttribute("user___id") == null) {
			redirectAttr.addFlashAttribute("message", "You need to log in first!");
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("user___id");
		User user = this.uServ.getOneUser(userId);
		List<User> allUsers = this.uServ.getAllUsers();
		viewModel.addAttribute("allUsers", allUsers);
		viewModel.addAttribute("creator", user);
		return "NewTask.jsp";
	}
	
	@PostMapping("/newtask")
	public String addNewTask(@Valid @ModelAttribute("task")Task task, BindingResult result, Model viewModel, HttpSession session) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("user___id");
			User user = this.uServ.getOneUser(userId);
			List<User> allUsers = this.uServ.getAllUsers();
			viewModel.addAttribute("allUsers", allUsers);
			viewModel.addAttribute("creator", user);
			return "NewTask.jsp";
		}
		this.tServ.createTask(task);
		return "redirect:/tasks";
	}	

	
	//================== Read Task Info =================//
	
	@GetMapping("/tasks/{id}")
	public String taskInfo(@PathVariable("id")Long task_id, Model viewModel) {
		if(task_id == null) {
			return "redirect:/tasks";
		}
		viewModel.addAttribute("task", this.tServ.findSingleTask(task_id));
		return "TaskInfo.jsp";
	}
	
	
	//================== Update Task =================//
	
	@GetMapping("/tasks/{id}/edit")
	public String editTask(@PathVariable("id")Long task_id, Model viewModel, HttpSession session) {
		if(task_id == null) {
			return "redirect:/tasks";
		}
		Long userId = (Long) session.getAttribute("user___id");
		User user = this.uServ.getOneUser(userId);
		viewModel.addAttribute("user", user);
		List<User> allUsers = this.uServ.getAllUsers();
		viewModel.addAttribute("allUsers", allUsers);
		viewModel.addAttribute("task", this.tServ.findSingleTask(task_id));
		return "EditTask.jsp";
	}
	
	@PostMapping("/task/{id}/editinfo")
	public String processUpdate(@Valid @ModelAttribute("task")Task task, @PathVariable("id")Long task_id, BindingResult result, Model viewModel, HttpSession session) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("user___id");
			User user = this.uServ.getOneUser(userId);
			viewModel.addAttribute("user", user);
			List<User> allUsers = this.uServ.getAllUsers();
			viewModel.addAttribute("allUsers", allUsers);
			viewModel.addAttribute("task", this.tServ.findSingleTask(task_id));
			return "EditTask.jsp";
		}
		this.tServ.updateTask(task);
		return "redirect:/tasks";
	}
	
	
	//================== Delete Task =================//
	
	@GetMapping("/deleteTask/{id}")
	public String DeleteTask(@PathVariable("id")Long event_id) {
		this.tServ.deletaTask(event_id);
		return "redirect:/tasks";
	
	}
}

