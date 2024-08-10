package com.petex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADAPTION_TAB")
public class AdoptionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String userName;
	private String emailaddress;
	private String password;
	private Long contactNumber;
	private Integer age;
	private String occuption;
	private String city;
	public AdoptionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getOccuption() {
		return occuption;
	}

	public void setOccuption(String occuption) {
		this.occuption = occuption;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public AdoptionEntity(Long id, String userName, String emailaddress, String password, Long contactNumber,
			Integer age, String occuption, String city) {
		super();
		Id = id;
		this.userName = userName;
		this.emailaddress = emailaddress;
		this.password = password;
		this.contactNumber = contactNumber;
		this.age = age;
		this.occuption = occuption;
		this.city = city;
	}

	@Override
	public String toString() {
		return "PetexAdaptionEntity [Id=" + Id + ", userName=" + userName + ", emailaddress=" + emailaddress
				+ ", password=" + password + ", contactNumber=" + contactNumber + ", age=" + age + ", occuption="
				+ occuption + ", city=" + city + "]";
	}

	

}
