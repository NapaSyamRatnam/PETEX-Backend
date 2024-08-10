package com.petshow.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin-Shows-Tab")
public class AdminshowEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String eventname;
	private String location;
	private int price;
	private LocalDate date;

	@JsonFormat(pattern = "H:mm")
	private LocalTime time;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "adminId")
	@JsonIgnore
	private AdminSingUpEntity adminshow;


	public AdminSingUpEntity getAdminshow() {
		return adminshow;
	}


	public void setAdminshow(AdminSingUpEntity adminshow) {
		this.adminshow = adminshow;
	}


//	@Lob
//	@Column(columnDefinition = "MEDIUMBLOB")
//	private String file;
	



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEventname() {
		return eventname;
	}


	public void setEventname(String eventname) {
		this.eventname = eventname;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public AdminshowEntity(Integer id, String eventname, String location, int price, LocalDate date, LocalTime time,
			byte[] image) {
		super();
		this.id = id;
		this.eventname = eventname;
		this.location = location;
		this.price = price;
		this.date = date;
		this.time = time;
		this.image = image;
	}


	public AdminshowEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}