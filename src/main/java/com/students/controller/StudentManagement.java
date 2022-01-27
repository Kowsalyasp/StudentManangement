package com.students.controller;

import java.sql.SQLException;
import java.text.ParseException;

import com.students.model.Student;
import com.students.service.StudentService;
import com.students.service.StudentServiceImplementation;
import com.students.service.StudentServiceImplementationV2;
import com.students.view.StudentView;

/**
 * Controlled the whole application and managed the student services.
 *
 * @author KowsalyaSP
 */
public class StudentManagement {
	private static final StudentService STUDENT_INFORMATION = new StudentServiceImplementation();
	private static final StudentService STUDENT_SERVICE = new StudentServiceImplementationV2();
	private static final StudentView VIEW = new StudentView();

	public static void addStudent(int rollNo, Student student) throws ParseException, SQLException {
		STUDENT_INFORMATION.addStudent(rollNo, student);
		STUDENT_SERVICE.addStudent(rollNo, student);
	}

	public static void searchStudent(int rollNo) throws SQLException {
		VIEW.showStudent(STUDENT_INFORMATION.searchStudent(rollNo));
		VIEW.showStudent(STUDENT_SERVICE.searchStudent(rollNo));
	}

	public static void removeStudent(int rollNo) throws SQLException {
		VIEW.showStudent(STUDENT_INFORMATION.removeStudent(rollNo));
		VIEW.showStudent(STUDENT_SERVICE.removeStudent(rollNo));
	}

	public static void updateStudent(Student student) throws ParseException, SQLException {
		STUDENT_INFORMATION.updateStudent(student);
		STUDENT_SERVICE.updateStudent(student);
	}

	public static void showAllStudents() {
		STUDENT_INFORMATION.showAllStudents();
		STUDENT_SERVICE.showAllStudents();
	}

	public static int getRollNo() {
		return VIEW.getRollNo();
	}
}

