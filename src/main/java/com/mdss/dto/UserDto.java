package com.mdss.dto;

import com.mdss.entities.User;

public class UserDto {
	
	private String email;
	private String password;
	
	public UserDto() {
		
	}
	
	public UserDto(User obj) {
		email = obj.getEmail();
		password = obj.getPassword();
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
