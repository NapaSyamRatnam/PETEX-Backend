package com.items.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT-TAB")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "custom-id")
	@GenericGenerator(name = "custom-id", strategy = "com.items.utils.CustomProductIdGenerator")
	private String productId;
	private String category;
	private String name;
	private Integer price;
	private String brand;
	
	@Column(length = 10000)
	private String descrption;
	

	private Integer stock;
	private Long vendord;
	private String feature;
	private String type;

	 @Lob
	    @Column(columnDefinition = "MEDIUMBLOB")
	    private String image;
	




	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Long getVendord() {
		return vendord;
	}

	public void setVendord(Long vendord) {
		this.vendord = vendord;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	
	
}
