package com.te.resumebuilder.beans;

import java.io.Serializable;
import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Table(name = "education_details")
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EducationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "email_id")
	@NotEmpty(message = "Email Id cannot be empty")
	@NotNull(message = "This filled cannot be null")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;

	@Column(name = "serial_no")
	@NotNull(message = "This Column cannot be null")
	@Min(value = 0l, message = "Minimum 0")
	private Integer serialNo;

	@Id
	@Column
	@NotEmpty(message = "Institute cannot be empty")
	@NotNull(message = "This Column cannot be null")
	private String institute;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "date_of_joining")
	@NotNull(message = "This Column cannot be null")
	private Date doj;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "date_of_completions")
	@NotNull(message = "This Column cannot be null")
	private Date doc;

	@Column
	@NotEmpty(message = "Qualification cannot be empty")
	@NotNull(message = "This Column cannot be null")
	private String qualification;

	@Column
	@NotEmpty(message = "Description cannot be empty")
	@NotNull(message = "This Column cannot be null")
	private String description;

	@Exclude
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "serial_no", insertable = false, updatable = false)
	private UserInfo perInfo;
}
