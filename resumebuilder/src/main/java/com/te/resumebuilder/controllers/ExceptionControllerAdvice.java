package com.te.resumebuilder.controllers;

import javax.persistence.EntityNotFoundException;

import org.hibernate.resource.beans.container.internal.NoSuchBeanException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.resumebuilder.beans.UserResponse;
import com.te.resumebuilder.customexception.ExceptionHandle;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(ExceptionHandle.class)
	public ResponseEntity<UserResponse> handleExp(ExceptionHandle exception) {
		UserResponse userResponse = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<UserResponse> notValidExcep(MethodArgumentNotValidException exception) {
		UserResponse userResponse = new UserResponse(true,
				exception.getFieldError().getField() + ":" + exception.getFieldError().getDefaultMessage());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(NoSuchBeanException.class)
	public ResponseEntity<UserResponse> validationExcep(NoSuchBeanException exception) {
		UserResponse userResponse = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<UserResponse> entityNotFound(EntityNotFoundException exception) {
		UserResponse userResponse = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<UserResponse> nullPointer(NullPointerException exception) {
		UserResponse userResponse = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<UserResponse> illegalArgument(IllegalArgumentException exception) {
		UserResponse userResponse = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_IMPLEMENTED);
	}

	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<UserResponse> indexOutBond(IndexOutOfBoundsException exception) {
		UserResponse userResponse = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(IllegalAccessException.class)
	public ResponseEntity<UserResponse> illegalAccess(IllegalAccessException exception) {
		UserResponse userResponse = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.NOT_MODIFIED);
	}
}