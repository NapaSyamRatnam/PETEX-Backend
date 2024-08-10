package com.DayCare.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vendor_TABLE")
public class VendorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vendorId;
    private String establishmentName;
    private String contactperson;
    private String address;
    private Long phno;
    private Long alternativemobilenumber;
    private String email;
    private String pwd;
    private String confirmPwd;
    private String url;
    private String typeofvendor;
    private String featuredListings;
    private String paymentmodes;
    private Long estsince;
    private String socialmedia;
    private String otp;
    
	@OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL)
	private List<DayCareEntity> daycare;
	
	public Long getvendorId() {
		return vendorId;
	}
	public void setvendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public String getEstablishmentName() {
		return establishmentName;
	}
	public void setEstablishmentName(String establishmentName) {
		this.establishmentName = establishmentName;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public Long getAlternativemobilenumber() {
		return alternativemobilenumber;
	}
	public void setAlternativemobilenumber(Long alternativemobilenumber) {
		this.alternativemobilenumber = alternativemobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTypeofvendor() {
		return typeofvendor;
	}
	public void setTypeofvendor(String typeofvendor) {
		this.typeofvendor = typeofvendor;
	}
	public String getFeaturedListings() {
		return featuredListings;
	}
	public void setFeaturedListings(String featuredListings) {
		this.featuredListings = featuredListings;
	}
	public String getPaymentmodes() {
		return paymentmodes;
	}
	public void setPaymentmodes(String paymentmodes) {
		this.paymentmodes = paymentmodes;
	}
	public Long getEstsince() {
		return estsince;
	}
	public void setEstsince(Long estsince) {
		this.estsince = estsince;
	}
	public String getSocialmedia() {
		return socialmedia;
	}
	public void setSocialmedia(String socialmedia) {
		this.socialmedia = socialmedia;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public List<DayCareEntity> getDaycare() {
		return daycare;
	}
	public void setDaycare(List<DayCareEntity> daycare) {
		this.daycare = daycare;
	}

	
	}
    



