package com.students.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

import com.students.exception.InvalidStudentDataException;
import com.students.model.Student;
import com.students.service.StudentService;
import com.students.service.StudentServiceImplV2;
import com.students.service.StudentValidation;
import com.students.view.StudentView;

/**
 * Controlled the whole application and managed the student services.
 *
 * @author KowsalyaSP
 */
public class StudentManagement {
	private static final StudentService STUDENT_INFORMATION = new StudentServiceImplV2();
	private static final StudentView VIEW = new StudentView();
	
	public static void addStudent(int rollNo, Student student) throws ParseException, SQLException, InvalidStudentDataException {
		STUDENT_INFORMATION.addStudent(rollNo, student);
	}

	public static void searchStudent(int rollNo) throws SQLException, InvalidStudentDataException {
		VIEW.showStudent(STUDENT_INFORMATION.searchStudent(rollNo));
	}

	public static void removeStudent(int rollNo) throws SQLException, InvalidStudentDataException {
		STUDENT_INFORMATION.removeStudent(rollNo);
	}

	public static void updateStudent(Student student) throws ParseException, SQLException, InvalidStudentDataException {
		STUDENT_INFORMATION.updateStudent(student);		
	}

	public static void updateAll(Student student)throws ParseException, SQLException, InvalidStudentDataException {
		STUDENT_INFORMATION.updateAllStudent(student);	
	}
	
	public static void viewAllStudents() {
		STUDENT_INFORMATION.viewAllStudents();
	}

	public static int getRollNo() {
		return VIEW.getRollNo();
	}
	
	public static int getRollNumber(String rollNo) {
		return StudentValidation.getRollNumberValidation(rollNo);
	}

	public static String getName(String name) {
		return StudentValidation.getNamevalidation(name);	
	}
	
	public static long getPhoneNumber(String phoneNo) {
		return StudentValidation.getPhoneNumbervalidation(phoneNo);
	}
	
	public static String getBranch(String branchName) {
	    return	StudentValidation.getBranchValidation(branchName);
	}

	public static Date getAdmissionDate(String date) {
	    return StudentValidation.getAdmissionDateValidation(date);
    }
}
