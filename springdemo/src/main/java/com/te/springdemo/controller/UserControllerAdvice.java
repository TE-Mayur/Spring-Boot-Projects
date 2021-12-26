package com.te.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springdemo.beans.UserResponse;
import com.te.springdemo.exception.CustomException;

@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<UserResponse> excepCustom(CustomException exception){
		UserResponse response = new UserResponse(false, exception.getMessage());
		return new ResponseEntity<UserResponse>(response, HttpStatus.NOT_FOUND);
}
}
