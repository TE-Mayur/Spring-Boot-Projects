package com.te.springbootone.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springbootone.beans.EmployeeResponse;
import com.te.springbootone.customexceptions.EmployeeException;

@RestControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<EmployeeResponse> handleExp(EmployeeException exception) {
		EmployeeResponse employeeResponse = 
				new EmployeeResponse(true, exception.getMessage());
		return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.NOT_FOUND);
	}
}









