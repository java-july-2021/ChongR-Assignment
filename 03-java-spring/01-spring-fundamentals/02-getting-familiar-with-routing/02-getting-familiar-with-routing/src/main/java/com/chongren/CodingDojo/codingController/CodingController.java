package com.chongren.CodingDojo.codingController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	@RequestMapping("/")
	private String hello() {
		return "Hello Coding Dojo!";
	}
	
	
	@RequestMapping("/coding/python")
	private String pythonCool() {
		return "Python/Django was awesome!";
	}
	
	
	@RequestMapping("/coding/java")
	private String javaCool() {
		return "Java/Spring is better!";
	}
	
	
	
}
