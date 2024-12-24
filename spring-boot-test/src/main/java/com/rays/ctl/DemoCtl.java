package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.DemoResponse;
import com.rays.common.ORSResponse;
import com.rays.dto.Person;

@RestController
@RequestMapping(value = "Demo")
public class DemoCtl {

	@GetMapping("display")
	public String display() {
		return "Spring Boot Application";
	}

	@GetMapping("display1")
	public Person display1() {

		Person person = new Person();

		person.setFirstName("sagar");
		person.setLastName("yash");
		person.setLoginId("pqr@gmail.com");
		person.setPassword("pqr123");
		return person;
	}

	@GetMapping("display2")
	public DemoResponse display2() {

		DemoResponse res = new DemoResponse();

		Person dto1 = new Person();

		dto1.setFirstName("sagar");
		dto1.setLastName("yash");
		dto1.setLoginId("pqr@gmail.com");
		dto1.setPassword("pqr123");

		Person dto2 = new Person();

		dto2.setFirstName("abc");
		dto2.setLastName("xyz");
		dto2.setLoginId("abc@gmail.com");
		dto2.setPassword("abc123");

		Map map = new HashMap();
		map.put("dto1", dto1);
		map.put("dto2", dto2);

		res.setResult(map);

		res.setMessage("data addedd successfully");

		res.setData("person object");

		return res;
	}

	@GetMapping("display3")
	public ORSResponse display3() {

		ORSResponse res = new ORSResponse();

		Map errors = new HashMap();
		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("loginId", "login id is required");
		errors.put("password", "password is required");

		res.addInputError(errors);

		Person dto = new Person();

		dto.setFirstName("sagar");
		dto.setLastName("yash");
		dto.setLoginId("pqr@gmail.com");
		dto.setPassword("pqr123");

		Person dto1 = new Person();

		dto1.setFirstName("sagar");
		dto1.setLastName("yash");
		dto1.setLoginId("pqr@gmail.com");
		dto1.setPassword("pqr123");

		Person dto2 = new Person();

		dto2.setFirstName("abc");
		dto2.setLastName("xyz");
		dto2.setLoginId("abc@gmail.com");
		dto2.setPassword("abc123");

		List list = new ArrayList();
		list.add(dto);
		list.add(dto1);
		list.add(dto2);
		res.addData(list);

		res.addMessage("login & password invalid");

		res.addResult("token", "highcfc1tr4564465ghcgf");

		res.setSuccess(true);

		return res;
	}

	@PostMapping("submit")
	public ORSResponse submit(@RequestBody Person person) {
		ORSResponse res = new ORSResponse();
		res.addData(person);
		return res;
	}
}
