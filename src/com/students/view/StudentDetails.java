package com.students.view;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;

import com.students.controller.StudentManagement;
import com.students.main.StudentMain;
import com.students.model.Student;

/**
 * Performs operation such as adding, removing, searching and updating the student details.
 */
public class StudentDetails {
	private static final StudentView VIEW = new StudentView();

	/**
	 * Adding the student details .
	 */
	public static void addStudent() throws ParseException, InputMismatchException {
		int rollNo = VIEW.getRollNo();
		String name = VIEW.getName();
		long phoneNumber = VIEW.getPhoneNumber();
		String branch = VIEW.getBranch();
		Date admissionDate = VIEW.getAdmissionDate();
		Student student = new Student(rollNo, name, phoneNumber, branch, admissionDate);
		
		StudentManagement.addStudent(rollNo, student);
	}

	/**
	 * Search the student detail based on roll number.
	 */
	public static void searchStudent() {
		int rollNo = VIEW.getRollNo();

		StudentManagement.searchStudent(rollNo);
	}

	/**
	 * Remove the student detail for the specified roll number.
	 */
	public static void removeStudent() {
		int rollNo = VIEW.getRollNo();

		StudentManagement.removeStudent(rollNo);
	}

	/**
	 * Updating the student detail.
	 */
	public static void updateStudent() throws ParseException {
		System.out.println("Choose What You Want To Update \n1.Student Name \n2.Branch Name \n3.Phone Number\n4.Date of Birth\n");
		int choice = StudentMain.SCANNER.nextInt();

		switch (choice) {
		case 1:
			StudentDetails.updateStudentName(VIEW.getRollNo(), VIEW.getName());
			break;			
		case 2: 
			StudentDetails.updateStudentBranch(VIEW.getRollNo(), VIEW.getBranch());
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
	private static void updateStudentName(int rollNo, String name) throws ParseException {
		Student student = new Student();
		student.setRollno(rollNo);
		student.setName(name);

		StudentManagement.updateStudent(student);
	}

	/**
	 * Update the student branch name based on roll number.
	 */
	private static void updateStudentBranch(int rollNo, String branch) throws ParseException {
		Student student = new Student();
		student.setRollno(rollNo);
		student.setBranch(branch);

		StudentManagement.updateStudent(student);
	}

	/**
	 * Update the student phone number based on roll number.
	 */
	private static void updateStudentPhoneNumber(int rollNo, long phoneNumber) throws ParseException {
		Student student = new Student();
		student.setRollno(rollNo);
		student.setPhoneNumber(phoneNumber);

		StudentManagement.updateStudent(student);
	}

	/**
	 * Update the student admission date based on roll number.
	 */
	private static void updateStudentAdmissionDate(int rollNo, Date date) throws ParseException {
		Student student = new Student();
		student.setRollno(rollNo);
		student.setAdmissionDate(date);

		StudentManagement.updateStudent(student);
	}

	/**
	 * It displays all students from the table.
	 */
	public static void showAllStudents() {
		StudentManagement.showAllStudents();
	}
}
