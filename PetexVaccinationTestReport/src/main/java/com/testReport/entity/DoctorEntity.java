package com.testReport.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Doctors_Table")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long doctId;
	private String doctorName;
	private String qualificationAndSpecialization;
	private String overAllExperience;
	private long mobileNumber;
	private String email;
	private String pwd;
	private String confirmPassword;
	private String registrationBody;
	private String medicalBoard;
	private String discription;
	private String clinicName;
	private String otp;
	
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
	private List<TestReport> testReport;
	
	public long getDoctId() {
		return doctId;
	}
	public void setDoctId(long doctId) {
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
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
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
	public void setPassword(String password) {
		this.pwd = password;
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



}
