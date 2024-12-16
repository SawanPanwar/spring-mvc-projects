package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
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

		form.setPageNo(pageNo);

		model.addAttribute("list", list);

		return "UserListView";
	}

	@PostMapping("search")
	public String search(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation,
			Model model) {

		System.out.println("search 1");

		UserDTO dto = null;

		int pageNo = 1;
		int pageSize = 5;

		if (operation.equals("next")) {
			System.out.println("search 2");
			pageNo = form.getPageNo();
			pageNo++;
		}

		if (operation.equals("previous")) {
			pageNo = form.getPageNo();
			pageNo--;
		}

		if (operation.equals("add")) {
			return "redirect:/User";
		}

		if (operation.equals("search")) {
			dto = new UserDTO();
			dto.setFirstName(form.getFirstName());
		}

		if (operation.equals("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {
				for (long id : form.getIds()) {
					service.delete(id);
				}
			}
		}

		System.out.println("search 3");

		form.setPageNo(pageNo);

		List list = service.search(dto, pageNo, pageSize);

		model.addAttribute("list", list);

		return "UserListView";
	}
}