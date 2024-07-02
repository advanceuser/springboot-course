package com.luis.curso.springboot.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Se crea una clase de configuracion ValuesConfig.java
//Multiples Sources
//@PropertySources({
//	@PropertySource("classpath:values.properties"),
//	@PropertySource("classpath:valuesTest.properties")
//})
//@PropertySource("classpath:values.properties")
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}
}
