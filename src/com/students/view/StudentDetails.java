package com.students.view;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import com.students.controller.StudentManagement;
import com.students.main.StudentMain;
import com.students.model.Student;

/**
 * <h1>Student Details!</h1> The StudentDetails get the user details from view
 * page and here, it manage the services for the user.
 */
public class StudentDetails {
	private static StudentView view = new StudentView();

	/**
	 * Method to collect the student details and to manage student services.
	 * 
	 * @throws ParseException
	 * @throws InputMismatchException
	 */
	public static void addStudent() throws ParseException, InputMismatchException {
		int rollNo = view.getRollNo();
		String name = view.getName();
		long phoneNumber = view.getPhoneNumber();
		String branch = view.getBranch();
		Date admissionDate = view.getAdmissionDate();
		Student student = new Student(rollNo, name, phoneNumber, branch, admissionDate);

		StudentManagement.addStudent(rollNo, student);
	}

	/**
	 * Method to search the details from the specified student .
	 * 
	 * @return Nothing
	 */
	public static void searchStudent() {
		int rollNo = view.getRollNo();

		StudentManagement.searchStudent(rollNo);
	}

	/**
	 * Method to remove the details from the specified student .
	 * 
	 * @return Nothing
	 */
	public static void removeStudent() {
		int rollNo = view.getRollNo();

		StudentManagement.removeStudent(rollNo);
	}

	/**
	 * Method to update the details for the specified student.
	 * 
	 * @return Nothing
	 */
	public static void updateStudent() throws ParseException {
		System.out.println("Choose What You Want To Update \n1.Student Name \n2.Branch Name \n3.Phone Number\n4.Date of Birth\n");
		int choice = StudentMain.SCANNER.nextInt();

		switch (choice) {
		case 1: {
			StudentDetails.updateStudentName(view.getRollNo(), view.getName());
			break;
		}
		case 2: {
			StudentDetails.updateStudentBranch(view.getRollNo(), view.getBranch());
			break;
		}
		case 3: {
			StudentDetails.updateStudentPhoneNumber(view.getRollNo(), view.getPhoneNumber());
			break;
		}
		case 4: {
			StudentDetails.updateStudentAdmissionDate(view.getRollNo(), view.getAdmissionDate());
			break;
		}

		default: {
			System.out.println("Invalid choice");
			break;
		}
		}
	}

	/**
	 * Update the student name based on key value input
	 * 
	 * @param rollNo The student's roll number
	 * @param name   The student's name
	 * @throws ParseException
	 */
	private static void updateStudentName(int rollNo, String name) throws ParseException {
		Student student = new Student();
		student.setRollno(rollNo);
		student.setName(name);

		StudentManagement.updateStudent(rollNo, student);
	}

	/**
	 * Update the student branch name based on key value input
	 * 
	 * @param rollNo The student's roll number
	 * @param branch The student's branch
	 * @throws ParseException
	 */
	private static void updateStudentBranch(int rollNo, String branch) throws ParseException {
		Student student = new Student();
		student.setRollno(rollNo);
		student.setBranch(branch);

		StudentManagement.updateStudent(rollNo, student);
	}

	/**
	 * Update the student phone number based on key value input.
	 * 
	 * @param rollNo      The student's roll number
	 * @param phoneNumber The student's phone number
	 * @throws ParseException
	 */
	private static void updateStudentPhoneNumber(int rollNo, long phoneNumber) throws ParseException {
		Student student = new Student();
		student.setRollno(rollNo);
		student.setPhoneNumber(phoneNumber);

		StudentManagement.updateStudent(rollNo, student);
	}

	/**
	 * Update the student admission date based on key value input.
	 * 
	 * @param rollNo The student's roll number
	 * @param date   The student's date of birth
	 * @throws ParseException
	 */
	private static void updateStudentAdmissionDate(int rollNo, Date date) throws ParseException {
		Student student = new Student();
		student.setRollno(rollNo);
		student.setAdmissionDate(date);

		StudentManagement.updateStudent(rollNo, student);
	}

	/**
	 * It displays all students from the table.
	 */
	public static void showAllStudents() {
		StudentManagement.showAllStudents();
	}
}
