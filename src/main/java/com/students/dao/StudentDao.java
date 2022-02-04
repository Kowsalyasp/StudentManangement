package com.students.dao;

import java.util.Map;

import com.students.model.Student;

public interface StudentDao {
	 boolean insertStudent(Student student);
	
	 Student selectStudent(int rollNo);
	
	 boolean deleteStudent(int rollNo);
	
	 boolean updateStudent(Student student);
	
	 Map<Integer, Student> selectAllStudents();
}
