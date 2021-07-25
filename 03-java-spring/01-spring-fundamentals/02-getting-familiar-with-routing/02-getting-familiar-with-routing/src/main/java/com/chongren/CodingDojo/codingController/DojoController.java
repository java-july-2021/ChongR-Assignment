package com.chongren.CodingDojo.codingController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	
	@RequestMapping("/dojo")
	private String dojo() {
		return "The dojo is awesome!";
	}
	
	
	@RequestMapping("/dojo/{location}")
	public String dojoLocation(@PathVariable("location") String location) {
		switch(location){
		case "burbank":
			return "Burbank Dojo is located in Southern California";
			
		case "san-jose":
			return "SJ dojo is the headquarters";
			
		default:
			return String.format("The %s dojo is swesome~~", location);
		}
	}

}
