package com.petex.entity;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	private String cardNumber;
	private Long uplNumber;
	private String expirationDate;
	private int cvv;

	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "orderId")
	private OrderEntity order;

	private String transactionId;

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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

	public Long getUplNumber() {
		return uplNumber;
	}

	public void setUplNumber(Long uplNumber) {
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
