package com.luis.curso.springboot.webapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.luis.curso.springboot.webapp.models.User;

@Controller
public class UserController {

	@GetMapping("/details")
	public String details(Model model) {
		User user = new User("Luis", "Reynoso");
		user.setEmail("luis@gmail");
		model.addAttribute("title", "Hola Mundo Springboot");
		model.addAttribute("user", user);
		return "details";
	}

	@GetMapping("/list")
	public String list(ModelMap model) {
		List<User> users = Arrays.asList(new User("Luis", "Reynoso"), new User("Mario", "Luna","mario@gmail"),
				new User("Diana", "Castro","diana@gmail"));

		model.addAttribute("title", "Listado de usuarios");
		model.addAttribute("users", users);

		return "list";
	}
}
