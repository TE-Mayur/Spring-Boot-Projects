package com.te.springbootchennai.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springbootchennai.bean.EmployeeResponse;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<EmployeeResponse>  noSuchElement(NoSuchElementException exp){
		EmployeeResponse  res = new EmployeeResponse(true,exp.getMessage() );
		return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
	}
}









