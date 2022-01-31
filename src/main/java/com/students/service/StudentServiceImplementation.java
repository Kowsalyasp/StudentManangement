package com.students.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.students.dao.InvalidRollNumberException;
import com.students.dao.NoSuchUpdateException;
import com.students.dao.StoreStudentDataException;
import com.students.dao.StudentServiceDao;
import com.students.model.Student;

/**
 * The StudentImplementation implements an program to provide services and gives
 * definition to StudentService.
 */
public class StudentServiceImplementation implements StudentService {
	private static final Map<Integer, Student> STUDENTS = new HashMap<Integer, Student>();
	private static final StudentServiceDao STUDENT_DAO = new StudentServiceDao();

	/**
	 * Add Student Details from the student.
	 * 
	 * @throws StoreStudentDataException
	 */
	public Student addStudent(int rollNo, Student student) throws StoreStudentDataException {

		if (STUDENT_DAO.selectAllStudents().containsKey(rollNo)) {
			System.out.println("Roll number already exist");
		} else {
			STUDENTS.put(rollNo, student);
			STUDENT_DAO.insertStudent(rollNo, student);
		}
		return student;
	}

	/**
	 * Search student detail by using roll number.
	 * 
	 * @throws InvalidRollNumberException
	 */
	public Student searchStudent(int rollNo) throws InvalidRollNumberException {
		StudentServiceImplementation.getdataFromDatabase();

		if (!STUDENTS.containsKey(rollNo)) {
		    throw new InvalidRollNumberException("Student record not found");
		} else {
			STUDENTS.get(rollNo);
			return STUDENT_DAO.selectStudent(rollNo);
		}
	}

	/**
	 * Remove Student Detail by using roll number.
	 * 
	 * @throws Exceptionclass
	 */
	public void removeStudent(int rollNo) throws InvalidRollNumberException {
		StudentServiceImplementation.getdataFromDatabase();

		if (!STUDENTS.containsKey(rollNo)) {
			throw new InvalidRollNumberException("Student record is not found to remove from the database");
		} else {
			STUDENTS.remove(rollNo);
			STUDENT_DAO.deleteStudent(rollNo);
		}
	}

	/**
	 * Update Student Details.To replace a student value.
	 * 
	 * @throws NoSuchUpdateException
	 * @throws InvalidRollNumberException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public Student updateStudent(Student student)throws ParseException, SQLException, NoSuchUpdateException, InvalidRollNumberException {			
		StudentServiceImplementation.getdataFromDatabase();

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
			throw new NoSuchUpdateException("No student record is updated in the database");
		}
		return STUDENT_DAO.updateStudent(student);
	}

	public Student updateAllStudent(Student student)throws ParseException, SQLException, InvalidRollNumberException, NoSuchUpdateException {
			
		StudentServiceImplementation.getdataFromDatabase();

		if (STUDENTS.containsKey(student.getRollNo())) {
			Student existingStudent = STUDENTS.get(student.getRollNo());

			existingStudent.setBranch(student.getBranch());
			existingStudent.setPhoneNumber(student.getPhoneNumber());
			existingStudent.setAdmissionDate(student.getAdmissionDate());
			System.out.println(existingStudent);
		} else {
			throw new NoSuchUpdateException("No update is available");
		}
		return STUDENT_DAO.updateAllStudent(student);
	}

	/**
	 * Show All Student Details as an output.
	 */
	public Map<Integer, Student> viewAllStudents() {
		Map<Integer, Student> view = STUDENT_DAO.selectAllStudents();

		System.out.println(view);
		return view;
	}
	
	public static void getdataFromDatabase() {

		if (STUDENTS.isEmpty()) {
			STUDENTS.putAll(STUDENT_DAO.selectAllStudents());
		}
	}
}
