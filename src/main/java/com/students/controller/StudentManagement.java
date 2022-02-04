package com.students.controller;

import java.sql.Date;
import java.util.List;

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
	
	public static boolean addStudent(Student student) {
		return STUDENT_INFORMATION.addStudent(student);
	}

	public static Student searchStudent(int rollNo) {
		return STUDENT_INFORMATION.searchStudent(rollNo);
	}

	public static boolean removeStudent(int rollNo){
		return STUDENT_INFORMATION.removeStudent(rollNo);
	}

	public static boolean updateStudent(Student student){
		return STUDENT_INFORMATION.updateStudent(student);		
	}
	
	public static List<Student> viewAllStudents() {
		return STUDENT_INFORMATION.viewAllStudents();
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
	    return StudentValidation.getBranchValidation(branchName);
	}

	public static Date getAdmissionDate(String date) {
	    return StudentValidation.getAdmissionDateValidation(date);
    }
}
