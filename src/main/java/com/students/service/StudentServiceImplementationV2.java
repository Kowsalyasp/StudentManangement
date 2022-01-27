package com.students.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.students.model.Student;

public class StudentServiceImplementationV2 implements StudentService {

	protected Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			System.out.println("driver");
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdatabase", "postgres","root");					
		} catch (ClassNotFoundException e) {
			System.out.println("Error Occured!");
		}
		return connection;
	}

	public Student addStudent(int rollNo, Student student) {
		final String addStudent = "INSERT INTO student(rollno, name, phonenumber, branch, admissiondate) VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(addStudent)) {

			statement.setInt(1, student.getRollNo());
			statement.setString(2, student.getName());
			statement.setLong(3, student.getPhoneNumber());
			statement.setString(4, student.getBranch());
			statement.setObject(5, student.getAdmissionDate());
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException addingException) {
			System.out.println("Error Occured while Adding");
		}
		return student;
	}

	public Student searchStudent(int rollNo) {
		Student student = null;

		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT* from student WHERE rollno =?");) {
						
			statement.setInt(1, rollNo);
			ResultSet findingStudent = statement.executeQuery();

			while (findingStudent.next()) {
				String name = findingStudent.getString(2);
				long phoneNumber = findingStudent.getLong(3);
				String branch = findingStudent.getString(4);
				Date admissionDate = findingStudent.getDate(5);
				student = new Student(rollNo, name, phoneNumber, branch, admissionDate);
			}
		} catch (SQLException e) {
			System.out.println("Error Occured While Searching");
		}
		return student;
	}

	public Student removeStudent(int rollNo) {
		int rowDeleted;

		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE from student WHERE rollno = ?");) {
			statement.setInt(1, rollNo);
			rowDeleted = statement.executeUpdate();
			
			if (rowDeleted > 0)
				System.out.println("One User Successfully Deleted");
			else
				System.out.println("Error Occured ");
		} catch (SQLException e) {
			System.out.println("Error Occured While Removing");
		}
		return null;
	}

	public Student updateStudent(Student student) throws ParseException, SQLException {
		Connection connection = getConnection();

		try {

			if (student.getName() != null) {
				PreparedStatement statement = connection.prepareStatement("UPDATE student SET name = ? WHERE rollno = ?");
						
				statement.setString(1, student.getName());
				statement.setInt(2, student.getRollNo());
				statement.executeUpdate();
			} else if (student.getBranch() != null) {
				PreparedStatement statement = connection.prepareStatement("UPDATE student SET phonenumber = ? WHERE rollno = ?");
						
				statement.setString(1, student.getBranch());
				statement.setInt(2, student.getRollNo());
				statement.executeUpdate();

			} else if (student.getPhoneNumber() != 0) {
				PreparedStatement statement = connection.prepareStatement("UPDATE student SET phonenumber = ? WHERE rollno = ?");
						
				statement.setLong(1, student.getPhoneNumber());
				statement.setInt(2, student.getRollNo());
				statement.executeUpdate();
			} else if (student.getAdmissionDate() != null) {
				PreparedStatement statement = connection.prepareStatement("UPDATE student SET admissiondate = ? WHERE rollno = ?");
						
				statement.setObject(1, student.getAdmissionDate());
				statement.setInt(2, student.getRollNo());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Error Occured While Updating");
		}
		connection.close();
		return student;
	}

	public void showAllStudents() {

		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");) {
			System.out.println(preparedStatement);
			ResultSet viewAllStudents = preparedStatement.executeQuery();

			while (viewAllStudents.next()) {
				int rollNumber = viewAllStudents.getInt(1);
				String name = viewAllStudents.getString(2);
				Long phoneNumber = viewAllStudents.getLong(3);
				String branch = viewAllStudents.getString(4);
				Date admissionDate = viewAllStudents.getDate(5);
				Student student = new Student(rollNumber, name, phoneNumber, branch, admissionDate);

				System.out.println(student);
			}
		} catch (SQLException e) {
			System.out.println("Error Occured!");
		}
	}
}
