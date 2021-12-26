package com.te.springbootone.customexceptions;

public class EmployeeException extends RuntimeException {

	public EmployeeException(String message) {
		super(message);
	}

}
