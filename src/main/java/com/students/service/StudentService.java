package com.students.service;

import java.util.List;

import com.students.model.Student;

/**
 * Interface which it define all services.
 */
public interface StudentService {
	boolean addStudent(Student student);

	Student searchStudent(int rollNo);

    boolean removeStudent(int rollNo);

	boolean updateStudent(Student student);

	List<Student> viewAllStudents();	
}
