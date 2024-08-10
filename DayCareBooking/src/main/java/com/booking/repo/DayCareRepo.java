package com.booking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entity.DayCareEntity;

@Repository
public interface DayCareRepo extends JpaRepository<DayCareEntity, Long> {
    
}

