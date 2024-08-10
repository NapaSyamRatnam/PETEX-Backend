package com.petex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petex.entity.VendorEntity;

public interface VendorRepository extends JpaRepository<VendorEntity, Long>{
	
	 public VendorEntity findByEmailAndPwd(String email,String pwd);
	 
	 public VendorEntity findByEmail(String email);
	 
	 public VendorEntity findByEmailAndOtp(String email,String otp);
	 
	 public boolean existsByEmail(String email);
	 
	


}
