package com.luis.curso.springboot.webapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.curso.springboot.webapp.models.User;
import com.luis.curso.springboot.webapp.models.dto.ParamDTO;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

	private static final Logger log = LoggerFactory.getLogger(PathVariableController.class);

	@Value("${config.username}")
	private String username;

//	@Value("${config.message}")
//	private String message;

//	@Value("${config.listOfValues}")
//	private String[] listOfValues;

// Cambiando Arreglo a Lista
	@Value("${config.listOfValues}")
	private List<String> listOfValues;

	@Value("#{'${config.listOfValues}'.split(',')}")
	private List<String> valueList;

	@Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
	private List<String> valueListUpper;

	@Value("#{'${config.listOfValues}'}")
	private String valueString;

	@Value("#{'${config.listOfValues}'.toUpperCase()}")
	private String valueStringUpper;

	@Value("#{${config.valuesMap}}")
	private Map<String, Object> valuesMap;

	@Value("#{${config.valuesMap}.product}")
	private String product;

	@Value("#{${config.valuesMap}.price}")
	private Long price;

	@Autowired
	private Environment environment;

	@GetMapping("/baz/{message}")
	public ParamDTO baz(@PathVariable String message) {
		log.info("Parametro recibido: {}", message);
		ParamDTO param = new ParamDTO();
		param.setMessage(message);
		return param;
	}

	@GetMapping("/mix/{product}/{id}")
	public Map<String, Object> mixPathVariable(@PathVariable String product, @PathVariable Long id) {
		log.info("Parametros recibidos: Product: {} Id: {}", product, id);
		Map<String, Object> json = new HashMap<>();
		json.put("product", product);
		json.put("id", id);
		return json;
	}

	@PostMapping("/create")
	public User create(@RequestBody User user) {
		log.info("Peticion recibida: {}", user);
		return user;
	}

	@GetMapping("/values")
	public Map<String, Object> values(@Value("${config.message}") String message) {
		Map<String, Object> json = new HashMap<>();
		json.put("username", username);
		json.put("message", message);
		json.put("message2", environment.getProperty("config.message"));
		json.put("listOfValues", listOfValues);
		json.put("valueList", valueList);
		json.put("valueString", valueString);
		json.put("valueStringUpper", valueStringUpper);
		json.put("valueListUpper", valueListUpper);
		json.put("valuesMap", valuesMap);
		json.put("product", product);
		json.put("price", price);
		return json;
	}
}
