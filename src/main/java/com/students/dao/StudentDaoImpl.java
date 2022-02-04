package com.students.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.students.exception.InvalidStudentDataException;
import com.students.model.Student;

/**
 * Implemented the SQL query and connected it with the database.
 */
public class StudentDaoImpl implements StudentDao {

	/**
	 * Insert student data's to the database for the specified roll number.
	 */
	public boolean insertStudent(final Student student) {
		final String insertQuery = "INSERT INTO student(roll_no, name, phone_number, branch, admission_date, is_active) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = StudentDbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setInt(1, student.getRollNo());
			statement.setString(2, student.getName());
			statement.setLong(3, student.getPhoneNumber());
			statement.setString(4, student.getBranch());
			statement.setDate(5, student.getAdmissionDate());
			statement.setBoolean(6, true);

			return statement.executeUpdate()>0;
		} catch (SQLException exception) {
			throw new InvalidStudentDataException.InvalidSQLQueryException(exception.getMessage());
		}
	}

	/**
	 * Fetch student data from the database by using roll number.
	 */
	public Student selectStudent(final int rollNo) {
		Student student = null;
		final String selectQuery = "SELECT roll_no, name, phone_number, branch, admission_date FROM student WHERE is_active = true AND roll_no =?";

		try (Connection connection = StudentDbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {
			statement.setInt(1, rollNo);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				final String name = resultSet.getString(2);
				final long phoneNumber = resultSet.getLong(3);
				final String branch = resultSet.getString(4);
				final Date admissionDate = resultSet.getDate(5);
				student = new Student(rollNo, name, phoneNumber, branch, admissionDate);
			}
			return student;
		} catch (SQLException exception) {
			throw new InvalidStudentDataException.InvalidSQLQueryException(exception.getMessage());
		} 			
	}

	/**
	 * Delete student data from the database.
	 */
	public boolean deleteStudent(final int rollNo) {
		final String deleteQuery = "UPDATE student SET is_active = ? WHERE roll_no = ?";

		try (Connection connection = StudentDbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(deleteQuery);) {
			statement.setBoolean(1, false);
			statement.setInt(2, rollNo);

			return statement.executeUpdate()>0; 
		} catch (SQLException exception) {
			throw new InvalidStudentDataException.InvalidSQLQueryException(exception.getMessage());
		}
	}

	/**
	 * Update student data for the specified roll number.
	 */
	public boolean updateStudent(final Student student) {
		final StringBuilder queryBuilder = new StringBuilder();
		String updateQuery = queryBuilder.append("UPDATE student SET").toString();

		try (Connection connection = StudentDbConnection.getConnection();
				Statement statement = connection.createStatement();) {

			if (student.getName() != null) {
				updateQuery = queryBuilder.append(" name= '").append(student.getName()).append("'").toString();
			}

			if (student.getBranch() != null) {
				updateQuery = queryBuilder.append(" branch = '").append(student.getBranch()).append("'").toString();
			}

			if (student.getPhoneNumber() != 0) {
				updateQuery = queryBuilder.append(" phone_number = ").append(student.getPhoneNumber()).toString();
			}

			if (student.getAdmissionDate() != null) {
				updateQuery = queryBuilder.append(" admission_date = '").append(student.getAdmissionDate()).append("'").toString();						
			}
			updateQuery = queryBuilder.append(" WHERE roll_no = ").append(student.getRollNo()).toString();

			return statement.execute(updateQuery);
		} catch (SQLException exception) {
			throw new InvalidStudentDataException.InvalidSQLQueryException(exception.getMessage());
		}
	}

	/**
	 * Fetch all student data from database.
	 */
	public Map<Integer, Student> selectAllStudents() {
		final String selectAllQuery = "SELECT roll_no, name, phone_number, branch, admission_date FROM student WHERE is_active = true";
		final Map<Integer, Student> students = new HashMap<>();

		try (Connection connection = StudentDbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery);
				ResultSet resultSet = preparedStatement.executeQuery();) {

			while (resultSet.next()) {
				final int rollNumber = resultSet.getInt(1);
				final String name = resultSet.getString(2);
				final Long phoneNumber = resultSet.getLong(3);
				final String branch = resultSet.getString(4);
				final Date admissionDate = resultSet.getDate(5);

				students.put(rollNumber, new Student(rollNumber, name, phoneNumber, branch, admissionDate));
			}
			return students;
		} catch (SQLException exception) {
			throw new InvalidStudentDataException.InvalidSQLQueryException(exception.getMessage());
		}
	}
}
