package com.booking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entity.DayCareBooking;
@Repository
public interface BookRepo extends JpaRepository<DayCareBooking, Long> {
	  
    List<DayCareBooking> findByUserUserId(Long userId);
    
    List<DayCareBooking> findByDayCareId(Long dayCareId);

}



