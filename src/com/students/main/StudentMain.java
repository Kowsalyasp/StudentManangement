package com.students.main;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.students.view.StudentDetails;

/**
 * It managed all data from the student and provides an access to add, search, remove and update operations.
 * 
 * @author KowsalyaSP
 */
public class StudentMain {
	public static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Method which makes use of all services such as adding, searching, removing, updating the student details.
	 */
	public static void main(String[] args) throws ParseException, InputMismatchException {
		int choice;

		do {
			System.out.println(" 1.Add Student Details\n 2.Search Student Detail\n 3.Remove Student Detail \n 4.Update student Detail \n 5.ShowAll Student Details\n Enter your choice: ");
			choice = SCANNER.nextInt();

			try {
				switch (choice) {
				case 1:
					StudentDetails.addStudent();
					break;					
				case 2:
					StudentDetails.searchStudent();
					break;					
				case 3:
					StudentDetails.removeStudent();
					break;					
				case 4:
					StudentDetails.updateStudent();
					break;				
				case 5:
					StudentDetails.showAllStudents();
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid Choice");
			}
		} while (choice != 0);
	}
}
