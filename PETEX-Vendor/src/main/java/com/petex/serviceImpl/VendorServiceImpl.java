package com.petex.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petex.binding.LoginForm;
import com.petex.binding.NewConfirmPwdForm;
import com.petex.binding.OtpForm;
import com.petex.binding.VendorSingUpForm;
import com.petex.entity.VendorEntity;
import com.petex.repository.VendorRepository;
import com.petex.service.VendorService;
import com.petex.utils.EmailUtils;
import com.petex.utils.PasswordUtil;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository repo;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String singUpUser(VendorSingUpForm form) {
		if (form.getPwd().equals(form.getConfirmPwd())) {
			if (!repo.existsByEmail(form.getEmail())) {
				VendorEntity entity = new VendorEntity();
				BeanUtils.copyProperties(form, entity);
				repo.save(entity);
				return "Signup successful";
			} else {
				return "Email already exists. Please use a different email.";
			}
		}
		return "Invalid password and confirmation password";
	}

	@Override
	public String login(LoginForm form) {
		VendorEntity findByEmailAndPaw = repo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		if (findByEmailAndPaw != null) {
			return "login success";

		}
		return "check pwd and email";
	}

	@Override
	public Boolean forgetPwd(String email) {
		VendorEntity entity = repo.findByEmail(email);
		if (entity == null) {
			return false;
		}
		String toEmail = entity.getEmail();
		String otp = PasswordUtil.genrateRandomPassword();
		entity.setOtp(otp);
		repo.save(entity);
		String subject = "New Optp";
		StringBuffer body = new StringBuffer("");
		body.append("take this temprory otp::" + otp);
		emailUtils.sendEmail(toEmail, subject, body.toString());
		return true;
	}

	@Override
	public String validOtp(OtpForm form) {
		VendorEntity findByEmailAndOtp = repo.findByEmailAndOtp(form.getEmail(), form.getOtp());
		if (findByEmailAndOtp != null) {
			return "otp confirmed";
		}
		return "otp and email mismatch";
	}

	@Override
	public String confirmPassword(NewConfirmPwdForm form) {
		VendorEntity entity = repo.findByEmail(form.getEmail());
		if (entity != null) {
			if (form.getPwd().equals(form.getConfirmPwd())) {

				entity.setPwd(form.getPwd());
				entity.setConfirmPwd(form.getConfirmPwd());
				repo.save(entity);
				return "Your password has been successfully updated";
			} else {
				return "Password and confirmation password do not match";
			}
		}
		return "Failed to update password. Please check your current password and try again.";
	}

	@Override
	public Boolean updateUser(Long vendorId, VendorEntity entity) {
		Optional<VendorEntity> optionalEntity = repo.findById(vendorId);
		if (optionalEntity.isPresent()) {
			VendorEntity userEntity = optionalEntity.get();
			BeanUtils.copyProperties(entity, userEntity);
			userEntity.setvendorId(vendorId);
			repo.save(userEntity);
			return true;
		}
	
		return false;
	}

	@Override
	public Boolean deleteUser(Long vendorId) {
		repo.deleteById(vendorId);
		return true;
	}

	@Override
	public List<VendorEntity> getAll() {
		
		return repo.findAll();
	}
	
	@Override
	public VendorEntity getById(Long vendorId) {
		Optional<VendorEntity> optinalid = repo.findById(vendorId);
		if (optinalid.isPresent()) {
			return optinalid.get();
		}
		return null;
	}

	@Override
	public VendorEntity getvendorByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}
	
	@Override
    public VendorEntity getTestReportById(Long vendorId) {
        Optional<VendorEntity> optionalTestReport = repo.findById(vendorId);
        return optionalTestReport.orElse(null);
    }

}
