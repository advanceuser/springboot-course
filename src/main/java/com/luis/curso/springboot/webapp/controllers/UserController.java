package com.luis.curso.springboot.webapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
		// Otra manera de definir objetos de forma global es definiendo un metodo con la
		// anotacion @ModelAttribute (metodo de abajo)
		//Esta es una anotacion GLOBAL que es accesible para todos las vistas
//		List<User> users = Arrays.asList(new User("Luis", "Reynoso"), new User("Mario", "Luna","mario@gmail"),
//				new User("Diana", "Castro","diana@gmail"));

		// model.addAttribute("users", users);
		model.addAttribute("title", "Listado de usuarios");

		return "list";
	}

	@ModelAttribute("users")
	public List<User> usersModel() {
		return Arrays.asList(new User("Luis", "Reynoso"), new User("Mario", "Luna", "mario@gmail"),
				new User("Diana", "Castro", "diana@gmail"));

	}
}
