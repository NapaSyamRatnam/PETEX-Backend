 package com.anarghya.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_TAB")
public class OrderEntity {

	@Id
	@SequenceGenerator(name = "order_tab_seq")
	@GeneratedValue(generator = "order-id-generator")
	@GenericGenerator(name = "order-id-generator", strategy = "com.anarghya.utils.CustomOrderIdGenerator")
	private String orderId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userId")
	private UserEntity user;

//	@ManyToOne
//	@JsonIgnore
//	@JoinColumn(name = "productId")
//	private Product product;

	private String quantity;

	private LocalDate date;

	private String status;
	
	private String totalPrice;
	
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Payment payment;
	

	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public OrderEntity() {
		super();
	}

	public OrderEntity(String orderId, UserEntity user, String quantity, LocalDate date,
			String status) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.quantity = quantity;
		this.date = date;
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}


	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
 
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
