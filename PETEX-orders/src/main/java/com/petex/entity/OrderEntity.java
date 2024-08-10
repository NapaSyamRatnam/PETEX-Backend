package com.petex.entity;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_TAB")
public class OrderEntity {

	@Id
	@SequenceGenerator(name = "order_tab_seq")
	@GeneratedValue(generator = "order-id-generator")
	@GenericGenerator(name = "order-id-generator", strategy = "com.petex.utils.CustomOrderIdGenerator")
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

	private String productName;
	
	private String totalPrice;
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderEntity() {
		super();
	}

	public OrderEntity(String orderId, UserEntity user, String quantity, LocalDate date, String productName) {
		super();
		this.orderId = orderId;
		this.user = user;
//		this.product = product;
		this.quantity = quantity;
		this.date = date;
		this.productName = productName;
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

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

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
	
    @PrePersist
    protected void onCreate() {
        // Set the current date before persisting
        this.date = LocalDate.now();
    }

//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}

}
