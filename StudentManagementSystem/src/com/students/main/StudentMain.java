package com.students.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.students.view.StudentDetails;

/**
 * This class specify that it managed all data from the student and 
 * provides an access to add, search, remove, update operations.
 * @see java.lang.Exception
 * @see java.util.scanner
 * @author KowsalyaSP 
 */
public class StudentMain {
	
	/**
     *{@code Scanner} that returns values scanned
     * the specified source.
     */
	public static final Scanner SCANNER = new Scanner(System.in);
		
	/**
	 * Main method which makes use of all service method.
	 * @param args the command line arguments - unused.
	 * @return Nothing.
	 * Signals that an error has been reached unexpectedly
	 * while parsing.
	 * @exception ParseException, IOException On input error.
	 */	
	public static void main(String[] args) throws ParseException, IOException,InputMismatchException {
		int choice;
		  		
		do {
			System.out.println(" 1.Add Student details\n 2.Search Student details\n 3.Remove Student Details \n"
					+ " 4.Update student details \n 5.ShowAll Student Details\n Enter your choice: ");
			choice = SCANNER.nextInt();
			    try {
				   switch (choice) {
				   		case 1:
				   			StudentDetails.addStudentDetails();
				   			break;
				   		case 2:
				   			StudentDetails.searchStudentDetail();
				   			break;
				   		case 3:
				   			StudentDetails.removeStudentDetail();
				   			break;
				   		case 4:
				   			StudentDetails.updateStudentDetail();
				   			break;		
				   		case 5:
				   			StudentDetails.showAllStudents();
				   			break;						
				   	}
			    } catch (Exception e) {
				   	System.out.println("invalid");			
			   	  }
			} while (choice != 0);
	  }	
}


