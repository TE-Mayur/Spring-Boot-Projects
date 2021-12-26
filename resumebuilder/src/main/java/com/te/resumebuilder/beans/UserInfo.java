package com.te.resumebuilder.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@Table(name = "user_tb")
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "serial_no")
	@NotNull(message = "This field cannot be null")
	private Integer serialNo;

	@Column(name = "first_name")
	@Pattern(regexp = "[a-zA-Z]{3,20}", message = "Please enter in correct format")
	@NotEmpty(message = "First Name cannot be empty")
	@NotNull(message = "This filled cannot be null")
	private String firstName;

	@Column(name = "last_name")
	@Pattern(regexp = "[a-zA-Z]{3,20}", message = "Please enter in correct format")
	@NotEmpty(message = "Last Name cannot be empty")
	@NotNull(message = "This filled cannot be null")
	private String lastName;

	@Column(name = "email_id")
	@NotEmpty(message = "Email Id cannot be empty")
	@NotNull(message = "This filled cannot be null")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;

	@Column
	@NotEmpty(message = "Password cannot be empty")
	@NotNull(message = "This filled cannot be null")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})", message = "Please provide the password in proper format ")
	private String password;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "perInfo", fetch = FetchType.LAZY)
	private EducationInfo eduInfo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "perInfo1", fetch = FetchType.LAZY)
	private ExperienceInfo expInfo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "perInfo2", fetch = FetchType.LAZY)
	private ExtraDetails extDetail;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "perInfo3", fetch = FetchType.LAZY)
	private PersonalDetails persDetails;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "perInfo4", fetch = FetchType.LAZY)
	private ProjectsInfo projInfos;

}
