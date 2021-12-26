package com.te.springdemo.exception;

public class InsertionFailed extends RuntimeException{

	public InsertionFailed(String msg) {
		super(msg);
	}
	
}
