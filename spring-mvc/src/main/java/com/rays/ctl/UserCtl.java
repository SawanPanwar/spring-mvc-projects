package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceImpl;
import com.rays.util.DataUtility;

@Controller
@RequestMapping(value = "User")
public class UserCtl {

	@Autowired
	public UserServiceImpl service;

	@ModelAttribute("form")
	public void preload(Model model) {
		List list = service.search(null, 0, 0);
		model.addAttribute("userList", list);
	}

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form, @RequestParam(required = false) Long id, Model model) {

		if (id != null && id > 0) {
			UserDTO dto = service.findByPk(id);
			form.setId(dto.getId());
			form.setFirstName(dto.getFirstName());
			form.setLastName(dto.getLastName());
			form.setLogin(dto.getLogin());
			form.setPassword(dto.getPassword());
			form.setDob(DataUtility.dateToString(dto.getDob()));
			form.setAddress(dto.getAddress());
		}

		return "UserView";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") @Valid UserForm form, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "UserView";
		}

		UserDTO dto = new UserDTO();
		dto.setId(form.getId());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setDob(DataUtility.stringToDate(form.getDob()));
		dto.setAddress(form.getAddress());

		if (form.getId() > 0) {
			service.update(dto);
		} else {
			service.add(dto);
		}
		return "UserView";
	}

	@GetMapping("search")
	public String display(@ModelAttribute("form") UserForm form, Model model) {

		List list = service.search(null, 1, 5);

		model.addAttribute("list", list);

		return "UserListView";

	}

	@PostMapping("search")
	public String search(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation,
			Model model) {

		UserDTO dto = null;

		if (operation.equals("search")) {

			dto = new UserDTO();

			dto.setId(form.getId());

			dto.setFirstName(form.getFirstName());

		}if (operation.equals("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {
				for (long id : form.getIds()) {
					service.delete(id);
				}
			}
		}

		List list = service.search(dto, 1, 5);

		model.addAttribute("list", list);

		return "UserListView";

	}

}
