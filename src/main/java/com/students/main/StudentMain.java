package com.students.main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.students.dao.InvalidRollNumberException;
import com.students.dao.NoSuchUpdateException;
import com.students.dao.StoreStudentDataException;
import com.students.view.StudentDetails;

/**
 * It managed all data from the student and provides an access to add, search,
 * remove and update operations.
 * 
 * @author KowsalyaSP
 */
public class StudentMain {
	public static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Method which makes use of all services such as adding, searching, removing,
	 * updating the student details.
	 * 
	 * @throws StoreStudentDataException
	 * @throws NoSuchUpdateException
	 * @throws InvalidRollNumberException
	 */
	public static void main(String[] args) throws ParseException, SQLException, InvalidRollNumberException, StoreStudentDataException, NoSuchUpdateException {			
		int choice;

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
			}
		} while (choice != 0);
	}
}
