package com.chongren.dojoninja.controll;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chongren.dojoninja.model.Dojo;
import com.chongren.dojoninja.model.Ninja;
import com.chongren.dojoninja.service.MasterService;

@Controller
public class HomeController {

	@Autowired
	MasterService mServ;
	
	//------Index---------//
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("allDojo", this.mServ.allDojo());
		return "index.jsp";
	}
	
	//-------Create Dojo------//
	@GetMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/newdojo")
	public String processDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		}
		this.mServ.createDojo(dojo);
		return "redirect:/";
	}
	
	
	//-------Create Ninja------//
	@GetMapping("/ninja/new")
	public String newNinja(Model viewModel, @ModelAttribute("ninja")Ninja ninja) {
		List<Dojo> allDojos = this.mServ.allDojo();
		viewModel.addAttribute("allDojos", allDojos);
		return "newninja.jsp";
	}
	
	@PostMapping("/newninja")
	public String processNinja(Model viewModel,@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.mServ.allDojo();
			viewModel.addAttribute("allDojos", allDojos);
		}
		this.mServ.createNinja(ninja);
		return "redirect:/";
	}
	
	
	//-----------Show Ninja of A Dojo------------//
	@GetMapping("/dojo/{id}")
	public String show(Model viewModel, @PathVariable("id")Long id) {
		viewModel.addAttribute("dojo", this.mServ.getDojo(id));
		return "show.jsp";
	}
	
	
	//----------------Edit & Delete-----------------//
	
	
//	@GetMapping("/edit/{id}")
//	public String editPlayer(@PathVariable("id") Long id, @ModelAttribute("team") Team team, Model viewModel) {
//		viewModel.addAttribute("team", this.tService.getOne(id));
//		return "edit.jsp";
//	}
//	
//	@PostMapping("/edit/{id}")
//	public String processEdit(@Valid @ModelAttribute("team") Team team, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
//		if(result.hasErrors()) {
//			viewModel.addAttribute("team", this.tService.getOne(id));
//			return "edit.jsp";
//		}
//		this.tService.update(team);
//		return "redirect:/" + id;
//	}
//	
//	@GetMapping("/delete/{id}")
//	public String delete(@PathVariable("id") Long id) {
//		this.tService.deleteById(id);
//		return "redirect:/";
//	}
	
	
	
}
