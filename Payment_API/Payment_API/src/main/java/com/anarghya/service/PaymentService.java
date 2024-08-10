package com.anarghya.service;

import java.io.IOException;

import com.anarghya.entity.Payment;
import com.lowagie.text.DocumentException;

public interface PaymentService {

	Boolean savePayment(Payment payment,String orderId)throws DocumentException, IOException;
	
	Payment getfindById(String id);
}
