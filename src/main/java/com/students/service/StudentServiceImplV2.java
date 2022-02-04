package com.students.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.students.dao.StudentDao;
import com.students.dao.StudentDaoImpl;
import com.students.exception.InvalidStudentDataException;
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
	 * 
	 * @throws InvalidStudentDataException
	 */
	public Student searchStudent(final int rollNo){
		return STUDENT_DAO.selectStudent(rollNo);
	}

	/**
	 * Remove Student Data by using roll number.
	 */
	public boolean removeStudent(final int rollNo) {
			return STUDENT_DAO.deleteStudent(rollNo);
	}

	/**
	 * Update each Student record from database for specified roll number.
	 * 
	 * @throws SQLException
	 * @throws ParseException
	 */
	public boolean updateStudent(final Student student){
		return STUDENT_DAO.updateStudent(student);
	}

	/**
	 * View All Student Details from database.
	 */
	public List<Student> viewAllStudents() {
		final List<Student> students = new ArrayList<>(STUDENT_DAO.selectAllStudents().values());

		return students;
	}
}
