package com.te.springdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.springdemo.beans.DemoBean;
import com.te.springdemo.beans.DemoResponce;
import com.te.springdemo.service.DemoService;

@RestController
@RequestMapping("/data")
public class DemoController {
	
	@Autowired
	private DemoService service;

	@PostMapping("/register")
	public ResponseEntity<DemoResponce> inserData(@Valid @RequestBody DemoBean data){
		DemoResponce responce=new DemoResponce(true,service.storeData(data));
		return new ResponseEntity<DemoResponce>(responce, HttpStatus.OK);
	}
	
}
