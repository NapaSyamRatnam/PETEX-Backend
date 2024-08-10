package com.doctsighn.binding;



import lombok.Data;

@Data

public class NewConfirmPwdForm {

	private String pwd;
	private String confirmPwd;
	private String email;
	public String getPassword () {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
