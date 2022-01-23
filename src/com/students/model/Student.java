package com.students.model;

import java.util.Date;

/** Represents an student and specified fields and methods to get and set the student details.
*/
public class Student {	
	 	private int rollno;
	 	private String name;
	 	private long phoneNumber;
	 	private String branch;
	 	private Date dob;
	
	 	/** Creates an student with the specified name.
	 	 * @param rollno The student's roll Number.
	 	 * @param name The student's name.
	 	 * @param phoneNumber The student's phone Number.
	 	 * @param branch The student's branch of a particular branch name.
	 	 * @param dob The Student's date of birth.
	 	*/
	public Student(int rollno, String name, long phoneNumber, String branch, Date dob) {
		this.rollno = rollno;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.branch = branch;
		this.dob = dob;
	}

	public Student() { }

	/** Get the student roll number.
	 * @return integer value for the student roll number.
	*/
	public int getRollno() {
		return rollno;
	}
	
	/** Set the student roll number.
	 * @param roll number An integer containing value for the student roll number.
	*/
	public  void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	/** Get the student name.
	 * @return String value for the student name.
	*/
	public String getName() {
		return name;
	}
	
	/** Set the student name.
	 * @param name A String containing value for the student name.
	*/
	public void setName(String name) {
		this.name = name;
	}

	/** Get the Phone Number.
	 * @return long value for the student Phone Number.
	*/
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	/** Set the student Phone Number.
	 * @param phone Number A long containing value for the student phone number.
	*/
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/** Get the Branch.
	 * @return String value for the student Branch name.
	*/
	public String getBranch() {
		return branch;
	}

	/** Set the student Branch.
	 * @param branch A String containing value for the branch.
	*/
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	/** Get the student DoB.
	 * @return date of birth It returns the date for the student.
	*/
	public Date getDob() {
		return dob;
	}

	/** Set the student Branch.
	 * @param dob A Date containing value for the date of birth.
	*/
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/**{@code StringBuilder} implements {@code Comparable} but does not override
     * {@link Object#equals equals}.
     * construct a string builder initialized to the specifies string.
     * {@code toString} implements the input specified and convert it to string.
	*/
	
	public String toString() {
		return new StringBuilder().append("[ rollno: ").append(rollno).append(" Name: ").append(name).append(" phoneNumber: ").append(phoneNumber)
				 .append(" Branch: ").append(branch).append(" DoB: ").append(dob).append("]").toString();                         
	}
}

