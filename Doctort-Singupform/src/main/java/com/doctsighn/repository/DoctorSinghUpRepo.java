package com.doctsighn.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctsighn.entity.DoctorEntity;





@Repository
public interface DoctorSinghUpRepo extends JpaRepository<DoctorEntity, Long> {
   
	
	 public DoctorEntity findByEmailAndPwd(String email,String pwd);

	 public DoctorEntity findByEmail(String email);
	 
	 public DoctorEntity findByEmailAndOtp(String email,String otp);
	 
	 public boolean existsByEmail(String email);
	 
//	  DoctorEntity findByImage(byte[] image);
	  
	  List<DoctorEntity> findByDoctorNameContaining(String doctorName);
	  
		List<DoctorEntity> findByLocation(String location);
}
