package com.students.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Map;

import com.students.dao.InvalidRollNumberException;
import com.students.dao.NoSuchUpdateException;
import com.students.dao.StoreStudentDataException;
import com.students.model.Student;

/**
 * Interface which it define all services.
 */
public interface StudentService {
	Student addStudent(int rollNo, Student student) throws StoreStudentDataException;

	Student searchStudent(int rollNo) throws InvalidRollNumberException;

    void removeStudent(int rollNo) throws SQLException, InvalidRollNumberException;

	Student updateStudent(Student student) throws ParseException, SQLException, NoSuchUpdateException, InvalidRollNumberException;

	Map<Integer, Student> viewAllStudents();

	Student updateAllStudent(Student student) throws InputMismatchException, ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException;
	
}
