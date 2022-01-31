package com.students.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

import com.students.main.StudentMain;

/**
 * The StudentValidation implements an program to validate the user details.
 */
public class StudentValidation {
	
	/**
	 * Validate the roll number based on given input.
	 */
	public static int getRollNumberValidation(String rollNumber) {

		if (!rollNumber.matches("[0-9]{3}")) {
			System.out.println("check your roll number  is incorrect \n Enter valid rollno:");
			String rollNo = StudentMain.SCANNER.next();
			return StudentValidation.getRollNumberValidation(rollNo);
		}
		return Integer.parseInt(rollNumber);
	}

	/**
	 * Validate the name based on given input.
	 */
	public static String getNamevalidation(String name) {

		if (!name.matches("[A-Z][a-z]*||[A-Za-z\\s]*")) {
			System.out.println("Check your name is incorrect \n Enter valid name:");
			String validName = StudentMain.SCANNER.next();
			return StudentValidation.getNamevalidation(validName);
		}
		return name;
	}

	/**
	 * Validate the phone Number based on input.
	 */
	public static long getPhoneNumbervalidation(String phoneNumber) {

		if (!phoneNumber.matches("[6789]{1}[0-9]{9}")) {
			System.out.println("Check your mobile Number is incorrect \n Enter valid phoneNumber:");
			String phoneNo = StudentMain.SCANNER.next();
			return StudentValidation.getPhoneNumbervalidation(phoneNo);
		}
		return Long.parseLong(phoneNumber);
	}

	/**
	 * Validate the Branch Name based on input.
	 */
	public static String getBranchValidation(String branchName) {

		if (!branchName.matches("^[A-Z][a-z]*$")) {
			System.out.println("Check your branch  is incorrect \n Enter valid branch name:");
			String validBranchName = StudentMain.SCANNER.next();
			return StudentValidation.getBranchValidation(validBranchName);
		}
		return branchName;
	}

	/**
	 * Get and validate the value of admission date by importing Date class.
	 */
	public static Date getAdmissionDateValidation(String date) {

		try {
			LocalDate todayDate = LocalDate.now();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			formatter.setLenient(false);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = dateFormat.format(formatter.parse(date));	
			//dates to be compared
			java.util.Date inputDate = java.sql.Date.valueOf(date);					
			java.util.Date currentDate = dateFormat.parse(todayDate.toString());

			if (inputDate.compareTo(currentDate) > 0) {
				System.out.println("Preceeds the current date \n Please Enter Valid Date");
				String validDate = StudentMain.SCANNER.next();
				
				return StudentValidation.getAdmissionDateValidation(validDate);
			}
			return java.sql.Date.valueOf(inputDate.toString());
		} catch (Exception e) {
			System.out.println("Invalid \n Please Enter Valid Date");
			String validDate = StudentMain.SCANNER.next();
			
			return StudentValidation.getAdmissionDateValidation(validDate);
		}
	}
}