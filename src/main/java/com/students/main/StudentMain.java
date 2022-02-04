package com.students.main;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.students.exception.InvalidStudentDataException.InvalidInputException;
import com.students.view.StudentDetails;

/**
 * Manages all data from the student and provides an access to add, search,
 * remove and update operations.
 * 
 * @author KowsalyaSP
 */
public class StudentMain {
	public static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Method which makes use of all services such as adding, searching, removing,
	 * updating the student details.
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		int choice;

		try {
			do {
				System.out.println(" 1.Add Student \n 2.Search Student \n 3.Remove Student \n 4.Update student \n 5.ShowAll Students \n Enter your choice: ");
				choice = SCANNER.nextInt();

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
				default:
					SCANNER.close();
					System.exit(0);
				}
			} while (choice != 0);
		} catch (InputMismatchException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
}
