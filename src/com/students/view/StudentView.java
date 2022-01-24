package com.students.view;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import com.students.model.Student;

/**
 * <h1>Student, View!</h1> The StudentView program implements an application
 * that simply displays "User input".
 */

public class StudentView {

	/**
	 * {@code Scanner} that returns values scanned the specified source.
	 */
	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Getting a roll number from the student and it validate the inputs.
	 * 
	 * @return int, roll number is given in the format of digit.
	 * @throws InputMismatchException
	 */
	public int getRollNo() throws InputMismatchException {
		System.out.println("Enter rollNo:");
		String rollNo = SCANNER.next();

		int rollNumber = StudentValidation.getRollNumberValidation(rollNo);
		return rollNumber;
	}

	/**
	 * Getting a name from the student and it validate the inputs.
	 * 
	 * @return String
	 */
	public String getName() {
		System.out.println("Enter new name:");
		String name = SCANNER.next();

		StudentValidation.getNamevalidation(name);
		return name;
	}

	/**
	 * Getting the phone number from the student and validate the input.
	 * 
	 * @return long
	 */
	public long getPhoneNumber() {
		System.out.println("Enter phonenumber:");
		String phoneNumber = SCANNER.next();

		long phoneNo = StudentValidation.getPhoneNumbervalidation(phoneNumber);
		return phoneNo;
	}

	/**
	 * Get a branch and validate it according to user input.
	 * 
	 * @return String
	 */
	public String getBranch() {
		System.out.println("Enter Branch:");
		String branch = SCANNER.next();

		StudentValidation.getBranchValidation(branch);
		return branch;
	}

	/**
	 * Get date of birth from the student and validate it based on input.
	 * 
	 * @return Date
	 * @throws ParseException
	 */
	public Date getAdmissionDate() throws ParseException {
		System.out.println("Enter day/month/year");
		String date = SCANNER.next();

		Date admissionDate = StudentValidation.getAdmissionDateValidation(date);
		return admissionDate;
	}

	/**
	 * It iterates one by one to show all Students details from the list.
	 * 
	 * @param map
	 */
	public void showAllStudents(Map<Integer, Student> map) {
		
		for (Entry<Integer, Student> entry : map.entrySet()) {
			Student value = entry.getValue();
			System.out.println(value);
		}
	}

	/**
	 * It shows the student detail from the list based on unique roll number.
	 * 
	 * @param show
	 */
	public void showStudent(Student show) {
		System.out.println(show);
	}
}
