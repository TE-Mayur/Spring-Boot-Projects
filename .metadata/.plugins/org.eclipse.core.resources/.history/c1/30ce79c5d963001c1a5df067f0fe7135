package com.te.springbootchennai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springbootchennai.beans.EmployeeResponse;
import com.te.springbootchennai.customeexp.EmployeeException;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<EmployeeResponse> handleExp(EmployeeException exception) {
		EmployeeResponse employeeResponse = 
				new EmployeeResponse(true, exception.getMessage());
		return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.NOT_FOUND);
	}
}









