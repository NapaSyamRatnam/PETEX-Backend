package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.DayCareBooking;
import com.booking.entity.UserEntity;
import com.booking.service.BookingService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/book")
public class BookingControl {
    
    @Autowired
    public BookingService service;

    @PostMapping("/{userId}")
    public DayCareBooking saveBooking(@PathVariable Long userId, @RequestBody DayCareBooking bookingDetails) {
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        bookingDetails.setUser(user);
        return service.saveBooking(bookingDetails);
    }
    
    @GetMapping("/user/{userId}")
    public List<DayCareBooking> findByUserId(@PathVariable Long userId) {
        return service.findByUserId(userId);
    }

    
    @GetMapping("/daycare/{dayCareId}")
    public ResponseEntity<List<DayCareBooking>> getBookingsByDayCareId(@PathVariable Long dayCareId) {
        List<DayCareBooking> bookings = service.findByDayCareId(dayCareId);
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public List<DayCareBooking> getAllServices() {
        return service.getAllServices();
    }
}
