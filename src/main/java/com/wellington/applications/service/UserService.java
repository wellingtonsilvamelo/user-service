package com.wellington.applications.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wellington.applications.entity.User;
import com.wellington.applications.exception.ApiException;
import com.wellington.applications.repository.UserRepository;
import com.wellington.applications.util.Util;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

	@Autowired
	private MessageSource message;
	
	@Autowired
	private UserRepository userRepository;

	public String save(User user) {
		user.setPassword(Util.generateBCrypt(user.getPassword()));
		userRepository.save(user);
		return message.getMessage("user.inserted-successfully", null, Locale.getDefault());
	}
	
	public User update(User user) {
		Optional<User> userAux = findById(user.getUserId());
		
		if(!userAux.isPresent()) {
			throw new ApiException(message.getMessage("user.not-found", null, Locale.getDefault()));
		}
		
		userAux.get().setEmail(user.getEmail());
		
		user = userRepository.save(userAux.get());
		return user;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}
}
