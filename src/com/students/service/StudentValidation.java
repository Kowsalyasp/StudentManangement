package com.students.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * <h1>Student, Validation!</h1> The StudentValidation implements an program to
 * validate the user details.
 */
public class StudentValidation {
	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * This method is used to validate the Roll number.
	 * 
	 * @param rollNo one parameter is passed to getRollNumberValidation
	 * @return integer This returns an integer value of parsed roll number
	 */
	public static int getRollNumberValidation(String rollNumber) {
		if (!rollNumber.matches("[0-9]{3}")) {
			System.out.println("check your roll number  is incorrect \n Enter valid rollno:");
			String rollNo = SCANNER.next();
			return StudentValidation.getRollNumberValidation(rollNo);
		}
		return Integer.parseInt(rollNumber);
	}

	/**
	 * This method is used to validate the name.
	 * 
	 * @param name one parameter is passed to getNameValidation
	 * @return String This returns validated name
	 */
	public static String getNamevalidation(String name) {
		if (!name.matches("[A-Z][a-z]*||[A-Za-z\\s]*")) {
			System.out.println("check your name  is incorrect \n Enter valid name:");
			String reName = SCANNER.next();
			return StudentValidation.getNamevalidation(reName);
		}
		return name;
	}

	/**
	 * This method is used to validate the phone Number.
	 * 
	 * @param phoneNumber one parameter is passed to getPhoneNumberValidation
	 * @return long This returns an long value of parsed the phone Number
	 */
	public static long getPhoneNumbervalidation(String phoneNumber) {
		if (!phoneNumber.matches("[6789]{1}[0-9]{9}")) {
			System.out.println("check your mobile Number  is incorrect \n Enter valid phoneNumber:");
			String phoneNo = SCANNER.next();
			return StudentValidation.getPhoneNumbervalidation(phoneNo);
		}
		return Long.parseLong(phoneNumber);
	}

	/**
	 * This method is used to validate the Branch Name.
	 * 
	 * @param branch one parameter is passed to getBranchValidation
	 * @return String This returns validated branch name
	 */
	public static String getBranchValidation(String branch) {
		if (!branch.matches("^[A-Z][a-z]*$")) {
			System.out.println("check your branch  is incorrect \n Enter valid branch name:");
			String validBranch = SCANNER.next();
			return StudentValidation.getBranchValidation(validBranch);
		}
		return branch;
	}

	/**
	 * This method is used to get date of Birth using Date package.
	 * 
	 * @param date one parameter is passed to getDoBValidation
	 * @return Date This returns validated date
	 * @exception ParseException On input error.
	 */
	public static Date getDoBValidation(String date) throws ParseException {
		try {
			LocalDate today = LocalDate.now();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			formatter.setLenient(false);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = dateFormat.format(formatter.parse(date));
			// dates to be compare
			Date inputDate = dateFormat.parse(date.toString());
			Date currentDate = dateFormat.parse(today.toString());

			if (inputDate.compareTo(currentDate) > 0) {
				System.out.println("Preceeds the current date \n Please Enter Valid Date");
				String validDate = SCANNER.next();
				return StudentValidation.getDoBValidation(validDate);
			}
			return inputDate;
		} catch (Exception e) {
			System.out.println("Invalid \n Please Enter Valid Date");
			String validDate = SCANNER.next();
			return StudentValidation.getDoBValidation(validDate);
		}
	}
}