package com.booking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.UserEntity;


public interface UserRepo extends JpaRepository<UserEntity, Long> {

	UserEntity findByEmailAndPwd(String email, String pwd);
	
}
