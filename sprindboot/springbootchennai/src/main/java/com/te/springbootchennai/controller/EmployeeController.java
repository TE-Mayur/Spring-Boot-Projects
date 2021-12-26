package com.te.springbootchennai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootchennai.beans.EmployeeInfo;
import com.te.springbootchennai.beans.EmployeeResponse;
import com.te.springbootchennai.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/user", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeResponse> getUserData(Integer id) {
		EmployeeResponse response = new EmployeeResponse(false, service.getEmployee(id));
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/user", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeResponse> storeUserData(@RequestBody EmployeeInfo info) {
		EmployeeResponse response = new EmployeeResponse(false, service.register(info));
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping(path = "/user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeResponse> deleteUserData(@PathVariable Integer id) {
		service.delete(id);
		EmployeeResponse response = new EmployeeResponse(false, "Deleted Successfully");
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	}

	@PutMapping(path = "/user", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeResponse> updateUserData(@RequestBody EmployeeInfo info) {
		service.update(info);
		EmployeeResponse response = new EmployeeResponse(false, service.getEmployee(info.getId()));
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/user/all", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EmployeeResponse> getAllEmployee() {
		EmployeeResponse response = new EmployeeResponse(false, service.getAllData());
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	}

}
