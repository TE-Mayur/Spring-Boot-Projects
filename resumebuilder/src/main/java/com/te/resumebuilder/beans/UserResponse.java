package com.te.resumebuilder.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
	
	//while checking in postman we will get this boolean value in the response
	private Boolean error;
	
	//It will generate the object and we will get the object as output
	private Object data;

}
