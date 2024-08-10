package com.petshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshow.entity.AdminSingUpEntity;

@Repository
public interface AdminloginRepository extends JpaRepository<AdminSingUpEntity, Long> {

	AdminSingUpEntity findByEmailAndPassword(String email, String password);

	AdminSingUpEntity findByEmail(String email);

}
