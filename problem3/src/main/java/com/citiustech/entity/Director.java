package com.citiustech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer directorId;
	private String directorName;
	private Integer bornIn;

	public Director() {

	}

	public Integer getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Integer getBornIn() {
		return bornIn;
	}

	public void setBornIn(Integer bornIn) {
		this.bornIn = bornIn;
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", directorName=" + directorName + ", bornIn=" + bornIn + "]";
	}

}
