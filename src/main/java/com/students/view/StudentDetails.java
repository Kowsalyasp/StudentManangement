package com.students.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import com.students.controller.StudentManagement;
import com.students.exception.InvalidStudentDataException;
import com.students.main.StudentMain;
import com.students.model.Student;

/**
 * Performs operation such as adding, removing, searching and updating the student details.
 */
public class StudentDetails {
	private static final StudentView VIEW = new StudentView();

	/**
	 * Adding the student details.
	 * 
	 * @throws InvalidStudentDataException 
	 */
	
	public static void addStudent() throws ParseException, SQLException, InvalidStudentDataException{
		int rollNo = VIEW.getRollNo();
		String name = VIEW.getName();
		long phoneNumber = VIEW.getPhoneNumber();
		String branch = VIEW.getBranchName();
		Date admissionDate = VIEW.getAdmissionDate();
		Student student = new Student(rollNo, name, phoneNumber, branch, admissionDate);
		
		try {
		    StudentManagement.addStudent(rollNo, student);
		} catch(InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Search the student detail based on roll number.
	 * 
	 * @throws SQLException 
	 * @throws InvalidStudentDataException 
	 */
	public static void searchStudent() throws SQLException, InvalidStudentDataException{
		int rollNo = VIEW.getRollNo();

		try {
		    StudentManagement.searchStudent(rollNo);
		} catch(InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Remove the student detail for the specified roll number.
	 * 
	 * @throws SQLException 
	 * @throws InvalidStudentDataException
	 */
	public static void removeStudent() throws SQLException, InvalidStudentDataException{
		int rollNo = VIEW.getRollNo();

		try {		
		    StudentManagement.removeStudent(rollNo);
		} catch(InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Updating the student detail.
	 * 
	 * @throws SQLException 
	 * @throws ParseException
	 * @throws InvalidStudentDataException
	 */
	public static void updateStudent() throws ParseException, SQLException, InvalidStudentDataException {
		System.out.println("Choose What You Want To Update \n 1. Student Name \n 2. Branch Name \n 3. Phone Number\n 4. Date of Birth\n 5. Update All");
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
		case 5:
			StudentDetails.updateAllStudent(VIEW.getRollNo(), VIEW.getName(),VIEW.getBranchName(), VIEW.getPhoneNumber(), VIEW.getAdmissionDate() );
			break;
		default: 
			System.out.println("Invalid Choice");
			break;
		}
	}
		
	/**
	 * Update the student name based on roll number.
	 * 
	 * @throws SQLException 
	 * @throws InvalidStudentDataException	  
	 */
	private static void updateStudentName(int rollNo, String name) throws ParseException, SQLException, InvalidStudentDataException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setName(name);
		
		try {
		    StudentManagement.updateStudent(student);
		} catch(InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update the student branch name based on roll number. 
	 */
	private static void updateStudentBranch(int rollNo, String branchName) throws ParseException, SQLException, InvalidStudentDataException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setBranch(branchName);
		
		try {
		    StudentManagement.updateStudent(student);
		} catch(InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update the student phone number based on roll number.
	 */
	private static void updateStudentPhoneNumber(int rollNo, long phoneNumber) throws ParseException, SQLException, InvalidStudentDataException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setPhoneNumber(phoneNumber);
		
		try {
		    StudentManagement.updateStudent(student);
		} catch(InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Update the student admission date based on roll number.
	 */
	private static void updateStudentAdmissionDate(int rollNo, Date date) throws ParseException, SQLException, InvalidStudentDataException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setAdmissionDate(date);
		
		try {
		    StudentManagement.updateStudent(student);
		} catch(InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	}

	 private static void updateAllStudent(int rollNo, String name, String branchName, long phoneNumber, Date date ) throws ParseException, SQLException, InvalidStudentDataException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setName(name);
		student.setBranch(branchName);
		student.setPhoneNumber(phoneNumber);
		student.setAdmissionDate(date);		
		
		try {
		    StudentManagement.updateStudent(student);
		} catch(InvalidStudentDataException exception) {
			System.out.println(exception);
		}
	 }
	 
	/**
	 * It displays all students from the table.
	 * 
	 * @throws SQLException 
	 */
	public static void showAllStudents() throws SQLException {
		StudentManagement.viewAllStudents();
	}
}
