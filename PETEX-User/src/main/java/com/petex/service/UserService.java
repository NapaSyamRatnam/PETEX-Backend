package com.petex.service;

import java.util.List;

import com.petex.binding.LoginForm;
import com.petex.binding.NewConfirmPwdForm;
import com.petex.binding.OtpForm;
import com.petex.binding.UserSingUpForm;
import com.petex.entity.UserEntity;

public interface UserService {
	
	public String singUpUser(UserEntity form);
	
	public String login(LoginForm form);
	
	public Boolean forgetPwd(String email);
	
	public String validOtp(OtpForm form); 
	
	public String confirmPassword(NewConfirmPwdForm form);
	
	public Boolean updateUser(Long userId, UserEntity entity);
	
	public Boolean deleteUser(Long userId);
	
	public List<UserEntity> getAllUser();
	
	public UserEntity getById(Long userId); 
	
	public UserEntity getUserByEmail(String email);
	
	
}
