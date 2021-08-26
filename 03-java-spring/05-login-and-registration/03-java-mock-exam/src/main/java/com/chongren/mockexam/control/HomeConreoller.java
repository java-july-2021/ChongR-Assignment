package com.chongren.mockexam.control;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.chongren.mockexam.model.Idea;
import com.chongren.mockexam.model.User;
import com.chongren.mockexam.service.IdeaService;
import com.chongren.mockexam.service.UserService;

@Controller
@RequestMapping("/idea")
public class HomeConreoller {
	@Autowired
	private UserService uServ;
	@Autowired
	private IdeaService iServ;
//	@Autowired
//	private UserValidator validator;
	
	
	
	@GetMapping("")
	public String index(@ModelAttribute("idea")Idea idea, HttpSession session, Model viewModel) {
		User user = this.uServ.getOneUser((Long)session.getAttribute("user___id"));
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("ideas", this.iServ.getAllIdeas());
		return "dashboard.jsp";
	}
	
	@PostMapping("/addIdea")
	public String addIdea(@Valid @ModelAttribute("idea")Idea idea, BindingResult result, Model viewModel, HttpSession session) {
		if(result.hasErrors()){
			User user = this.uServ.getOneUser((Long)session.getAttribute("user___id"));
			viewModel.addAttribute("user", user);
			viewModel.addAttribute("ideas", this.iServ.getAllIdeas());
			return "dashboard.jsp";
		}
		this.iServ.create(idea);
		return "redirect:/idea";
	}
	
	@GetMapping("/{id}")
	public String singleIdea(@PathVariable("id")Long id, Model viewModel) {
		viewModel.addAttribute("idea", this.iServ.getOneIdea(id));
		return "singleidea.jsp";
	}
	
	@GetMapping("/like/{id}")
	public String likeIdea(@PathVariable("id")Long id, HttpSession session) {
		User user = this.uServ.getOneUser((Long)session.getAttribute("user___id"));
		Idea ideaToLike = this.iServ.getOneIdea(id);
		this.iServ.likeIdea(ideaToLike, user);
		return "redirect:/idea";
	}
	
}
