package com.te.resumebuilder.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Table(name = "projects_done")
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectsInfo implements Serializable{

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
	private Integer serialNo;
	
	@Id
	@Column
	@NotEmpty(message = "Title cannot be empty")
	@NotNull(message = "This Column cannot be null")
	private String title;
	
	@Column
	@NotEmpty(message = "Link cannot be empty")
	@NotNull(message = "This Column cannot be null")
	@Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "Provide a proper url")
	private String link;
	
	@Column
	@NotEmpty(message = "Description cannot be empty")
	@NotNull(message = "This Column cannot be null")
	private String description;
	
	@Exclude
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "serial_no", insertable = false,updatable = false)
	private UserInfo perInfo4;
	
}
