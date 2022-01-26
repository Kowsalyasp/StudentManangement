package com.students.view;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;

import com.students.main.StudentMain;
import com.students.model.Student;

/**
 * The StudentView program implements an application that simply displays "User input".
 */
public class StudentView {

	/**
	 * Getting a roll number from the student and it validate the inputs.
	 */
	public int getRollNo() throws InputMismatchException {
		System.out.println("Enter rollNo:");
		String rollNo = StudentMain.SCANNER.next();
		int rollNumber = StudentValidation.getRollNumberValidation(rollNo);
		
		return rollNumber;
	}

	/**
	 * Getting a name from the student and it validate the inputs.
	 */
	public String getName() {
		System.out.println("Enter name:");
		String name = StudentMain.SCANNER.next();

		StudentValidation.getNamevalidation(name);
		return name;
	}

	/**
	 * Get the phone number from the student and validate the input.
	 */
	public long getPhoneNumber() {
		System.out.println("Enter phonenumber:");
		String phoneNumber = StudentMain.SCANNER.next();
		long phoneNo = StudentValidation.getPhoneNumbervalidation(phoneNumber);
		
		return phoneNo;
	}

	/**
	 * Get a branch and validate it according to user input.
	 */
	public String getBranch() {
		System.out.println("Enter Branch:");
		String branch = StudentMain.SCANNER.next();

		StudentValidation.getBranchValidation(branch);
		return branch;
	}

	/**
	 * Get date of birth from the student and validate it based on input.
	 */
	public Date getAdmissionDate() throws ParseException {
		System.out.println("Enter day/month/year");
		String date = StudentMain.SCANNER.next();
		Date admissionDate = StudentValidation.getAdmissionDateValidation(date);
		
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
