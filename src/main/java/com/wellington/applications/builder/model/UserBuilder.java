package com.wellington.applications.builder.model;

import com.wellington.applications.dto.UserDTO;
import com.wellington.applications.entity.User;

public class UserBuilder {
	
	private Long userId;
	private String fullname;
	private String username;
	private String email;
	private String password;
	
	public static UserBuilder create() {
		return new UserBuilder();
	}
	
	public UserBuilder userId(Long userId) {
		this.userId = userId;
		return this;
	}
	
	public UserBuilder fullname(String fullname) {
		this.fullname = fullname;
		return this;
	}
	
	public UserBuilder username(String username) {
		this.username = username;
		return this;		
	}
	
	public UserBuilder userDTO(UserDTO userDTO) {
		this.userId(userDTO.getUserId());
		this.fullname = userDTO.getFullname();
		this.password = userDTO.getPassword();
		this.userId = userDTO.getUserId();
		this.email = userDTO.getEmail();
		this.username = userDTO.getUsername();
		return this;		
	}
	
	public UserBuilder email(String email) {
		this.email = email;
		return this;		
	}
	
	public UserBuilder password(String password) {
		this.password = password;
		return this;		
	}
	
	public User build() {
		User user = new User();
		user.setUserId(userId);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		return user;
	} 

}
