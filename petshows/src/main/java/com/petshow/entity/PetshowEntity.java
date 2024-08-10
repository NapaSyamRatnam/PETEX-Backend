package com.petshow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "SHOW-TAB")
public class PetshowEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long petshowid;
	private String  petName;
	private String petBreed;
//	private String companyName;
	private String email;
	private Long   mobile;
//	private String typeofBooking;
	
//	@ManyToOne
//	@JoinColumn(name = "adminId")
//	private AdminSingUpEntity admin;
	
	
//	public AdminSingUpEntity getAdmin() {
//		return admin;
//	}
//	public void setAdmin(AdminSingUpEntity admin) {
//		this.admin = admin;
//	}
	
	@ManyToOne
	@JoinColumn(name="userId")
	@JsonIgnore
	private UserEntity user;
	
	
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
//	public String getCompanyName() {
//		return companyName;
//	}
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
	    this.email = email;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
	    this.mobile = mobile;
	}
	
//	public String getTypeofBooking() {
//		return typeofBooking;
//	}
//	public void setTypeofBooking(String typeofBooking) {
//	    this.typeofBooking = typeofBooking;
//	}
	public Long getPetshowid() {
		return petshowid;
	}
	public void setPetshowid(Long petshowid) {
		this.petshowid = petshowid;
	}

	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
