package com.students.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.students.controller.StudentManagement;
import com.students.model.Student;
import com.students.view.StudentDetails;

/**
 * The StudentImplementation implements an program to provide services and gives
 * definition to StudentService.
 */
public class StudentServiceImp {
	private static final Map<Integer, Student> STUDENTS = new HashMap<>();

	/**
	 * Add Student Details from the student.
	 */
	public Student addStudent(int rollNo, Student student) {

		if (STUDENTS.containsKey(rollNo)) {
			System.out.println("Roll number aldready exist");
		} else {
			STUDENTS.put(rollNo, student);
		}
		return student;
	}

	/**
	 * Search student detail by using roll number.
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
	 * Remove Student Detail by using roll number.
	 */
	public void removeStudent(int rollNo)  {

		if (!STUDENTS.containsKey(rollNo)) {
			System.out.println("No student record found");
			int rollNumber = StudentManagement.getRollNo();

			removeStudent(rollNumber);
		}
		STUDENTS.remove(rollNo);
	}

	/**
	 * Update Student Details.To replace a student value.
	 * 
	 * @throws NoSuchUpdateException
	 * @throws InvalidRollNumberException
	 * @throws SQLException
	 */
	public Student updateStudent(Student student) {

		if (STUDENTS.containsKey(student.getRollNo())) {
			Student existingStudent = STUDENTS.get(student.getRollNo());

			if (student.getName() != null) {
				existingStudent.setName(student.getName());
			} else if (student.getBranch() != null) {
				existingStudent.setBranch(student.getBranch());
			} else if (student.getPhoneNumber() != 0) {
				existingStudent.setPhoneNumber(student.getPhoneNumber());
			} else if (student.getAdmissionDate() != null) {
				existingStudent.setAdmissionDate(student.getAdmissionDate());
			}
		} else {
			System.out.println("Invalid Roll No");
		    StudentDetails.updateStudent();
		}
		return student;
	}

	/**
	 * Show All Student Details as an output.
	 */
	public Map<Integer, Student> viewAllStudents() {
		System.out.println(STUDENTS);
		return STUDENTS;
	}

	public Student updateAllStudent(Student student) {
		Student existingStudent = STUDENTS.get(student.getRollNo());
		
		existingStudent.setName(student.getName());
		existingStudent.setBranch(student.getBranch());
		existingStudent.setPhoneNumber(student.getPhoneNumber());
		existingStudent.setAdmissionDate(student.getAdmissionDate());
		return existingStudent;
	}
}
