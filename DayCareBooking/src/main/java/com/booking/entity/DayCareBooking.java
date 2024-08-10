package com.booking.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class DayCareBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	private String petName;
	private String formDate;
	private String toDate;
	private String address;
	private String city;
	private String state;
	 @Nonnull
	 private Long dayCareId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "vendorId")
	private VendorEntity vendor;

	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "daycareoldId")
	private DayCareEntity daycare;
	
	

	public DayCareBooking() {
		super();
	}


	public DayCareBooking(Long bookId, String petName, String formDate, String toDate, String address, String city,
			String state, Long dayCareId, UserEntity user, VendorEntity vendor, DayCareEntity daycare) {
		super();
		this.bookId = bookId;
		this.petName = petName;
		this.formDate = formDate;
		this.toDate = toDate;
		this.address = address;
		this.city = city;
		this.state = state;
		this.dayCareId = dayCareId;
		this.user = user;
		this.vendor = vendor;
		this.daycare = daycare;
	}





	public Long getDayCareId() {
		return dayCareId;
	}


	public void setDayCareId(Long dayCareId) {
		this.dayCareId = dayCareId;
	}


	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getFormDate() {
		return formDate;
	}

	public void setFormDate(String formDate) {
		this.formDate = formDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public DayCareEntity getDaycare() {
		return daycare;
	}

	public void setDaycare(DayCareEntity daycare) {
		this.daycare = daycare;
	}

	public VendorEntity getVendor() {
		return vendor;
	}

	public void setVendor(VendorEntity vendor) {
		this.vendor = vendor;
	}
	
	
}
