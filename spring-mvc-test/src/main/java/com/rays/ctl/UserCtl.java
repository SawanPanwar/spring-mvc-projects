package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.form.UserForm;
import com.rays.service.UserService;

@Controller
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	public UserService service;

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form) {
		return "UserView";
	}

	@GetMapping("search")
	public String display(@ModelAttribute("form") UserForm form, Model model) {

		int pageNo = 1;
		int pageSize = 5;

		List list = service.search(null, pageNo, pageSize);

		model.addAttribute("list", list);

		return "UserListView";
	}
}