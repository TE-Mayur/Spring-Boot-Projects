package com.te.springdemo.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoResponce implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean error;
	
	private Object data;
	
}
