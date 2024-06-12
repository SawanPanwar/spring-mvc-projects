package com.rays.ctl;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.service.UserService;

@Controller
@RequestMapping(value = "Login")
public class LoginCtl {

	@Autowired
	public UserService service;

	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public String display(@ModelAttribute("form") LoginForm form, @RequestParam(required = false) String operation,
			HttpSession session, Locale locale) {

		if (operation != null && operation.equals("logout")) {
			session.invalidate();
			return "redirect:Login";
		}

		return "LoginView";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") @Valid LoginForm form, BindingResult bindingResult,
			@RequestParam(required = false) String operation, HttpSession session, Locale locale) {

		if (operation.equals("signUp")) {
			return "redirect:Register";
		}

		if (bindingResult.hasErrors()) {
			return "LoginView";
		}

		UserDTO dto = service.authenticate(form.getLogin(), form.getPassword());

		if (dto != null) {
			session.setAttribute("user", dto);
			return "redirect:Welcome";
		}
		return "LoginView";
	}

}
