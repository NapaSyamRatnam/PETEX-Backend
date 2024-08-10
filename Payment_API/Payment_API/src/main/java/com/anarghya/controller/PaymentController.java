package com.anarghya.controller;

import java.io.IOException;

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

import com.anarghya.entity.Payment;
import com.anarghya.service.PaymentService;
import com.lowagie.text.DocumentException;


@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000") 
public class PaymentController {
	
	@Autowired
    private PaymentService paymentService;

	@PostMapping("/save/{orderId}")
	public ResponseEntity<String> savePayment(@RequestBody Payment payment, @PathVariable String orderId) {
	    try {
	        Boolean savedPayment = paymentService.savePayment(payment, orderId);
	        if (savedPayment) {
	            return ResponseEntity.ok("Payment saved successfully");
	        } else {
	            return ResponseEntity.ok("Failed to save payment");
	        }
	    } catch (Exception e) {
	        // Log the exception for troubleshooting
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving payment");
	    }
	}

    
    
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getFindById(@PathVariable String id) {
        Payment payment = paymentService.getfindById(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
