package in.saffu.entity;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SALES-TAB")
public class SalesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer petId;
	private String petType;
	private String petname;
	private String gender;
	private String weight;
	private String height;
	private String color;
	private String email;
	private Long phno;
	private String address;

	
@Lob
	@Column(name = "image", columnDefinition = "MEDIUMBLOB")
private byte[] image;
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity users;

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}
	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getPetname() {
		return petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	 public String getImageBase64() {
	        return Base64.getEncoder().encodeToString(this.image);
	    }

}
