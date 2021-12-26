package com.te.springbootchennai.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeInfo implements Serializable {

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "emp_name")
	@NotNull(message = "Name is Null")
	@NotEmpty(message = "Name can not be empty")
	private String name;

	@Column
	private String mail;

	@Column(name = "password")
	private String pwd;

//	@DateTimeFormat(iso = ISO.DATE)
	@Column
	private Date dob;

	@Column
	private Long mobile;

}
