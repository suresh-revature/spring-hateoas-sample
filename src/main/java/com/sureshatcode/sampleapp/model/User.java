package com.sureshatcode.sampleapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class User extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long userId;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "AGE")
	private Long age;

	public User() {
	}

	@JsonCreator
	public User(@JsonProperty("id") Long userId, @JsonProperty("fullName") String fullName,
			@JsonProperty("emailAddress") String emailAddress, @JsonProperty("age") Long age) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.age = age;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
}
