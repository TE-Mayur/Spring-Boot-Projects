package com.te.springdemo.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "demo")
public class DemoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	@Column
	@NotEmpty(message = "Name Should Not Empty")
	@NotNull(message = "Name Should Not Null")
	private String name;
	
	@Column
	@NotEmpty(message = "Location Should Not Empty")
	@NotNull(message = "Location Should Not Null")
	private String location;

}
