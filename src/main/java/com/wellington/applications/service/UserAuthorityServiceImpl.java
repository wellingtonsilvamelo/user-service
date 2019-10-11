package com.wellington.applications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellington.applications.repository.UserAuthorityRepository;

@Service
@Transactional(rollbackFor=Exception.class)
public class UserAuthorityServiceImpl  {
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepository;

}