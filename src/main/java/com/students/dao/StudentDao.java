package com.students.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import com.students.model.Student;

public interface StudentDao {
	public Student insertStudent(int rollNo, Student student) throws  StoreStudentDataException;
	
	public Student selectStudent(int rollNo) throws InvalidRollNumberException;
	
	public boolean deleteStudent(int rollNo) throws InvalidRollNumberException;
	
	public Student updateStudent(Student student) throws ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException;
	
	public Map<Integer, Student> selectAllStudents();
	
	public Student updateAllStudent(Student student) throws NoSuchUpdateException ;
}
