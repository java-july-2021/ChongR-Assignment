package com.chongren.CodingDojo.helloHuman;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloHumanController {
	@RequestMapping("/")
	public String human(){
		System.out.println("Hello");
		return "Hello Human!";
	}
	
	@RequestMapping("/user/{name}")
	public String greetName(@PathVariable("name") String name, Model viewModel) {
		viewModel.addAttribute("name", name);
		return "index.jsp";
	}
	
	
//	@RequestMapping("/")
//	public String index(Model model, @RequestParam(value="name", required=false, defaultValue="Human") String name) {
//		model.addAttribute("name", name);
//		return "index.jsp";
//	}

}
