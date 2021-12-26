package com.te.springdatajpa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.springdatajpa.beans.EmployeeInfoBean;
import com.te.springdatajpa.beans.EmployeeResponse;
import com.te.springdatajpa.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getEmployee(int empId) {

//		EmployeeInfoBean infoBean = repository.findById(empId).get();
		Optional<EmployeeInfoBean> op = repository.findById(empId);
		EmployeeResponse response = new EmployeeResponse();
		if (op.isPresent()) {
			response.setStatusCode(202);
			response.setMessage("success");
			response.setDescription("Employee Details found For " + empId);
			response.setEmployeeInfoBean(op.get());
		} else {
			response.setStatusCode(403);
			response.setMessage("Failed");
			response.setDescription("Employee Details found For ID " + empId + " Not Found");
		}
		return response;
	}// end of getEmployee()

	@PostMapping(path = "/login", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse authenticate(int empId, String password) {
		EmployeeInfoBean op = repository.authenticate(empId, password);
		EmployeeResponse response = new EmployeeResponse();
		if (op != null) {
			response.setStatusCode(202);
			response.setMessage("success");
			response.setDescription("Login Successfull " + empId);
			response.setEmployeeInfoBean(op);
		} else {
			response.setStatusCode(403);
			response.setMessage("Failed");
			response.setDescription("you have entered wrong credentials");
		}
		return response;

	}
}
