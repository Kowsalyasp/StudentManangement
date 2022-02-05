package com.students.view;

import java.util.List;
import java.sql.Date;

import com.students.controller.StudentManagement;
import com.students.exception.InvalidStudentDataException;
import com.students.exception.InvalidStudentDataException.InvalidSQLQueryException;
import com.students.main.StudentMain;
import com.students.model.Student;

/**
 * Performs operation such as adding, removing, searching and updating the
 * student details.
 */
public class StudentDetails {
	private static final StudentView VIEW = new StudentView();

	/**
	 * Adding the student details.
	 */

	public static void addStudent() {
		final int rollNo = VIEW.getRollNo();
		final String name = VIEW.getName();
		final long phoneNumber = VIEW.getPhoneNumber();
		final String branch = VIEW.getBranchName();
		final Date admissionDate = VIEW.getAdmissionDate();
		final Student student = new Student(rollNo, name, phoneNumber, branch, admissionDate);
		 
		try {
		    StudentManagement.addStudent(student);
			System.out.println("Successfully Added The Student Data");
		} catch(InvalidSQLQueryException e) {
			System.out.println(e);
		}
	}

	/**
	 * Search the student detail based on roll number.
	 */
	public static void searchStudent() {
		final int rollNo = VIEW.getRollNo();

		try {
			Student student = StudentManagement.searchStudent(rollNo);
			
			System.out.println(student);			
		} catch (InvalidSQLQueryException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Remove the student detail for the specified roll number.
	 */
	public static void removeStudent() {
		final int rollNo = VIEW.getRollNo();
		
		try {
		    StudentManagement.removeStudent(rollNo);
			System.out.println("Successfully Removed");			
		} catch (InvalidSQLQueryException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Updating the student detail.
	 */
	public static void updateStudent() {
		System.out.println("Choose What You Want To Update \n 1. Student Name \n 2. Branch Name \n 3. Phone Number\n 4. Date of Birth\n");
		int choice = StudentMain.SCANNER.nextInt();

		switch (choice) {
		case 1:
			StudentDetails.updateStudentName(VIEW.getRollNo(), VIEW.getName());
			break;
		case 2:
			StudentDetails.updateStudentBranch(VIEW.getRollNo(), VIEW.getBranchName());
			break;
		case 3:
			StudentDetails.updateStudentPhoneNumber(VIEW.getRollNo(), VIEW.getPhoneNumber());
			break;
		case 4:
			StudentDetails.updateStudentAdmissionDate(VIEW.getRollNo(), VIEW.getAdmissionDate());
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
	}

	/**
	 * Update the student name based on roll number.
	 */
	private static void updateStudentName(int rollNo, String name) {
		Student student = new Student();

		student.setRollno(rollNo);
		student.setName(name);

		try {
			StudentManagement.updateStudent(student);
			System.out.println("Successfully updated the student data");
		} catch (InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update the student branch name based on roll number.
	 */
	private static void updateStudentBranch(int rollNo, String branchName) {
		Student student = new Student();

		student.setRollno(rollNo);
		student.setBranch(branchName);

		try {
			StudentManagement.updateStudent(student);
			System.out.println("Successfully updated the student data");
		} catch (InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update the student phone number based on roll number.
	 */
	private static void updateStudentPhoneNumber(int rollNo, long phoneNumber) {
		Student student = new Student();

		student.setRollno(rollNo);
		student.setPhoneNumber(phoneNumber);

		try {
			StudentManagement.updateStudent(student);
			System.out.println("Successfully updated the student data");
		} catch (InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update the student admission date based on roll number.
	 */
	private static void updateStudentAdmissionDate(int rollNo, Date date) {
		Student student = new Student();

		student.setRollno(rollNo);
		student.setAdmissionDate(date);

		try {
			StudentManagement.updateStudent(student);
			System.out.println("Successfully updated the student data");
		} catch (InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * It displays all students from the table.
	 */
	public static void showAllStudents() {

		try {
			List<Student> showStudent = StudentManagement.viewAllStudents();
			
			System.out.println(showStudent);
		} catch (InvalidStudentDataException exception) {
			throw new InvalidStudentDataException("Invalid Data");
		}
	}
}
