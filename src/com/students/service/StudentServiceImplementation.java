package com.students.service;

import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.students.model.Student;
import com.students.view.StudentDetails;
import com.students.view.StudentView;

/**
 * <h1>Student, Implementation!</h1> The StudentImplementation implements an
 * program to provide services and gives definition to StudentService.
 */
public class StudentServiceImplementation implements StudentService {

	/**
	 * @param Integer the type of keys maintained by this map
	 * @param Student the type of mapped values
	 * @see HashMap
	 * @see Collection
	 */
	public static final Map<Integer, Student> STUDENTS = new HashMap<>();
	private static StudentView view = new StudentView();

	/**
	 * Method to add Student Details from the student. where it do add operation only.
	 * 
	 * @param rollNo  first parameter to addStudentDetails
	 * @param student second parameter to addStudentdetails
	 * @return Map<Integer, Student> This returns STUDENTS
	 */
	public Map<Integer, Student> addStudentDetail(int rollNo, Student student) {
		STUDENTS.put(rollNo, student);	
		return STUDENTS;
	}

	/**
	 * Method to get Student Details. where to do search operation.
	 * 
	 * @param rollNo one parameter to searchStudentDetail
	 * @return Student This returns get the value of given rollNo
	 */
	public Student searchStudentDetail(int rollNo) {
		if (!STUDENTS.containsKey(rollNo)) {
			System.out.println("No student record found \n Enter valid RollNo:");
			int rollNumber = view.getRollNo();
			return searchStudentDetail(rollNumber);
		}
		return STUDENTS.get(rollNo);
	}

	/**
	 * Method to remove Student Details. where to do remove a student from the table.
	 * detail.
	 * 
	 * @param rollNo one parameter to removeStudentDetail
	 * @return Student This returns to remove the value of given rollNo
	 */
	public Student removeStudentDetail(int rollNo) {
		if (!STUDENTS.containsKey(rollNo)) {
			System.out.println("No student record found \n Enter valid RollNo:");
			int rollNumber = view.getRollNo();
			return searchStudentDetail(rollNumber);
		}
		return STUDENTS.remove(rollNo);
	}

	/**
	 * Method to update Student Details. where to replace a student from the table.
	 * detail.
	 * 
	 * @param rollNo  first parameter to updateStudentDetail
	 * @param student second parameter to updateStudentDetail
	 * @return Student This returns to update the value of student which is
	 *         preferred.
	 * @throws ParseException
	 */
	public Student updateStudentDetail(int rollNo, Student student) throws ParseException {
		Student update = STUDENTS.get(rollNo);

		if(STUDENTS.containsKey(rollNo)) {

			if (student.getName() != null) {
				update.setName(student.getName());
			} else if (student.getBranch() != null) {
				update.setBranch(student.getBranch());	
				
			} else if (student.getPhoneNumber() != 0) {
				update.setPhoneNumber(student.getPhoneNumber());
				
			} else if (student.getDob() != null) {
				update.setDob(student.getDob());				
			}			
		}
		else if (!STUDENTS.containsKey(rollNo)) {
			System.out.println("Invalid Roll No:");
		    StudentDetails.updateStudentDetail();
		}
		return STUDENTS.replace(rollNo, update);
	}

	/**
	 * Method to Show All Student Details from the table. where to display all students.
	 * details as an output.
	 * 
	 * @return Nothing
	 */
	public void showAllStudents() {
		System.out.println(STUDENTS);
	}
}
