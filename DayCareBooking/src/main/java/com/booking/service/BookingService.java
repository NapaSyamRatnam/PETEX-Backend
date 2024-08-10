package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.entity.DayCareBooking;
import com.booking.repo.BookRepo;

@Service
public class BookingService {
	@Autowired
	private BookRepo repo;
	
	   public DayCareBooking saveBooking(DayCareBooking bookingDetails) {
	        return repo.save(bookingDetails);
	    }
	
	  
    public List<DayCareBooking> findByUserId(Long userId) {
        return repo.findByUserUserId(userId);
    }
    
    public List<DayCareBooking> findByDayCareId(Long dayCareId) {
        return repo.findByDayCareId(dayCareId);
    }
    
	
	public List<DayCareBooking> getAllServices() {
		 return repo.findAll();
	}

}
