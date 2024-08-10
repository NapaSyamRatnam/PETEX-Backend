package com.petex.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petex.entity.AdoptionEntity;

public interface AdoptionRepo  extends JpaRepository<AdoptionEntity, Long>{

}
