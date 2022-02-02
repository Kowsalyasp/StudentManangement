package com.students.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.students.model.Student;

/**
 * Implemented the SQL query and connected with database.
 */
public class StudentServiceDao implements StudentDao {

	/**
	 * Insert student data's to the database for the specified roll number.
	 */
	public Student insertStudent(final int rollNo, final Student student) {
		final String insertStudent = "INSERT INTO student(roll_no, name, phone_number, branch, admission_date, is_active) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (final Connection connection = StudentDbConnection.getConnection();
			final PreparedStatement statement = connection.prepareStatement(insertStudent)) {
			statement.setInt(1, student.getRollNo());
			statement.setString(2, student.getName());
			statement.setLong(3, student.getPhoneNumber());
			statement.setString(4, student.getBranch());
			statement.setObject(5, student.getAdmissionDate());
			statement.setBoolean(6, true);
			statement.executeUpdate();			
		} catch (SQLException exception) {
			System.out.println("Failed To Insert Data");
		}
		return student;
	}

	/**
	 * Fetch student data from database by using roll number.
	 */
	public Student selectStudent(final int rollNo) {
		Student student = null;
		final String selectStudentByRollNo = "SELECT * from student WHERE roll_no =?";
		
		try (final Connection connection = StudentDbConnection.getConnection();
			final PreparedStatement statement = connection.prepareStatement(selectStudentByRollNo); ){			
			statement.setInt(1, rollNo);
			final ResultSet selectStudent = statement.executeQuery();
						
			while (selectStudent.next()) {
				final String name = selectStudent.getString(2);
				final long phoneNumber = selectStudent.getLong(3);
				final String branch = selectStudent.getString(4);
				final Date admissionDate = selectStudent.getDate(5);
				student = new Student(rollNo, name, phoneNumber, branch, admissionDate);
			}
			selectStudent.close();
		} catch (SQLException exception) {
			System.out.println("Student Record Not Found");
		  }
		return student;
	}

    /**
     * Delete student data from the database.
     */
	public void deleteStudent(final int rollNo) {
		final String deleteStudent ="UPDATE student SET is_active = ? WHERE roll_no = ?";
		
		try (final Connection connection = StudentDbConnection.getConnection();
			final PreparedStatement statement = connection.prepareStatement(deleteStudent);) {
			statement.setBoolean(1, false);
			statement.setInt(2, rollNo);
			statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Failed To Delete");
		}	
	}

	/**
	 * Update student data for the specified roll number.
	 */
	@SuppressWarnings("resource")
	public void updateStudent(final Student student) throws ParseException, SQLException {	
		final String updateQuery = "UPDATE student SET";
		PreparedStatement statement=null;
		
		try (final Connection connection = StudentDbConnection.getConnection();){	
			
			if (student.getName() != null) {
				 statement = connection.prepareStatement(updateQuery + " name=? WHERE roll_no=?" );
				 
				 statement.setString(1, student.getName());
				 statement.setInt(2, student.getRollNo());
			} 
			
			if (student.getBranch() != null) {	
				statement = connection.prepareStatement(updateQuery + " branch=? WHERE roll_no=?" );
				
				statement.setString(1, student.getBranch());
				statement.setInt(2, student.getRollNo());
		    } 
			
			if (student.getPhoneNumber() != 0) {
		    	statement = connection.prepareStatement(updateQuery + " phone_number=? WHERE roll_no=?" );
		    	
		    	statement.setLong(1, student.getPhoneNumber());		    
				statement.setInt(2, student.getRollNo());
		    } 
			
			if (student.getAdmissionDate() != null) {
		    	statement = connection.prepareStatement(updateQuery + " admission_date=? WHERE roll_no=?" );
		    	
				statement.setObject(1, student.getAdmissionDate());
				statement.setInt(2, student.getRollNo());
		    }		
		    statement.executeUpdate();
		} catch (SQLException exception) {
			System.out.println("Failed To Update");
		} 	
		finally {
			statement.close();
		}
	}

	public Student updateAllStudent(final Student student) {
		final String updateAllStudent = "UPDATE student SET name = ?, phone_number = ?, branch = ?, admission_date = ? WHERE roll_no = ?";
		
		try (final Connection connection = StudentDbConnection.getConnection();
			final PreparedStatement statement = connection.prepareStatement(updateAllStudent);) {
			statement.setString(1, student.getName());
			statement.setString(3, student.getBranch());
			statement.setLong(2, student.getPhoneNumber());
			statement.setObject(4, student.getAdmissionDate());
			statement.setInt(5, student.getRollNo());
			statement.executeUpdate();	
		} catch (SQLException exception) {
			System.out.println("Failed To Update All Data");
		}
		return student;
	}

	/**
	 * Fetch all student data from database.
	 */
	public Map<Integer, Student> selectAllStudents() {
		final String selectAllStudents = "SELECT * FROM student WHERE is_active = true";
		final Map<Integer, Student> students = new HashMap<>();

		try (final Connection connection = StudentDbConnection.getConnection();
			final PreparedStatement preparedStatement = connection.prepareStatement(selectAllStudents); final ResultSet resultSet = preparedStatement.executeQuery();) {
		
			while (resultSet.next()) {
			    final int rollNumber = resultSet.getInt(1);
				final String name = resultSet.getString(2);
				final Long phoneNumber = resultSet.getLong(3);
				final String branch = resultSet.getString(4);
				final Date admissionDate = resultSet.getDate(5);

				students.put(rollNumber, new Student(rollNumber, name, phoneNumber, branch, admissionDate));
			}
		} catch (SQLException exception) {
			System.out.println("No Student Record Is Found");
		}
		return students;
	}
}
