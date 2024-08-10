package com.petex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comments_TAB")
public class CommentsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnore
	private UserEntity user;
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getmessage() {
		return message;
	}
	public void setBody(String message) {
		this.message = message;
	}
	public CommentsEntity(Long id, String body) {
		super();
		this.id = id;
		this.message = message;
	}
	public CommentsEntity() {
		super();
	}
	@Override
	public String toString() {
		return "CommentsEntity [id=" + id + ", message=" + message + "]";
	}
	
	}
