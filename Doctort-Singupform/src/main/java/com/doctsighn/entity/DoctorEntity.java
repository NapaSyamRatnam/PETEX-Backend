package com.doctsighn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

// PetexDoctorSignup

@Entity
@Table(name = "Doctors_Table")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long doctId;
	private String doctorName;
	private String qualificationAndSpecialization;
	private String overAllExperience;
	private String mobileNumber;
	private String email;
	private String pwd;
	private String confirmPassword;
	private String registrationBody;
	private String medicalBoard;
	private String discription;
	private String clinicName;
	private String otp;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	
	 private String location;
	 
	 
	 
	public Long getDoctId() {
		return doctId;
	}
	public void setDoctId(Long doctId) {
		this.doctId = doctId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getQualificationAndSpecialization() {
		return qualificationAndSpecialization;
	}
	public void setQualificationAndSpecialization(String qualificationAndSpecialization) {
		this.qualificationAndSpecialization = qualificationAndSpecialization;
	}
	public String getOverAllExperience() {
		return overAllExperience;
	}
	public void setOverAllExperience(String overAllExperience) {
		this.overAllExperience = overAllExperience;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return pwd;
	}
	public void setPassword(String pwd) {
		this.pwd = pwd;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRegistrationBody() {
		return registrationBody;
	}
	public void setRegistrationBody(String registrationBody) {
		this.registrationBody = registrationBody;
	}
	public String getMedicalBoard() {
		return medicalBoard;
	}
	public void setMedicalBoard(String medicalBoard) {
		this.medicalBoard = medicalBoard;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getClinicName() {
		return clinicName;
	}
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }
	public DoctorEntity(Long doctId, String doctorName, String qualificationAndSpecialization, String overAllExperience,
			String mobileNumber, String email, String pwd, String confirmPassword, String registrationBody,
			String medicalBoard, String discription, String clinicName, String otp,byte[] image,String location) {
		super();
		this.doctId = doctId;
		this.doctorName = doctorName;
		this.qualificationAndSpecialization = qualificationAndSpecialization;
		this.overAllExperience = overAllExperience;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.pwd = pwd;
		this.confirmPassword = confirmPassword;
		this.registrationBody = registrationBody;
		this.medicalBoard = medicalBoard;
		this.discription = discription;
		this.clinicName = clinicName;
		this.otp = otp;
		this.image = image;
		this.location = location;
	}
	public DoctorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	

}
