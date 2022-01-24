package com.students.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import com.students.controller.StudentManagement;
import com.students.model.Student;
import com.students.view.StudentDetails;

/**
 * <h1>Student, Implementation!</h1> The StudentImplementation implements an
 * program to provide services and gives definition to StudentService.
 */
public class StudentServiceImplementation implements StudentService {
	public static final Map<Integer, Student> STUDENTS = new HashMap<>();

	/**
	 * Method to add Student Details from the student. where it do add operation
	 * only.
	 * 
	 * @param rollNo  first parameter to addStudentDetails
	 * @param student second parameter to addStudentdetails
	 * @return Map<Integer, Student> This returns STUDENTS
	 */
	public Map<Integer, Student> addStudent(int rollNo, Student student) {
		STUDENTS.put(rollNo, student);
		return STUDENTS;
	}

	/**
	 * Method to get Student Details. Implemented search operation.
	 * 
	 * @param rollNo one parameter to searchStudentDetail
	 * @return Student This returns get the value of given rollNo
	 */
	public Student searchStudent(int rollNo) {
		
		if (!STUDENTS.containsKey(rollNo)) {
			System.out.println("No student record found \n");
			int rollNumber = StudentManagement.getRollNo();
			return searchStudent(rollNumber);
		}
		return STUDENTS.get(rollNo);
	}

	/**
	 * Method to remove Student Details. where to do remove a student from the
	 * table. detail.
	 * 
	 * @param rollNo one parameter to removeStudentDetail
	 * @return Student This returns to remove the value of given rollNo
	 */
	public Student removeStudent(int rollNo) {
		
		if (!STUDENTS.containsKey(rollNo)) {
			System.out.println("No student record found");
			int rollNumber = StudentManagement.getRollNo();			
			return searchStudent(rollNumber);
		}
		return STUDENTS.remove(rollNo);
	}

	/**
	 * Method to update Student Details. where to replace a student from the table.
	 * detail.
	 * 
	 * @param rollNo  first parameter to updateStudentDetail
	 * @param student second parameter to updateStudentDetail
	 * @return
	 * @return Student This returns to update the value of student which is
	 *         preferred.
	 * @throws ParseException
	 */
	public Student updateStudent(int rollNo, Student student) throws ParseException {
		
		if (STUDENTS.containsKey(rollNo)) {
			Student existingStudent = STUDENTS.get(rollNo);

			if (student.getName() != null) {
				existingStudent.setName(student.getName());
			} else if (student.getBranch() != null) {
				existingStudent.setBranch(student.getBranch());
			} else if (student.getPhoneNumber() != 0) {
				existingStudent.setPhoneNumber(student.getPhoneNumber());
			} else if (student.getAdmissionDate() != null) {
				existingStudent.setAdmissionDate(student.getAdmissionDate());
			}
			return STUDENTS.replace(rollNo, existingStudent);
		} else if (!STUDENTS.containsKey(rollNo)) {
			System.out.println("Invalid Roll No");
			StudentDetails.updateStudent();
		}
		return student;
	}

	/**
	 * Method to Show All Student Details from the table. where to display all
	 * students. details as an output.
	 * 
	 * @return Nothing
	 */
	public void showAllStudents() {
		System.out.println(STUDENTS);
	}
}
