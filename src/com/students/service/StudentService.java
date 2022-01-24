package com.students.service;

import java.text.ParseException;
import java.util.Map;
import com.students.model.Student;

/**
 * Interface which it define all the services.
 * 
 * @author KowsalyaSP
 */
public interface StudentService {

	/**
	 * Required to add details for a specified student.
	 * 
	 * @param rollNo  The student's rollNo
	 * @param student The student class
	 * @return Map<Integer, Student> which it returns the student details
	 */
	public Map<Integer, Student> addStudent(int rollNo, Student student);

	/**
	 * Search an specified student to get the details
	 * 
	 * @param rollNo The student's rollNo
	 * @return student
	 */
	public Student searchStudent(int rollNo);

	/**
	 * Search an specified student to remove the details from the list
	 * 
	 * @param rollNo The student's rollNo
	 * @return student
	 */
	public Student removeStudent(int rollNo);

	/**
	 * Update a student Detail and required to replace in an specific field.
	 * 
	 * @param rollNo  The student's rollNo
	 * @param student
	 * @return student object
	 * @throws ParseException
	 */
	public Student updateStudent(int rollNo, Student student) throws ParseException;

	/**
	 * To show all student details which is required.
	 */
	public void showAllStudents();
}