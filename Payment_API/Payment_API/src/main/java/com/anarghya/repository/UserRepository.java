package com.anarghya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarghya.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	/*
	 * public UserEntity findByEmailAndPwd(String email,String pwd);
	 * 
	 * public UserEntity findByEmail(String email);
	 * 
	 * public UserEntity findByEmailAndOtp(String email,String otp);
	 * 
	 * public boolean existsByEmail(String email);
	 */
	 
	


}
