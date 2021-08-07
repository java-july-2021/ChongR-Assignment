package com.chongren.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chongren.lookify.models.Lookify;
import com.chongren.lookify.services.LookifyService;


@Controller
public class LookifyController {
	private final LookifyService LServ;
	
	public LookifyController(LookifyService LServ) {
		this.LServ = LServ;
	}

	
	//Index Page
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//DashBoard
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {
		List<Lookify> allSongs = this.LServ.getAll();
		viewModel.addAttribute("allSongs", allSongs);
		return "dashboard.jsp";
	}
	
	//Create New Song
	@PostMapping("/songs/new")
	public String addNewSong(@Valid @ModelAttribute("song") Lookify lookify, BindingResult result, Model viewModel) {
		List<Lookify> allSongs = this.LServ.getAll();
		viewModel.addAttribute("allSongs", allSongs);
		return "new.jsp";
	}
	
	//Retrieve Song
	@GetMapping("/songs/{id}")
	public String displayTeams(@PathVariable("id") Long id, Model viewModel) {
		Lookify songToDisplay = this.LServ.findASong(id);
		viewModel.addAttribute("song", songToDisplay);
		return "show.jsp";
	}
	
	//Update Song
//	@PostMapping("/edit/{id}")
//	public String processEdit(@Valid @ModelAttribute("song") Lookify lookify, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
//		if(result.hasErrors()) {
//			viewModel.addAttribute("lookify", this.LServ.findASong(id));
//			return "edit.jsp";
//		}
//		this.LServ.updateASong(usong)
//		return "redirect:/" + id;
//	}
	
	
	//Delete Song
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.LServ.deleteASong(id);
		return "redirect:/";
	}
	
	
	
	
	
	
}
