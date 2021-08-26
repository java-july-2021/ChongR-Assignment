package com.chongren.events.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chongren.events.model.Event;
import com.chongren.events.model.User;
import com.chongren.events.service.EventManagerService;
import com.chongren.events.service.UserService;


@Controller
public class HomeController {
	@Autowired
	private UserService uServ;
	
	@Autowired
	private EventManagerService eServ;
	
//	@Autowired
//	private UserValidator validator;
	
	
	//================== Dashboard =================//
	@GetMapping("/dashboard")
	public String index(Model viewModel, HttpSession session, RedirectAttributes redirectAttr, @ModelAttribute("event")Event event) {
		if(session.getAttribute("user___id") == null) {
			redirectAttr.addFlashAttribute("message", "You need to log in first!");
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user___id");
		User user = this.uServ.getOneUser(userId);
		viewModel.addAttribute("EventSameState", this.eServ.showSameStateEvent(user.getState()));
		viewModel.addAttribute("EventOtherState", this.eServ.showOtherStateEvent(user.getState()));
		viewModel.addAttribute("user", user);
		return "dashboard.jsp";	
	}  
	
	@PostMapping("/createEvent")
	public String creatingEvent(@Valid @ModelAttribute("event")Event event, Model viewModel, HttpSession session, BindingResult result) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user___id");
			User user = this.uServ.getOneUser(userId);
			viewModel.addAttribute("EventSameState", this.eServ.showSameStateEvent(user.getState()));
			viewModel.addAttribute("EventOtherState", this.eServ.showOtherStateEvent(user.getState()));
			viewModel.addAttribute("user", user);
			return "dashboard.jsp";
		}
		this.eServ.createEvent(event);
		return "/dashboard";
	}
	
	
		
	//================== Event Detail & Message =================//
	@GetMapping("/event/{id}")
	public String showEvent(@PathVariable("id")Long event_id, Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user___id");
		if(session.getAttribute("user___id") == null) {
			return "redirect:/";
		}
		if(event_id == null) {
			return "redirect:/dashboard";
		}
		viewModel.addAttribute("event", this.eServ.findAEvent(event_id));
		viewModel.addAttribute("user",this.uServ.getOneUser(userId));
		return "EventDetail.jsp";
	}
	
	
	
	@PostMapping("/eventinfo/{id}")
	public String addMessage(@Valid @RequestParam("message")String message, @PathVariable("id")Long event_id, Model viewModel, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("user___id");
		if(session.getAttribute("user___id") == null) {
			return "redirect:/";
		}
		Event event = this.eServ.findAEvent(event_id);
		User user = this.uServ.getOneUser(userId);
		this.eServ.comment(user, event, message);
		return "/event/" + event_id;
	}
		
		
	//================== Edit Event =================//
		
	@GetMapping("/editEvent/{id}")
	public String eventToChange(@PathVariable("id")Long event_id, Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user___id");
		Event event = this.eServ.findAEvent(event_id);
		viewModel.addAttribute("event", event);
		viewModel.addAttribute("user",this.uServ.getOneUser(userId));
		return "UpdateEvent.jsp";
	}
	
	
	@PostMapping("/editEventInfo/{id}")
	public String processEventChange(@Valid @ModelAttribute("event")Event event, @PathVariable("id")Long event_id, Model viewModel, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("user___id");
		if(result.hasErrors()) {
			viewModel.addAttribute("event", event);
			viewModel.addAttribute("userId", userId);
			return "UpdateEvent.jsp";
		}
		this.eServ.updateEvent(event);
		return "/dashboard";
	}
	
	
	//================== Join Event =================//
	
	@GetMapping("event/{id}/a/{choice}")
	public String ManageAttendeees(@PathVariable("id") Long event_id, @PathVariable("choice") String choice, HttpSession session) {
		Long userId = (Long)session.getAttribute("user___id");
		Event event = this.eServ.findAEvent(event_id);
		boolean isJoining = (choice.equals("join"));
		if(userId == null)
			return "redirect:/";
		
		User user = this.uServ.getOneUser(userId);
		this.eServ.manageAttendees(event, user, isJoining);
		
		return "redirect:/dashboard";
	}
	
	//================== Delete Event =================//
	
	@DeleteMapping("/deldetEvent/{id}")
	public String Delete(@PathVariable("id") Long id) {
		this.eServ.deleteEvent(id);
		return "redirect:/dashboard";
	}
	
	
	
	
	
		
}