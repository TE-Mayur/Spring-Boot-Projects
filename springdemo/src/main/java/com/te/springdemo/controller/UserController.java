package com.te.springdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.te.springdemo.beans.UserBean;
import com.te.springdemo.beans.UserResponse;
import com.te.springdemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(path ="/account")
	public ResponseEntity<UserResponse> getUserData(@Valid Integer id){
		UserResponse response = new UserResponse(false, service.getUser(id));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/account")
	public ResponseEntity<UserResponse> storeData(@Valid @RequestBody UserBean bean){
		 service.register(bean);
	UserResponse response = new UserResponse(false,"Inserted Successfull");
	return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(path ="/account")
	public ResponseEntity<UserResponse> deleteEntity(@Valid Integer id){
	UserResponse response = new UserResponse(false, service.deleteData(id));
	return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/account")
	public ResponseEntity<UserResponse> update(@Valid @RequestBody UserBean info){
		UserResponse response = new UserResponse(false, service.updateData(info));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
}
