package com.students.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection with PostgreSQL database
 * 
 * @author KowsalyaSP
 */
public class StudentDbConnection {
	
	public static Connection getConnection() {
	    Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdatabase", "postgres", "root");
		} catch (SQLException e) {
			System.out.println("Caught An SQL Exception");
		} 
		return connection;
	}
}
