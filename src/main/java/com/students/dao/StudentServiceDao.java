package com.students.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.students.model.Student;

public class StudentServiceDao implements StudentDao {
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/studentdatabase";
	private static final String JDBC_USERNAME = "postgres";
	private static final String JDBC_PASSWORD = "root";
	
	protected static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Caught an SQL Exception ");
		} catch (ClassNotFoundException e) {
			System.out.println("Error Occured! Class is Not Found");
		}
		return connection;
	}

	public Student insertStudent(int rollNo, Student student) throws StoreStudentDataException {
		final String insertStudent = "INSERT INTO student(rollno, name, phonenumber, branch, admissiondate, isactive) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(insertStudent)) {
			statement.setInt(1, student.getRollNo());
			statement.setString(2, student.getName());
			statement.setLong(3, student.getPhoneNumber());
			statement.setString(4, student.getBranch());
			statement.setObject(5, student.getAdmissionDate());
			statement.setBoolean(6,true);
			System.out.println(statement);
			statement.executeUpdate();
			
		} catch (SQLException exception) {
			throw new StoreStudentDataException("Failed to save student record");
		}
		return student;
	}

	public Student selectStudent(int rollNo) throws InvalidRollNumberException {
		Student student = null;
		final String selectStudentByRollNo = "SELECT * from student WHERE rollno =?";
		
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(selectStudentByRollNo);) {
			statement.setInt(1, rollNo);
			ResultSet selectStudent = statement.executeQuery();

			while (selectStudent.next()) {
				String name = selectStudent.getString(2);
				long phoneNumber = selectStudent.getLong(3);
				String branch = selectStudent.getString(4);
				Date admissionDate = selectStudent.getDate(5);
				student = new Student(rollNo, name, phoneNumber, branch, admissionDate);
			}
		} catch (SQLException e) {
			throw new InvalidRollNumberException("Student record not found");
		  }
		return student;
	}

	public boolean deleteStudent(int rollNo) throws InvalidRollNumberException {
		boolean rowDeleted = false;
		final String deleteStudent ="UPDATE student SET isactive = ? WHERE rollno = ?";
		
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(deleteStudent);) {
			statement.setBoolean(1, false);
			statement.setInt(2, rollNo);
			rowDeleted = true;
			rowDeleted = statement.executeUpdate() > 0;

			if (!rowDeleted)				
				System.out.println("Error Occured");
			else {
				System.out.println("One Student Successfully Deleted ");
			}
		} catch (SQLException e) {
			throw new InvalidRollNumberException("Unable to delete a student record from database");
		}
		return rowDeleted;
	}

	public Student updateStudent(Student student) throws ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException {
		final String updateName = "UPDATE student SET name = ? WHERE rollno = ?";
		final String updateBranch = "UPDATE student SET branch = ? WHERE rollno = ?";
		final String updatePhoneNumber = "UPDATE student SET phonenumber = ? WHERE rollno = ?";
		final String updateAdmissionDate = "UPDATE student SET admissiondate = ? WHERE rollno = ?";
		
		try (Connection connection = getConnection();){
			
			if (student.getName() != null) {
				PreparedStatement statement = connection.prepareStatement(updateName);
						
				statement.setString(1, student.getName());
				statement.setInt(2, student.getRollNo());
				statement.executeUpdate();
			} else if (student.getBranch() != null) {
				PreparedStatement statement = connection.prepareStatement(updateBranch);
						
				statement.setString(1, student.getBranch());
				statement.setInt(2, student.getRollNo());
				statement.executeUpdate();

			} else if (student.getPhoneNumber() != 0) {
				PreparedStatement statement = connection.prepareStatement(updatePhoneNumber);
						
				statement.setLong(1, student.getPhoneNumber());
				statement.setInt(2, student.getRollNo());
				statement.executeUpdate();
			} else if (student.getAdmissionDate() != null) {
				PreparedStatement statement = connection.prepareStatement(updateAdmissionDate);
						
				statement.setObject(1, student.getAdmissionDate());
				statement.setInt(2, student.getRollNo());
				statement.executeUpdate();
			}
		} catch (SQLException exception) {
			throw new NoSuchUpdateException("No update Available!");
		} 
		return student;
	}

	public Student updateAllStudent(Student student) throws NoSuchUpdateException {
		boolean rowUpdated = false;
		final String updateAllStudent = "Update student set name = ?, phonenumber = ?, branch = ?, admissiondate = ? where rollno = ?";
	
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(updateAllStudent);) {
			statement.setString(1, student.getName());
			statement.setString(3, student.getBranch());
			statement.setLong(2, student.getPhoneNumber());
			statement.setObject(4, student.getAdmissionDate());
			statement.setInt(5, student.getRollNo());
			statement.executeUpdate();
			rowUpdated = true;
			rowUpdated = statement.executeUpdate() > 0;
				
			if (!rowUpdated) 
				throw new NoSuchUpdateException("Could not update the student record!");
				else {
				System.out.println("Student Successfully Updated ");
			}			
		} catch (SQLException exception) {
			System.out.println("Error Occured While Updating All Record ");
		}
		return student;
	}

	public Map<Integer, Student> selectAllStudents() {
		final String selectAllStudents = "SELECT * FROM student WHERE isactive = true";
		final Map<Integer, Student> students = new HashMap<>();

		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(selectAllStudents);) {
			ResultSet viewAllStudents = preparedStatement.executeQuery();

			while (viewAllStudents.next()) {
			    int rollNumber = viewAllStudents.getInt(1);
				String name = viewAllStudents.getString(2);
				Long phoneNumber = viewAllStudents.getLong(3);
				String branch = viewAllStudents.getString(4);
				Date admissionDate = viewAllStudents.getDate(5);

				students.put(rollNumber, new Student(rollNumber, name, phoneNumber, branch, admissionDate));
			}
		} catch (SQLException exception) {
			System.out.println("Error Occured!");
		}
		return students;
	}
}
