package com.students.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import com.students.model.Student;

/**
 * Interface which it define all services.
 */
public interface StudentService {
	Student addStudent(int rollNo, Student student);

	Student searchStudent(int rollNo);

    void removeStudent(int rollNo) throws SQLException;

	void updateStudent(Student student) throws ParseException, SQLException;

	Map<Integer, Student> viewAllStudents();

	void updateAllStudent(Student student) throws ParseException, SQLException;
	
}
