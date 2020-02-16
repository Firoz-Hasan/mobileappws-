package com.firoz.mobileappws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.istack.NotNull;

public class UserDetailsRequestModel {

	@javax.validation.constraints.NotNull(message = "first name cat be null")
	@Size(min = 2, message = "first name must not be less then 2 character")
	private String firstName;
	@javax.validation.constraints.NotNull(message = "last name cat be null")
	@Size(min = 2, message = "last name must not be less then 2 character")
	private String lastName;
	@javax.validation.constraints.NotNull(message = "email cat be null")
	@Email
	private String email;
	@javax.validation.constraints.NotNull(message = "password cant be null")
	@Size(min = 2,max = 7, message = "password must not be less then 2 character")
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
