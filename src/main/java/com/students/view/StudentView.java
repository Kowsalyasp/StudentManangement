package com.students.view;

import java.sql.Date;
import java.util.Map;
import java.util.Map.Entry;

import com.students.controller.StudentManagement;
import com.students.main.StudentMain;
import com.students.model.Student;

/**
 * The StudentView program implements an application that simply displays "User input".
 */
public class StudentView {

	/**
	 * Getting a roll number from the student and it validate the inputs.
	 */
	public int getRollNo() {
		System.out.println("Enter RollNo:");
		String rollNo = StudentMain.SCANNER.next();
		int rollNumber = StudentManagement.getRollNumber(rollNo);
		
		return rollNumber;
	}

	/**
	 * Getting a name from the student and it validate the inputs.
	 */
	public String getName() {
		System.out.println("Enter Name:");
		String name = StudentMain.SCANNER.next();

		StudentManagement.getName(name);
		return name;
	}

	/**
	 * Get the phone number from the student and validate the input.
	 */
	public long getPhoneNumber() {
		System.out.println("Enter Phonenumber:");
		String phoneNumber = StudentMain.SCANNER.next();
		long phoneNo = StudentManagement.getPhoneNumber(phoneNumber);
		
		return phoneNo;
	}

	/**
	 * Get a branch and validate it according to user input.
	 */
	public String getBranchName() {
		System.out.println("Enter Branch:");
		String branchName = StudentMain.SCANNER.next();

		StudentManagement.getBranch(branchName);
		return branchName;
	}

	/**
	 * Get date of birth from the student and validate it based on input.
	 */
	public Date getAdmissionDate() {
		System.out.println("Enter day/month/year");
		String date = StudentMain.SCANNER.next();
		Date admissionDate = StudentManagement.getAdmissionDate(date);
		
		return admissionDate;
	}

	/**
	 * Iterate one by one to show all Students details from the list.
	 */
	public void showAllStudents(Map<Integer, Student> map) {

		for (Entry<Integer, Student> entry : map.entrySet()) {
			Student value = entry.getValue();
			System.out.println(value);
		}
	}

	/**
	 * Show the student detail from the list based on unique roll number.
	 */
	public void showStudent(Student show) {
		System.out.println(show);
	}	
}
