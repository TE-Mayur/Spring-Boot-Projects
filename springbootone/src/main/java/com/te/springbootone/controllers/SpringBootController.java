package com.te.springbootone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}
	
	
}
