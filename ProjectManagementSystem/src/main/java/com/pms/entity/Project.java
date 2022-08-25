package com.pms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;

	@NotBlank
	private String title;
	
	@NotNull
	private Double budget;
	
	@NotNull
	private Integer teamSize;
	
	@NotNull
	private Integer duration;
	
	@NotNull
	private Date endDate;
	
	@NotBlank
	private String managerName;

}
