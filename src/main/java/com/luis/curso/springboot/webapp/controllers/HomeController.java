package com.luis.curso.springboot.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({ "", "/", "/home" })
	public String home() {
		// Forward hace redigige sin perder atributos
		// return "forward:/list";
		// Redirect refresca toda la peticion
		return "redirect:/list";
	}
}
