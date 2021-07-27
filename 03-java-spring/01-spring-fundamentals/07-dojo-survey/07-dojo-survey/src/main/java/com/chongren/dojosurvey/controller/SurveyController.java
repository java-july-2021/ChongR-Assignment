package com.chongren.dojosurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
		private String processJoke(@RequestParam("name") String name, @RequestParam("location") String location, @RequestParam("lang") String lang,  @RequestParam("comment") String comment, Model viewModel) {

			viewModel.addAttribute("name",name);
			viewModel.addAttribute("location", location);
			viewModel.addAttribute("lang", lang);
			viewModel.addAttribute("comment", comment);
			
			if(lang.equals("Java")) {
				return "java.jsp";
			}
			
			
			return "result.jsp";
	}

}
