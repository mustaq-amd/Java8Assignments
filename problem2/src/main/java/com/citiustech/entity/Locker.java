package com.citiustech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lockerId;
	private String lockerTYpe;
	private double rent;

	public Locker() {

	}

	public Locker(Integer lockerId, String lockerTYpe, double rent) {
		super();
		this.lockerId = lockerId;
		this.lockerTYpe = lockerTYpe;
		this.rent = rent;
	}

	public Integer getLockerId() {
		return lockerId;
	}

	public void setLockerId(Integer lockerId) {
		this.lockerId = lockerId;
	}

	public String getLockerTYpe() {
		return lockerTYpe;
	}

	public void setLockerTYpe(String lockerTYpe) {
		this.lockerTYpe = lockerTYpe;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", lockerTYpe=" + lockerTYpe + ", rent=" + rent + "]";
	}

}
