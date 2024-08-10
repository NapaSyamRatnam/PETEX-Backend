package com.petshow.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin_Table")
public class AdminSingUpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId;
	private String adminName;
	private String email;
	private String password;
	
//	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
//	private List<PetshowEntity> shows;
	
	@OneToMany(mappedBy = "adminshow",cascade = CascadeType.ALL)
	private List<AdminshowEntity> adminshow;
	
	
	public List<AdminshowEntity> getAdminshow() {
		return adminshow;
	}

	public void setAdminshow(List<AdminshowEntity> adminshow) {
		this.adminshow = adminshow;
	}

//	public List<PetshowEntity> getShows() {
//		return shows;
//	}
//
//	public void setShows(List<PetshowEntity> shows) {
//		this.shows = shows;
//	}

	public AdminSingUpEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminSingUpEntity(Long adminId, String adminName, String email, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.email = email;
		this.password = password;
	}
	
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
	
	