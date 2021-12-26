package com.te.springdemo.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Entity
@Table(name = "userinfo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBean implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column
	@NotNull(message = "Please enter a proper id")
	private Integer id;

	@Column
	@NotEmpty(message = "Please Enter the correct name")
	@NotNull(message = "This field can not be empty")
	private String name;

	@Column
	@NotEmpty(message = "Please Enter the correct email")
	@NotNull(message = "This field can not be empty")
	private String email;

	@Column
	@NotNull(message = "This field can not be empty")
	private Long mobile;

	@Column
	@NotNull(message = "This field can not be empty")
	@DateTimeFormat(iso = ISO.DATE)
	private Date dob;
}
