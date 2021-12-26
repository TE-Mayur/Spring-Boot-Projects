package com.te.springbootchennai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}
	
	
}
