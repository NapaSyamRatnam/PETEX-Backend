package com.testReport.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TestReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long testid;
	private String customerName;
	private String customerEmail;
	private Long customerPhno;
	private String diagnosis;
	private String reference;
	private String test;
	private String sugesstions;
	private Long userId;
	private Long vacId;


	@ManyToOne
	@JoinColumn(name = "doctId")
	private DoctorEntity doctor;
	

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public TestReport() {
		super();
	}



	

	public TestReport(Long testid, String customerName, String customerEmail, Long customerPhno, String diagnosis,
			String reference, String test, String sugesstions,  Long userId, Long vacId,
			DoctorEntity doctor) {
		super();
		this.testid = testid;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhno = customerPhno;
		this.diagnosis = diagnosis;
		this.reference = reference;
		this.test = test;
		this.sugesstions = sugesstions;
		this.userId = userId;
		this.vacId = vacId;
		this.doctor = doctor;
	}

	public Long getTestid() {
		return testid;
	}

	public void setTestid(Long testid) {
		this.testid = testid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Long getCustomerPhno() {
		return customerPhno;
	}

	public void setCustomerPhno(Long customerPhno) {
		this.customerPhno = customerPhno;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getSugesstions() {
		return sugesstions;
	}

	public void setSugesstions(String sugesstions) {
		this.sugesstions = sugesstions;
	}




	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getVacId() {
		return vacId;
	}

	public void setVacId(Long vacId) {
		this.vacId = vacId;
	}
	

}
