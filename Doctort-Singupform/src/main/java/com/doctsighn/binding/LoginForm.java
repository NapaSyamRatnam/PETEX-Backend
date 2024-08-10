package com.doctsighn.binding;

import lombok.Data;

@Data
public class LoginForm {	
	private String email;
	private String pwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return pwd;
	}
	public void setPassword(String pwd) {
		this.pwd = pwd;
	}
	
	
	

}
