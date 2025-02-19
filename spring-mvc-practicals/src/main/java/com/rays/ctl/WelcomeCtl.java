package com.rays.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "WelcomeCtl")
public class WelcomeCtl {

	@GetMapping
	public String display() {
		return "Welcome";
	}
	
	@GetMapping("display")
	public String display1() {
		return "Welcome";
	}
	
	@GetMapping("getMessage")
	public String getMessage(Model model) {
		model.addAttribute("msg", "Welcome to Spring MVC..!!");
		return "Welcome";
	}
}