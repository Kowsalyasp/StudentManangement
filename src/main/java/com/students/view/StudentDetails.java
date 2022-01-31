package com.students.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import com.students.controller.StudentManagement;
import com.students.dao.InvalidRollNumberException;
import com.students.dao.NoSuchUpdateException;
import com.students.dao.StoreStudentDataException;
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
	 * @throws StoreStudentDataException 
	 */
	
	public static void addStudent() throws ParseException, SQLException, StoreStudentDataException {
		int rollNo = VIEW.getRollNo();
		String name = VIEW.getName();
		long phoneNumber = VIEW.getPhoneNumber();
		String branch = VIEW.getBranchName();
		Date admissionDate = VIEW.getAdmissionDate();
		Student student = new Student(rollNo, name, phoneNumber, branch, admissionDate);
		
		StudentManagement.addStudent(rollNo, student);
	}

	/**
	 * Search the student detail based on roll number.
	 * 
	 * @throws SQLException 
	 * @throws InvalidRollNumberException 
	 */
	public static void searchStudent() throws SQLException, InvalidRollNumberException {
		int rollNo = VIEW.getRollNo();

		StudentManagement.searchStudent(rollNo);
	}

	/**
	 * Remove the student detail for the specified roll number.
	 * 
	 * @throws SQLException 
	 * @throws InvalidRollNumberException
	 */
	public static void removeStudent() throws SQLException, InvalidRollNumberException {
		int rollNo = VIEW.getRollNo();

		StudentManagement.removeStudent(rollNo);
	}

	/**
	 * Updating the student detail.
	 * 
	 * @throws SQLException 
	 * @throws NoUpdateDataException 
	 * @throws InvalidRollNumberException
	 * @throws ParseException
	 */
	public static void updateStudent() throws ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException {
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
	 * @throws NoSuchUpdateException 	  
	 */
	private static void updateStudentName(int rollNo, String name) throws ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setName(name);
		StudentManagement.updateStudent(student);
	}

	/**
	 * Update the student branch name based on roll number. 
	 */
	private static void updateStudentBranch(int rollNo, String branchName) throws ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setBranch(branchName);
		StudentManagement.updateStudent(student);
	}

	/**
	 * Update the student phone number based on roll number.
	 */
	private static void updateStudentPhoneNumber(int rollNo, long phoneNumber) throws ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setPhoneNumber(phoneNumber);
		StudentManagement.updateStudent(student);
	}

	/**
	 * Update the student admission date based on roll number.
	 */
	private static void updateStudentAdmissionDate(int rollNo, Date date) throws ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setAdmissionDate(date);
		StudentManagement.updateStudent(student);
	}

	 private static void updateAllStudent(int rollNo, String name, String branchName, long phoneNumber, Date date ) throws ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException {
		Student student = new Student();
		
		student.setRollno(rollNo);
		student.setName(name);
		student.setBranch(branchName);
		student.setPhoneNumber(phoneNumber);
		student.setAdmissionDate(date);		
		StudentManagement.updateAll(student);
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
