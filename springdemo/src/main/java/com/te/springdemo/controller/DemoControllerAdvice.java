package com.te.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springdemo.beans.DemoResponce;
import com.te.springdemo.exception.InsertionFailed;

@RestControllerAdvice
public class DemoControllerAdvice {

	@ExceptionHandler(InsertionFailed.class)
	public ResponseEntity<DemoResponce> insertFail(InsertionFailed e){
		DemoResponce responce=new DemoResponce(false,e.getMessage());
		return new ResponseEntity<DemoResponce>(responce,HttpStatus.FAILED_DEPENDENCY);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DemoResponce> validFaild(MethodArgumentNotValidException ex) {
		DemoResponce responce=new DemoResponce(false,ex.getMessage());
		return new ResponseEntity<DemoResponce>(responce,HttpStatus.EXPECTATION_FAILED);
	}
}