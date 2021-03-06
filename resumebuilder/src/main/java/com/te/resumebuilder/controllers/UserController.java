package com.te.resumebuilder.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumebuilder.beans.EducationInfo;
import com.te.resumebuilder.beans.ExperienceInfo;
import com.te.resumebuilder.beans.ExtraDetails;
import com.te.resumebuilder.beans.PersonalDetails;
import com.te.resumebuilder.beans.ProjectsInfo;
import com.te.resumebuilder.beans.UserInfo;
import com.te.resumebuilder.beans.UserResponse;
import com.te.resumebuilder.services.EducationService;
import com.te.resumebuilder.services.ExperienceService;
import com.te.resumebuilder.services.ExtraService;
import com.te.resumebuilder.services.PersonalService;
import com.te.resumebuilder.services.ProjectService;
import com.te.resumebuilder.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private EducationService educaService;

	@Autowired
	private ExperienceService experService;

	@Autowired
	private ExtraService extraService;

	@Autowired
	private PersonalService personalService;

	@Autowired
	private ProjectService projectService;

	@GetMapping(path = "/get/{serialNo}")
	public ResponseEntity<UserResponse> getData(@PathVariable Integer serialNo) {
		UserResponse response = new UserResponse(false, service.getUser(serialNo));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/signin")
	public ResponseEntity<UserResponse> login(@RequestBody UserInfo login) {
		UserResponse response = new UserResponse(false, service.login(login.getEmail(), login.getPassword()));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/signup")
	public ResponseEntity<UserResponse> storeData(@Valid @RequestBody UserInfo info) {
		UserResponse response = new UserResponse(false, service.signup(info));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/education")
	public ResponseEntity<UserResponse> educationDetails(@Valid @RequestBody EducationInfo edu) {
		UserResponse response = new UserResponse(false, educaService.storeEducation(edu));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/experience")
	public ResponseEntity<UserResponse> experience(@Valid @RequestBody ExperienceInfo exp) {
		UserResponse response = new UserResponse(false, experService.expInfo(exp));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/personaldetails")
	public ResponseEntity<UserResponse> personalDetails(@Valid @RequestBody PersonalDetails details) {
		UserResponse response = new UserResponse(false, personalService.personalDetails(details));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/extradetails")
	public ResponseEntity<UserResponse> extraDetails(@Valid @RequestBody ExtraDetails extraDetails) {
		UserResponse response = new UserResponse(false, extraService.extraDetails(extraDetails));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/project")
	public ResponseEntity<UserResponse> projectDetails(@Valid @RequestBody ProjectsInfo project) {
		UserResponse response = new UserResponse(false, projectService.projectsInfo(project));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
}