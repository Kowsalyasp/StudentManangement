package com.students.service;

import java.text.ParseException;

import com.students.model.Student;

/**
 * Interface which it define all services.
 */
public interface StudentService {
	Student addStudent(int rollNo, Student student);

	Student searchStudent(int rollNo);

	Student removeStudent(int rollNo);

	Student updateStudent(Student student) throws ParseException;

	void showAllStudents();
}
