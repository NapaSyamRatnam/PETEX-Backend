package com.Petex.Api.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

// PetexContactUs

@Entity
@Table
public class ContactUsentity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String name;
	private String email;
	private String message;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ContactUsentity(long id, String name, String email, String message) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.message = message;
	}
	public ContactUsentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Contactusentity [Id=" + Id + ", name=" + name + ", email=" + email + ", message=" + message + "]";
	}
}
	