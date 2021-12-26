package com.te.springdatajpa.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "statusCode", "message", "description" })
public class EmployeeResponse {

	private int statusCode;
	private String message;
	private String description;
	
	@JsonProperty("employeeInfo")
	private EmployeeInfoBean employeeInfoBean;
	private List<EmployeeInfoBean> employeesList;
}
