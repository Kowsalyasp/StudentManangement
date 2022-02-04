package com.students.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.students.exception.InvalidStudentDataException;

/**
 * Connection with PostgreSQL database
 * 
 * @author KowsalyaSP
 */
public class StudentDbConnection {
	
	public static Connection getConnection(){
	    Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdatabase", "postgres", "root");
			return connection;
		} catch (SQLException e) {
			throw new InvalidStudentDataException.DatabaseException("Caught An SQL Exception");
		} 		
	}
}
