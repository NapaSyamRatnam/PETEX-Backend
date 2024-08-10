package com.petex.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// PetexFunding-2

@Entity
@Table(name = "Funding_TABLE")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long ownerId;
    
    private String petOwnerName;
    private String email;
    private String mobileNumber;
    private String petName;
    private String petType;
    private String petBreed;
    private int petAge;
   
    private double petExpensesPerMonth;
    private String reasonForFunding;
    private double donationAmount;
    
    @Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	
	public ReportEntity() {
		super();
	}
	public ReportEntity(Long ownerId, String petOwnerName, String email, String mobileNumber, String petName, String petType,
			String petBreed, int petAge, byte[] image, double petExpensesPerMonth, String reasonForFunding,
			double donationAmount) {
		super();
		this.ownerId = ownerId;
		this.petOwnerName = petOwnerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.petName = petName;
		this.petType = petType;
		this.petBreed = petBreed;
		this.petAge = petAge;
		this.image = image;
		this.petExpensesPerMonth = petExpensesPerMonth;
		this.reasonForFunding = reasonForFunding;
		this.donationAmount = donationAmount;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long id) {
		this.ownerId = id;
	}
	public String getPetOwnerName() {
		return petOwnerName;
	}
	public void setPetOwnerName(String petOwnerName) {
		this.petOwnerName = petOwnerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public String getPetBreed() {
		return petBreed;
	}
	public void setPetBreed(String petBreed) {
		this.petBreed = petBreed;
	}
	public int getPetAge() {
		return petAge;
	}
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	
	public double getPetExpensesPerMonth() {
		return petExpensesPerMonth;
	}
	public void setPetExpensesPerMonth(double petExpensesPerMonth) {
		this.petExpensesPerMonth = petExpensesPerMonth;
	}
	public String getReasonForFunding() {
		return reasonForFunding;
	}
	public void setReasonForFunding(String reasonForFunding) {
		this.reasonForFunding = reasonForFunding;
	}
	public double getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}
	
	

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	

}