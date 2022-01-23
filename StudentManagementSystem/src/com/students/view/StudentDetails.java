package com.students.view;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import com.students.controller.StudentManagement;
import com.students.main.StudentMain;
import com.students.model.Student;

/**
* <h1>Student Details!</h1>
* The StudentDetails get the user details from view page and here,
* it manage the services for the user.
*/
public class StudentDetails {          
	private static StudentView view = new StudentView();
	
	/**
	 * This method collect the student details and to manage student services.
	 * @throws ParseException
	 * @throws InputMismatchException
	 */
	public static void addStudentDetails() throws ParseException, InputMismatchException { 
		int rollNo = view.getRollNo();
		String name = view.getName();
		long phoneNumber = view.getPhoneNumber();
		String branch = view.getBranch();
		Date dob = view.getDoB();
		Student student = new Student(rollNo, name, phoneNumber, branch, dob);

		StudentManagement.addStudent(rollNo, student);
	}

	/**
	 * This method search the details from the specified student .
	 * @return Nothing
	 */
	public static void searchStudentDetail() {
	    int rollNo = view.getRollNo();

		StudentManagement.searchStudent(rollNo);
	}

	/**
	 * This method remove the details from the specified student .
	 * @return Nothing
	 */
	public static void removeStudentDetail() {
		int rollNo = view.getRollNo();

		StudentManagement.removeStudent(rollNo);
	}

	/**
	 * This method update the details for the specified student .
	 * @return Nothing
	 */
	public static void updateStudentDetail() throws ParseException {
		System.out.println("Choose What You Want To Update \n1.Student Name \n2.Branch Name \n3.Phone Number\n4.Date of Birth\n");
		int choice = StudentMain.SCANNER.nextInt();
		
		switch (choice) {
			case 1: {
				StudentDetails.updateStudentName(view.getRollNo(),view.getName());
				break;
			}
			case 2: {
				StudentDetails.updateStudentBranch(view.getRollNo(),view.getBranch());
				break;
			} 
			case 3: {
				StudentDetails.updateStudentPhoneNumber(view.getRollNo(),view.getPhoneNumber());
				break;
		    } 
			case 4: {
				StudentDetails.updateStudentDoB(view.getRollNo(),view.getDoB());
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
	 * @param rollNo The student's roll number
	 * @param name The student's name
	 * @throws ParseException
	 */
	private static void updateStudentName(int rollNo, String name) throws ParseException {
		Student student = new Student();		
		student.setRollno(rollNo);
		student.setName(name);
		
		StudentManagement.updateStudent(rollNo, student);
	}

	/**
	 * update the student branch name based on key value input
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
	 * update the student phone number based on key value input.
	 * @param rollNo The student's roll number
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
	 * update the student date of birth based on key value input.
	 * @param rollNo The student's roll number
	 * @param date The student's date of birth
	 * @throws ParseException
	 */
	private static void updateStudentDoB(int rollNo, Date date) throws ParseException {
		Student student = new Student();	
		student.setRollno(rollNo);
		student.setDob(date);
		
		StudentManagement.updateStudent(rollNo, student);
	}
	
	/**
	 * It displays all students from the table.
	 */
	public static void showAllStudents() {
		StudentManagement.showAllStudents();
	}

}
