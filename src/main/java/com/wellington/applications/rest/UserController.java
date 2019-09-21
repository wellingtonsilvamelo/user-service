package com.wellington.applications.rest;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellington.applications.builder.dto.UserDTOBuilder;
import com.wellington.applications.builder.model.UserBuilder;
import com.wellington.applications.dto.UserDTO;
import com.wellington.applications.entity.User;
import com.wellington.applications.exception.ApiException;
import com.wellington.applications.response.Response;
import com.wellington.applications.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private MessageSource message;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<Response<List<UserDTO>>> getAll() {
		Response<List<UserDTO>> response = new Response<>();

		List<User> users = userService.findAll();
		
		List<UserDTO> userDTOList = users.stream()
				.map(u -> {
					return UserDTOBuilder.create().user(u).build();
				}).collect(Collectors.toList());

		response.setData(userDTOList);
		response.setCode(HttpStatus.OK.value());
		response.setStatus(HttpStatus.OK.getReasonPhrase());

		return ResponseEntity.ok(response);

	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<UserDTO>> getUser(@PathVariable("id") Long userId) {
		Response<UserDTO> response = new Response<>();
		
		Optional<User> user = userService.findById(userId);
		
		if(!user.isPresent()) {
			throw new ApiException(message.getMessage("user.not-found", null, Locale.getDefault()));
		}
		
		UserDTO userDTO = UserDTOBuilder.create().user(user.get()).build();

		response.setData(userDTO);
		response.setCode(HttpStatus.OK.value());
		response.setStatus(HttpStatus.OK.getReasonPhrase());

		return ResponseEntity.ok(response);

	}
	
	@PatchMapping
	public ResponseEntity<Response<UserDTO>> updateEmail(@RequestBody UserDTO userDTO) {
		Response<UserDTO> response = new Response<>();

		User user = UserBuilder.create()
				.userDTO(userDTO).build();
		
		userDTO = UserDTOBuilder.create().user(userService.update(user)).build();

		response.setData(userDTO);
		response.setCode(HttpStatus.OK.value());
		response.setStatus(HttpStatus.OK.getReasonPhrase());

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/save")
	public ResponseEntity<Response<String>> save(@RequestBody UserDTO userDTO) {
		Response<String> response = new Response<>();

		User user = UserBuilder.create().userDTO(userDTO).build();

		response.setData(userService.save(user));
		response.setCode(HttpStatus.OK.value());
		response.setStatus(HttpStatus.OK.getReasonPhrase());

		return ResponseEntity.ok(response);

	}
}
