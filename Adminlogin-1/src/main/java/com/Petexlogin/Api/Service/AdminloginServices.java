package com.Petexlogin.Api.Service;


import java.util.List;

import com.Petexlogin.Api.Entity.AdminLogin;
import com.Petexlogin.Api.Entity.AdminSingUpEntity;

public interface AdminloginServices {

	public Boolean adminlogin(AdminSingUpEntity entity);

	public String adminLogin(AdminLogin login);

	public String forgetPassword(String email, String password);

	public AdminSingUpEntity getById(Long adminId); 
	public List<AdminSingUpEntity> getdata();

	public AdminSingUpEntity getAdminSingUpEntityByEmail(String email);
	
	

}
