package com.wellington.applications.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBG_USER"/*, uniqueConstraints={@UniqueConstraint(columnNames ={"USER_EMAIL","USERNAME"})}*/)
public class User {
		
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USERNAME", length=50, nullable=false)
	private String username;
	
	@Column(name="USER_FULL_NAME", length=100, nullable=false)
	private String fullname;
	
	@Column(name="USER_EMAIL", length=70, nullable=false)
	private String email;
	
	@JsonIgnore
	@Column(name="USER_HASH_PASSWORD")
	private String password;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
