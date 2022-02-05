package com.students.service;

import java.util.ArrayList;
import java.util.List;

import com.students.dao.StudentDao;
import com.students.dao.StudentDaoImpl;
import com.students.exception.InvalidStudentDataException.InvalidRollNumberException;
import com.students.model.Student;

/**
 * The StudentImplV2 retrieve and store the student details from database.
 */
public class StudentServiceImplV2 implements StudentService {
	private static final StudentDao STUDENT_DAO = new StudentDaoImpl();

	/**
	 * Add Student Details to the database.
	 */
	public boolean addStudent(final Student student) {
		return STUDENT_DAO.insertStudent(student);
	}

	/**
	 * Get Student Detail by using roll number.
	 */
	public Student searchStudent(final int rollNo){
		Student student = STUDENT_DAO.selectStudent(rollNo);
		
		if (student != null) {
			return student;			
		} else {
			throw new InvalidRollNumberException("Invalid Roll Number"); 
		}
	}

	/**
	 * Remove Student Data by using roll number.
	 */
	public boolean removeStudent(final int rollNo) {
		boolean isRemoved = STUDENT_DAO.deleteStudent(rollNo);

		if (isRemoved) {
			return true;
		} else {
			throw new InvalidRollNumberException("Invalid Roll Number");
		}
	}

	/**
	 * Update each Student record from database for specified roll number.
	 */
	public boolean updateStudent(final Student student){
		boolean isUpdated =  STUDENT_DAO.updateStudent(student);

		if (isUpdated) {
			return true;
		} else {
			throw new InvalidRollNumberException("Invalid Roll Number");
		}
	}

	/**
	 * View All Student Details from database.
	 */
	public List <Student> viewAllStudents() {
		final List <Student> students = new ArrayList<>(STUDENT_DAO.selectAllStudents().values());

		return students;
	}
}
