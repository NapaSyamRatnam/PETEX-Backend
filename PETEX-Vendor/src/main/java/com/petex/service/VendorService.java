package com.petex.service;

import java.util.List;

import com.petex.binding.LoginForm;
import com.petex.binding.NewConfirmPwdForm;
import com.petex.binding.OtpForm;
import com.petex.binding.VendorSingUpForm;
import com.petex.entity.VendorEntity;

public interface VendorService {
	
	public String singUpUser(VendorSingUpForm form);
	
	public String login(LoginForm form);
	
	public Boolean forgetPwd(String email);
	
	public String validOtp(OtpForm form); 
	
	public String confirmPassword(NewConfirmPwdForm form);
	
	public Boolean updateUser(Long vendorId, VendorEntity entity);
	
	public Boolean deleteUser(Long vendorId);

	public List<VendorEntity> getAll();
	
	public VendorEntity getById(Long vendorId);

	public VendorEntity getvendorByEmail(String email); 
	
	public VendorEntity getTestReportById(Long vendorId); 


}
