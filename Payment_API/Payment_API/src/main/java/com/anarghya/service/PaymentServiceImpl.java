package com.anarghya.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghya.entity.OrderEntity;
import com.anarghya.entity.Payment;
import com.anarghya.repository.OrderRepo;
import com.anarghya.repository.PaymentRepository;
import com.anarghya.utils.EmailUtils;
import com.anarghya.utils.PdfGenerator;
import com.lowagie.text.DocumentException;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private final PaymentRepository paymentRepository;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private PdfGenerator pdfGenerator;

	@Autowired
	private OrderRepo orderRepo;

	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Payment getfindById(String id) {
		return paymentRepository.findById(id).orElse(null);
	}

	@Override
	public Boolean savePayment(Payment payment, String orderId) throws DocumentException, IOException {
		Optional<OrderEntity> optinalOrder = orderRepo.findById(orderId);
		if (optinalOrder.isPresent()) {
			OrderEntity order = optinalOrder.get();
			payment.setOrder(order);

			paymentRepository.save(payment);
			
			File f= new File("Accknowldgement.pdf");
			pdfGenerator.generate(payment, f);
			
			String subject = "Accknowldgement Report";
			String body = "Payment Accknowldgement";
			String to = order.getUser().getEmail();

			emailUtils.sendEmail(subject, body, to, f);
			f.delete();
			
			return true;
			
			
		}
		return false;
	}

}