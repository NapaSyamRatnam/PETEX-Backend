package com.petshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshow.entity.PetshowEntity;

public interface PetshowRepo extends JpaRepository<PetshowEntity, Long> {

}
