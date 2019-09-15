package com.wellington.applications.builder.dto;

import com.wellington.applications.dto.UserDTO;
import com.wellington.applications.entity.User;

public class UserDTOBuilder {
	
	private Long userId;
	private String fullname;
	private String username;
	private String email;
	private String password;
	
	public static UserDTOBuilder create() {
		return new UserDTOBuilder();
	}
	
	public UserDTOBuilder userId(Long userId) {
		this.userId = userId;
		return this;
	}
	
	public UserDTOBuilder fullname(String fullname) {
		this.fullname = fullname;
		return this;
	}
	
	public UserDTOBuilder username(String username) {
		this.username = username;
		return this;		
	}
	
	public UserDTOBuilder email(String email) {
		this.email = email;
		return this;		
	}
	
	public UserDTOBuilder user(User user) {
		this.fullname = user.getFullname();
		this.password = user.getPassword();
		this.userId = user.getUserId();
		this.email = user.getEmail();
		this.username = user.getUsername();
		return this;		
	}
	
	public UserDTO build() {
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setFullname(fullname);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword("********");
		return user;
	} 

}
