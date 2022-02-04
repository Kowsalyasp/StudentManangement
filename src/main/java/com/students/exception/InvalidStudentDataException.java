package com.students.exception;

public class InvalidStudentDataException extends RuntimeException {
	public InvalidStudentDataException(String message) {
		super(message);
	}

	public static class DatabaseException extends InvalidStudentDataException {
		public DatabaseException(String message) {
			super(message);
		}
	}

	public static class InvalidSQLQueryException extends InvalidStudentDataException {
		public InvalidSQLQueryException(String message) {
			super(message);
		}
	}
	
	public static class InvalidRollNumberException extends InvalidStudentDataException {
		public InvalidRollNumberException(String message) {
			super(message);
		}
	}
	public static class InvalidInputException extends InvalidStudentDataException {
		public InvalidInputException(String message) {
			super(message);
		}
	}
}