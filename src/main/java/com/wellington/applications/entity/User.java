package com.wellington.applications.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbg_user", uniqueConstraints={@UniqueConstraint(columnNames ={"wa_email","wa_username"})})
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="wa_user_id")
	private Long userId;
	
	@Column(name="wa_name", length=100, nullable=false)
	private String fullname;
	
	@Column(name="wa_username", length=50, nullable=false)
	private String username;
	
	@Column(name="wa_email", length=70, nullable=false)
	private String email;
	
	@Column(name="wa_password", length=100, nullable=false)
	private String password;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
