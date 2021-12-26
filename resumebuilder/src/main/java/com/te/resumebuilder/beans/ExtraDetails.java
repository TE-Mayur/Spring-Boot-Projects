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
@Table(name = "extra_details")
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtraDetails implements Serializable {

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
	@Min(value = 0l)
	private Integer serialNo;

	@Id
	@Column
	@NotEmpty(message = "Skill cannot be empty")
	@NotNull(message = "This Column cannot be null")
	private String skill1;

	@Column
	@NotEmpty(message = "Skill cannot be empty")
	@NotNull(message = "This Column cannot be null")
	private String skill2;

	@Column
	@NotEmpty(message = "Skill cannot be empty")
	@NotNull(message = "This Column cannot be null")
	private String skill3;

	@Exclude
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "serial_no", insertable = false,updatable = false)
	private UserInfo perInfo2;

}
