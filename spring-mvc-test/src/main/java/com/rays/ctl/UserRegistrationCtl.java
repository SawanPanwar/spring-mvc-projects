package com.rays.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.form.UserRegistrationForm;

@Controller
@RequestMapping(value = "Register")
public class UserRegistrationCtl {

	@GetMapping
	public String display(@ModelAttribute("form") UserRegistrationForm form) {
		return "UserRegistration";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserRegistrationForm form) {
		
		System.out.println(form.getFirstName());
		System.out.println(form.getLastName());
		System.out.println(form.getLogin());
		System.out.println(form.getPassword());
		System.out.println(form.getDob());
		System.out.println(form.getAddress());

		return "UserRegistration";
	}

}
