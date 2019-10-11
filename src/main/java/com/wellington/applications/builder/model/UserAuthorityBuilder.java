package com.wellington.applications.builder.model;

import com.wellington.applications.entity.Authority;
import com.wellington.applications.entity.User;
import com.wellington.applications.entity.UserAuthority;

public class UserAuthorityBuilder {
	
	private Long userAuthId;
	private User user;
	private Authority authority;
	
	public static UserAuthorityBuilder create() {
		return new UserAuthorityBuilder();
	}
	
	public UserAuthorityBuilder userAuthId(Long userAuthId) {
		this.userAuthId = userAuthId;
		return this;
	}
	
	public UserAuthorityBuilder userId(Long userId) {
		this.user = new User();
		this.user.setUserId(userId);
		return this;
	}
	
	public UserAuthorityBuilder authorityId(Long authorityId) {
		this.authority = new Authority();
		this.authority.setAuthorityId(authorityId);
		return this;
	}
	
	public UserAuthorityBuilder user(User user) {
		this.user = user;
		return this;
	}
	
	public UserAuthorityBuilder authority(Authority authority) {
		this.authority = authority;
		return this;		
	}
		
	public UserAuthority build() {
		UserAuthority userAuthority = new UserAuthority();
		userAuthority.setUser(user);
		userAuthority.setAuthority(authority);
		userAuthority.setId(userAuthId);
		return userAuthority;
	} 

}
