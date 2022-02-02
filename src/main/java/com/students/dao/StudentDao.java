package com.students.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import com.students.exception.InvalidStudentDataException;
import com.students.model.Student;

public interface StudentDao {
	 Student insertStudent(int rollNo, Student student) throws InvalidStudentDataException;
	
	 Student selectStudent(int rollNo) throws InvalidStudentDataException;
	
	 void deleteStudent(int rollNo) throws InvalidStudentDataException;
	
	 void updateStudent(Student student) throws ParseException, SQLException, InvalidStudentDataException;
	
	 Map<Integer, Student> selectAllStudents();
}
