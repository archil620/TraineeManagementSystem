package com.igate.tms.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

	private String username;
	private String password;
	
	@NotEmpty(message="Username is empty")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@NotEmpty(message="Password is empty")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
