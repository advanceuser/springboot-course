package com.luis.curso.springboot.webapp.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.curso.springboot.webapp.models.User;
import com.luis.curso.springboot.webapp.models.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

	@GetMapping("/detailsDTO")
	public UserDTO detailsDTO() {
		User user = new User("Luis", "Reynoso");
		UserDTO userDTO = new UserDTO();
		userDTO.setUser(user);
		userDTO.setTitle("Hola Mundo Springboot");
		log.info("RESPONSE OK");
		return userDTO;
	}

	@GetMapping("/list")
	public List<User> list() {
		User user1 = new User("Luis", "Reynoso");
		User user2 = new User("Mario", "Luna");
		User user3 = new User("Diana", "Castro");

//		List<User> users = new ArrayList<>();
//		users.add(user1);
//		users.add(user2);
//		users.add(user3);
		List<User> users = Arrays.asList(user1, user2, user3);

		return users;
	}

	@GetMapping("/detailsMap")
	public Map<String, Object> detailsMap() {
		User user = new User("Luis", "Reynoso");
		Map<String, Object> body = new HashMap<>();
		body.put("title", "Hola Mundo Springboot");
		body.put("user", user);
		log.info("RESPONSE OK");
		return body;
	}
}
