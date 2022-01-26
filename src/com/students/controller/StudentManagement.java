package com.students.controller;

import java.text.ParseException;

import com.students.model.Student;
import com.students.service.StudentService;
import com.students.service.StudentServiceImplementation;
import com.students.view.StudentView;

/**
 * Controlled the whole application and managed the student services.
 * 
 * @author KowsalyaSP
 */
public class StudentManagement {
	private static final StudentService STUDENT_INFORMATION = new StudentServiceImplementation();
	private static final StudentView VIEW = new StudentView();

	public static void addStudent(int rollNo, Student student) throws ParseException {
		STUDENT_INFORMATION.addStudent(rollNo, student);
	}

	public static void searchStudent(int rollNo) {
		VIEW.showStudent(STUDENT_INFORMATION.searchStudent(rollNo));
	}

	public static void removeStudent(int rollNo) {
		VIEW.showStudent(STUDENT_INFORMATION.removeStudent(rollNo));
	}

	public static void updateStudent(Student student) throws ParseException {
		STUDENT_INFORMATION.updateStudent(student);
	}

	public static void showAllStudents() {
		STUDENT_INFORMATION.showAllStudents();
	}

	public static int getRollNo() {
		return VIEW.getRollNo();
	}
}
