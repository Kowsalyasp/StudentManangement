package com.students.controller;

import java.text.ParseException;
import com.students.model.Student;
import com.students.service.StudentService;
import com.students.service.StudentServiceImplementation;
import com.students.view.StudentView;

/**
 * This class controlled the whole application and it managed
 * the student services what is preferred.
 * @author KowsalyaSP
 *
 */
public class StudentManagement {
		
        // Fields and methods to match Student Services    
		private static StudentService studentInfo = new StudentServiceImplementation();
        private static StudentView view = new StudentView();
        
        /**
         * Method to call all the required details from the user to add the specified student
         * @param rollNo  The student's roll Number.
         * @param student  The student class .
         * @throws ParseException
         */
         
	    public static void addStudent(int rollNo, Student student) throws ParseException {
	    	studentInfo.addStudentDetail(rollNo, student);
	    }

	    /**
	     * An authorized student can search by an unique roll number
	     * @param rollNo The student's unique roll Number
	     */
	    public static void searchStudent(int rollNo) {
	    	view.viewStudent(studentInfo.searchStudentDetail(rollNo));
	    }

	    /**
	     * To remove an student from the list using an unique rollNo, 
	     * if not identified a particular rollNo,it give the warn message
	     * and to specify an valid rollNo.
	     * @param rollNo The student's unique roll Number
	     */
		public static void removeStudent(int rollNo) {
	    	view.viewStudent(studentInfo.removeStudentDetail(rollNo)); 
	    }

		/**
		 * Method to call an updating a details in certain conditions and to modify all.
		 * @param rollNo The student's unique roll Number.
		 * @param student The student class.
		 * @throws ParseException
		 */
	    public static void updateStudent(int rollNo,Student student) throws ParseException {
	    	studentInfo.updateStudentDetail(rollNo, student);
	    }
	    
	    /**
	     * This Method to show display all students from the table.
	     * @return Nothing
	     */
	   public static  void showAllStudents() {
		    studentInfo.showAllStudents();
	   }
}
