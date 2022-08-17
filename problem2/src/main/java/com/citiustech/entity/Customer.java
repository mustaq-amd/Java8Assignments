package com.citiustech.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	private String cutsomerName;
	private LocalDate dateOfBirth;
	private String Address;
	private String phoneNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lockerId")
	private Locker locker;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCutsomerName() {
		return cutsomerName;
	}

	public void setCutsomerName(String cutsomerName) {
		this.cutsomerName = cutsomerName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate localDate) {
		this.dateOfBirth = localDate;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", cutsomerName=" + cutsomerName + ", dateOfBirth=" + dateOfBirth
				+ ", Address=" + Address + ", phoneNo=" + phoneNo + ", locker=" + locker + "]";
	}
	
	

}
