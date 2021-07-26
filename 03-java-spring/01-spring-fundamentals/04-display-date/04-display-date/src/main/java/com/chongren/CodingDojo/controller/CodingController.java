package com.chongren.CodingDojo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller   //why doesn't working with @Controller, what is the difference between RestController and Controller, and how to run them
public class CodingController {
	
	
	@RequestMapping("/")
	public String front() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model viewModel) {
		LocalDateTime day = LocalDateTime.now();
		viewModel.addAttribute("date", day);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model viewModel) {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:m a");
		viewModel.addAttribute("time", formatter.format(time));
		return "time.jsp";
	}
}

//The webpage is showing "index.jsp", instead of rendering the .jsp
