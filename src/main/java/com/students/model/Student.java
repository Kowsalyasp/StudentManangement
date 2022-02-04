package com.students.model;

import java.sql.Date;

/**
 * Represents an student and specified fields and methods to get and set the
 * student details.
 */
public class Student {
	private int rollNo;
	private String name;
	private long phoneNumber;
	private String branch;
	private Date admissionDate;

	public Student(int rollNo, String name, long phoneNumber, String branch, Date admissionDate) {
		this.rollNo = rollNo;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.branch = branch;
		this.admissionDate = admissionDate;
	}

	public Student() {
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollno(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String toString() {
		return String.format("%s%10s%20s%10s%30s", Integer.toString(rollNo), name, Long.toString(phoneNumber), branch,
				admissionDate.toString());
	}
}
