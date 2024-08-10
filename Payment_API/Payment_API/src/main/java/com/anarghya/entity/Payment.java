package com.anarghya.entity;

import java.util.Random;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Payment {

	@Id
	@SequenceGenerator(name = "payment_tab_seq")
	@GeneratedValue(generator = "payment-id-generator")
	@GenericGenerator(name = "payment-id-generator", strategy = "com.anarghya.utils.CustomPaymentIdGenerator")
	private String paymentId;
	private String cardNumber;
	private String uplNumber;
	private String expirationDate;
	private int cvv;
	
	private String transactionId;
	
	@OneToOne
	@JsonIgnore
	private OrderEntity order;
	
	
	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	

	

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUplNumber() {
		return uplNumber;
	}

	public void setUplNumber(String uplNumber) {
		this.uplNumber = uplNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@PrePersist
	private void onCreate() {
		if (transactionId == null) {
			this.transactionId = generateRandomtransactionId(12);
		}

	}

	private String generateRandomtransactionId(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder orderIdBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			orderIdBuilder.append(characters.charAt(random.nextInt(characters.length())));
		}
		return orderIdBuilder.toString();
	}
}
