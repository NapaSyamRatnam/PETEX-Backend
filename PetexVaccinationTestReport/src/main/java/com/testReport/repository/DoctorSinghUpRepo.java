package com.testReport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testReport.entity.DoctorEntity;

@Repository
public interface DoctorSinghUpRepo extends JpaRepository<DoctorEntity, Long> {

	
}
