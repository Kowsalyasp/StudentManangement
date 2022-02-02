package com.students.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import com.students.dao.StudentServiceDao;
import com.students.exception.InvalidStudentDataException;
import com.students.model.Student;

/**
 * The StudentImplV2 retrieve and store the student details from database.
 */
public class StudentServiceImplV2 implements StudentService {
	private static final StudentServiceDao STUDENT_DAO = new StudentServiceDao();

	/**
	 * Add Student Details to the database.
	 */
	public Student addStudent(int rollNo, Student student) {

		if (STUDENT_DAO.selectAllStudents().containsKey(rollNo)) {
			System.out.println("Roll Number Already Exist");
		} else {
			STUDENT_DAO.insertStudent(rollNo, student);
		}
		return student;
	}

	/**
	 * Get Student Detail by using roll number.
	 * 
	 * @throws InvalidStudentDataException
	 */
	public Student searchStudent(int rollNo)throws  InvalidStudentDataException {
	
		if (!STUDENT_DAO.selectAllStudents().containsKey(rollNo)) {
		    throw new InvalidStudentDataException("Invalid Student Data");
		} else {
			System.out.println("Found the Student Data");
			return STUDENT_DAO.selectStudent(rollNo);
		}
	}

	/**
	 * Remove Student Data by using roll number.
	 * 
	 * @throws InvalidStudentDataException
	 */
	public void removeStudent(int rollNo) throws InvalidStudentDataException {
		
		if (!STUDENT_DAO.selectAllStudents().containsKey(rollNo)) {
			throw new InvalidStudentDataException("Invalid Student Data");
		} else {
			System.out.println("Successfully Removed The Data");
			STUDENT_DAO.deleteStudent(rollNo);
		}
	}

	/**
	 * Update each Student record from database for specified roll number.
	 * 
	 * @throws SQLException
	 * @throws ParseException
	 * @throws InvalidStudentDataException
	 */
	public void updateStudent(Student student)throws ParseException, SQLException, InvalidStudentDataException {			

	    if (!STUDENT_DAO.selectAllStudents().containsKey(student.getRollNo())) {
			throw new InvalidStudentDataException("Invalid Student Data");
	    } else {		
			STUDENT_DAO.updateStudent(student);
			System.out.println("Successfully Updated The Data");
		}		
	}

	/**
	 * Update all Student record from database for specified roll number.
	 * 
	 * @throws SQLException
	 * @throws ParseException
	 * @throws InvalidStudentDataException
	 */
	public void updateAllStudent(Student student)throws ParseException, SQLException, InvalidStudentDataException {
			
		if (!STUDENT_DAO.selectAllStudents().containsKey(student.getRollNo())) {
			throw new InvalidStudentDataException("Invalid Student Data");
		} else {
			 STUDENT_DAO.updateAllStudent(student);
		}		
	}

	/**
	 * View All Student Details from database.
	 */
	public Map<Integer, Student> viewAllStudents() {
		Map<Integer, Student> view = STUDENT_DAO.selectAllStudents();
		
		System.out.println(view);
		return view;
	}
}
