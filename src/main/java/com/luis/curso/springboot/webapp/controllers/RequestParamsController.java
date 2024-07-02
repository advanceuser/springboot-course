package com.luis.curso.springboot.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luis.curso.springboot.webapp.models.dto.ParamDTO;
import com.luis.curso.springboot.webapp.models.dto.ParamMixDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

	private static final Logger log = LoggerFactory.getLogger(RequestParamsController.class);

	@GetMapping("/foo")
	public ParamDTO foo(@RequestParam(required = false, defaultValue = "Hola [Default Response]") String message) {
		log.info("Pametro recibido {}", message);
		ParamDTO param = new ParamDTO();
		// Optional Error Handler
		// param.setMessage(message != null ? message : "Hola [Default Response]");
		param.setMessage(message);
		return param;
	}

	@GetMapping("/bar")
	public ParamMixDTO bar(@RequestParam String text, @RequestParam Integer code) {
		log.info("Paramtros recibidos: text: {} - code: {}", text, code);
		ParamMixDTO params = new ParamMixDTO();
		params.setMessage(text);
		params.setCode(code);
		return params;
	}

	@GetMapping("/request")
	public ParamMixDTO request(HttpServletRequest request) {
		log.info("Parametros recibidos: Code {} - Message: {}", request.getParameter("code"),
				request.getParameter("message"));
		Integer code=10;
		try {
			code=Integer.parseInt(request.getParameter("code"));
		} catch (NumberFormatException e) {

		}
		ParamMixDTO params = new ParamMixDTO();
		params.setCode(code);
		params.setMessage(request.getParameter("message"));
		return params;
	}
}
