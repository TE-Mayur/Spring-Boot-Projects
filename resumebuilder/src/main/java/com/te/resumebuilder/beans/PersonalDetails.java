package com.te.resumebuilder.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Table(name = "personal_details")
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 386373199102593443L;

	@Column(name = "serial_no")
	@NotNull(message = "This Column cannot be null")
	@Min(value = 0l)
	private Integer serialNo;

	@Id
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

	@Column(name = "phone_no")
	@NotNull(message = "This filled cannot be null")
	@Min(value = 10l, message = " Please provide the proper phone number")
	private Long phoneNo;

	@Column
	@Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "Provide a proper url")
	private String website;

	@Column(name = "git_hub")
	private String gitHub;

	@Column(name = "linked_in")
	private String linkedIn;

	@Column
	private String twitter;

	@Column
	private String instagram;

	@Column
	private String facebook;

	@Exclude
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "serial_no", insertable = false, updatable = false)
	private UserInfo perInfo3;
}
