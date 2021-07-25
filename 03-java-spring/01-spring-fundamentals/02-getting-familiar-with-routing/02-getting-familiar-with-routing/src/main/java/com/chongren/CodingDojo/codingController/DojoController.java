package com.chongren.CodingDojo.codingController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoController {
	
//	@RequestMapping("/{location}")
//	private String dojoLocation(@PathVariable("location") String location, Model viewModel) {
//		viewModel.addAttribute("location", location);
//		return "location.jsp";
//	}
	
//	@RequestMapping(value="/tellAJoke", method=RequestMethod.POST)
//	private String processJoke(@RequestParam("name") String name, @RequestParam("joke") String joke, Model viewModel) {
////		System.out.println(name + joke);
//		viewModel.addAttribute("name",name);
//		viewModel.addAttribute("joke", joke);
//		return "showJoke.jsp";
//	}
	
	
	@RequestMapping(value="/dojo", method=RequestMethod.GET)
	public String location(@RequestParam(value="l", required = false) String l, Model viewModel) {
		viewModel.addAttribute("l", l);
		return "location.jsp";
	}
	
	

}
