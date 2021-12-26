package com.te.springdatajpa.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName("employeeInfo")
@JsonPropertyOrder({ "employeeId", "name" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "employee_primary_info")
public class EmployeeInfoBean implements Serializable {
	
	@JsonProperty("employeeId")
	@Id
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column
	private String name;
	
	@Column(name = "mobile")
	private Long mobileNum;
	
	@Column(name = "official_maildid")
	private String maildId;
	
	@Column(name = "date_of_birth")
	// @DateTimeFormat(iso =ISO. DATE)
	private Date birthDate;
	
	@Column(name = "date_of_joining")
	// @DateTimeFormat(iso =ISO. DATE)
	private Date joiningDate;
	
	@Column
	private String designation;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Column
	private Double salary;
	
	@Column(name = "dept_id")
	private Integer deptId;
	
	@Column(name = "mgr_id")
	private Integer mgrId;
	
	@Column
	private String password;

}
