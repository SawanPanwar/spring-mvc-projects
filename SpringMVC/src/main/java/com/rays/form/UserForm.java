package com.rays.form;

import org.hibernate.validator.constraints.NotEmpty;

import com.rays.dto.BaseDTO;
import com.rays.dto.UserDTO;
import com.rays.util.DataUtility;

public class UserForm extends BaseForm {

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private String login;

	@NotEmpty
	private String password;

	@NotEmpty
	private String dob;

	@NotEmpty
	private String address;

	protected long userId = 0;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLogin(login);
		dto.setPassword(password);
		dto.setDob(DataUtility.stringToDate(dob));
		dto.setAddress(address);
		dto.setUserId(userId);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		if (bDto == null) {
			return;
		}
		UserDTO dto = (UserDTO) bDto;
		id = dto.getId();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		login = dto.getLogin();
		password = dto.getPassword();
		dob = DataUtility.dateToString(dto.getDob());
		address = dto.getAddress();
		userId = dto.getUserId();
	}

}
