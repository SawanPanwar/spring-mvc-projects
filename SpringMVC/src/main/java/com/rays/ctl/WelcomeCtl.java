package com.rays.ctl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "Welcome")
public class WelcomeCtl {

	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public String display(Locale locale) {
		String msg = messageSource.getMessage("lable.hindi", null, locale);
		System.out.println(msg);
		return "Welcome";
	}

	/*
	 * @GetMapping public String getMessage(Model model) { model.addAttribute("msg",
	 * "Welcome to Spring MVC..!!"); return "Welcome"; }
	 */

}
