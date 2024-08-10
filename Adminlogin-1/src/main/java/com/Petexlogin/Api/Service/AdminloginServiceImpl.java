package com.Petexlogin.Api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Petexlogin.Api.Entity.AdminLogin;
import com.Petexlogin.Api.Entity.AdminLogin;
import com.Petexlogin.Api.Entity.AdminSingUpEntity;
import com.Petexlogin.Api.Repo.AdminloginRepository;


@Service
public class AdminloginServiceImpl implements AdminloginServices {

	@Autowired
	private AdminloginRepository repo;



	@Override
	public Boolean adminlogin(AdminSingUpEntity entity) {
		repo.save(entity);
		return true;
	}

	@Override
	public String adminLogin(AdminLogin login) {
		AdminSingUpEntity adminEntity = repo.findByEmailAndPassword(login.getEmail(),login.getPassword());
		if (adminEntity != null) {
			return "login Successfully";
		}
		return "check email and password";
	}	
	
	@Override
	public String forgetPassword(String email, String password) {
        AdminSingUpEntity adminEntity = repo.findByEmail(email);
        if (adminEntity != null) {
            adminEntity.setPassword(password);
            repo.save(adminEntity);
            return "Password updated successfully";
        }
        return "User not found";
    }

	@Override
	public AdminSingUpEntity getById(Long adminId) {
		Optional<AdminSingUpEntity> optinalid = repo.findById(adminId);
		if (optinalid.isPresent()) {
			return optinalid.get();
		}
		return null;
	}
	

    public List<AdminSingUpEntity> getdata() {
        return repo.findAll();
    }

	@Override
	public AdminSingUpEntity getAdminSingUpEntityByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}
	
}
		