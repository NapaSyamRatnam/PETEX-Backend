package in.petex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// PetexFunding

@Entity
@Table(name = "FundingDonation_Table")
public class FundingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long donorId;

	private String donorName;

	private String email;

	private String mobileNumber;

	private String petName;

	private String reasonForFunding;

	private double donationAmount;
	
	//card , cvv , transID 

	public FundingEntity() {
		super();
	}

	public FundingEntity(Long donorId, String donorName, String email, String mobileNumber, String petName,
			String reasonForFunding, double donationAmount) {
		super();
		this.donorId = donorId;
		this.donorName = donorName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.petName = petName;
		this.reasonForFunding = reasonForFunding;
		this.donationAmount = donationAmount;
	}

	public Long getDonorId() {
		return donorId;
	}

	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
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
	
	
	

}
