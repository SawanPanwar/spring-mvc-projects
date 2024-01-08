package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "st_user")
public class UserDTO extends BaseDTO {

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName = null;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName = null;

	@Column(name = "LOGIN", length = 50)
	private String login = null;

	@Column(name = "PASSWORD", length = 50)
	private String password = null;

	@Column(name = "DOB", length = 50)
	private Date dob;

	@Column(name = "ADDRESS", length = 50)
	private String address = null;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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

}
