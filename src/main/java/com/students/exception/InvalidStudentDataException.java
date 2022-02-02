package com.students.exception;

public class InvalidStudentDataException extends RuntimeException{
	public InvalidStudentDataException(String message) {
		super(message);
	}
}