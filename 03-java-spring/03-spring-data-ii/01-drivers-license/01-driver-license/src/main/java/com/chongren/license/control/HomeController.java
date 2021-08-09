package com.chongren.license.control;

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

import com.chongren.license.model.License;
import com.chongren.license.model.Person;
import com.chongren.license.service.DMVService;

@Controller   
public class HomeController {
	@Autowired
	DMVService dService;
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		 viewModel.addAttribute("persons", this.dService.getAllPeople());
		 return "index.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "new.jsp";
	}
	
	@PostMapping("/new")
//	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String processPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.dService.createPerson(person);
		return "redirect:/";
	}
	
	@GetMapping("/licenses/create")
	public String newLicense(Model viewModel, @ModelAttribute("license") License license) {
		viewModel.addAttribute("people", this.dService.getUnlicensedPeople());
		return "newlicense.jsp";
	}
	
	@PostMapping("/newlicense")
//	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String processLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("people", this.dService.getUnlicensedPeople());
			return "newlicense.jsp";
		}
		this.dService.createLicense(license);
		return "redirect:/";
	}
	
//	User Detail Dashboard
	@GetMapping("/{id}")
	public String show(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("person", this.dService.getOnePerson(id));
		return "show.jsp";
	}
	

	
	
}
