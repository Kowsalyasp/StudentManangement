package com.students.view;

import java.util.List;
import java.sql.Date;

import com.students.controller.StudentManagement;
import com.students.exception.InvalidStudentDataException;
import com.students.exception.InvalidStudentDataException.InvalidRollNumberException;
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
		boolean isStudentAdded = StudentManagement.addStudent(student);

		if (isStudentAdded) {
			System.out.println("Successfully Added The Student Data");
		} else {
			throw new InvalidStudentDataException("Already Exist");
		}
	}

	/**
	 * Search the student detail based on roll number.
	 */
	public static void searchStudent() {
		final int rollNo = VIEW.getRollNo();

		try {
			Student student = StudentManagement.searchStudent(rollNo);
			if (student == null) {
				System.out.println("Student Record Is Not Found");				
			} else {
				System.out.println(student);
			}
		} catch (InvalidStudentDataException exception) {
			throw new InvalidRollNumberException("Invalid Roll Number");
		}
	}

	/**
	 * Remove the student detail for the specified roll number.
	 */
	public static void removeStudent() {
		final int rollNo = VIEW.getRollNo();
		boolean isStudentRemoved = StudentManagement.removeStudent(rollNo);

		if (isStudentRemoved) {
			System.out.println("Successfully Deleted The Student Data");
		} else {
			throw new InvalidRollNumberException("Invalid Roll Number");
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
			boolean updateStudent = StudentManagement.updateStudent(student);

			if (updateStudent) {
				System.out.println("Successfully updated the student data");
			} else {
				throw new InvalidRollNumberException("Invalid Roll Number");
			}
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
			boolean updateStudent = StudentManagement.updateStudent(student);

			if (updateStudent) {
				System.out.println("Successfully updated the student data");
			}
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
			boolean updateStudent = StudentManagement.updateStudent(student);

			if (updateStudent) {
				System.out.println("Successfully updated the student data");
			}
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
			boolean updateStudent = StudentManagement.updateStudent(student);

			if (updateStudent) {
				System.out.println("Successfully updated the student data");
			}
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
