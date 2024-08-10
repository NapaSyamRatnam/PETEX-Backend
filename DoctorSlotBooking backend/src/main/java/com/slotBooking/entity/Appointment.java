package com.slotBooking.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Doctor_Appointment_Slot")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingDate;
    private String bookingTime;
    private String petName;
    private String petBreed;
    private String userEmail;
    private String userMobileNumber;
    private String typeOfService;
    private String petDescription;
    private String doctId;
    private String userd;
    
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity user;
    
    
    
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	 public String getBookingDate() {
	        return bookingDate;
	    }
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetBreed() {
		return petBreed;
	}
	public void setPetBreed(String petBreed) {
		this.petBreed = petBreed;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getTypeOfService() {
		return typeOfService;
	}
	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}
	public String getPetDescription() {
		return petDescription;
	}
	public void setPetDescription(String petDescription) {
		this.petDescription = petDescription;
	}
	public String getDoctId() {
		return doctId;
	}
	public void setDoctId(String doctId) {
		this.doctId = doctId;
	}
	public String getUserd() {
		return userd;
	}
	public void setUserd(String userd) {
		this.userd = userd;
	}



}
