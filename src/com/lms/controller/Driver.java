package com.lms.controller;

import java.util.Scanner;

public class Driver {

	/**
	 * users can either choose to enter the branches managed, or go back to the main menu.  
	 * @return void
	 * @param input
	 */
	public static void LIB1(Scanner input) {
		boolean dontGoBack = true;
		while (dontGoBack) {
			System.out.println("------------------ LIB1 ------------------ ");
			System.out.println("1: Enter Branch you manage.");
			System.out.println("2: Go back to the Main menu. ");
			System.out.println("Input: ");
			int answer = input.nextInt();
			if (answer == 1) {
				LIB2(input);
			} else if (answer != 1 && answer != 2) {
				System.out.println("Invalid choice!\n please choose either 1 or 2!");
			} else {
				dontGoBack = false;
			}
		}
	}
	/**
	 * Gives the option of different library branches or go to the previous page. 
 	* @return void
 	* @param input
 	*/
	public static void LIB2(Scanner input) {
		boolean dontGoBack = true;
		while (dontGoBack) {
			System.out.println("------------------ LIBRARY BRANCHES ------------------");
			System.out.println("1: University Library, Boston");
			System.out.println("2: State Library, New York");
			System.out.println("3: Go back to previous page(should take you menu LIB1)");
			System.out.println("Input: ");
			int answer = input.nextInt();
			if (answer == 1 || answer == 2) {
				LIB3(input);
			} else if (answer != 1 && answer != 2 && answer != 3) {
				System.out.println("Invalid choice!\n please choose either 1, 2 or 3! ");
			} else {
				dontGoBack = false;
			}
		}
		System.out.println(" ------------------ BACK TO MAIN MENU ----------------");
	}
	/**
	 * users can update details of their library, add new copies of book to their branch or go back to the previous page. 
	 * @return void 
	 * @param input
	 */
	public static void LIB3(Scanner input) {
		boolean dontGoBack = true;
		while (dontGoBack) {
			System.out.println("------------------ LIB3 ------------------");
			System.out.println("1: Update the details of the Library!");
			System.out.println("2: Add copies of book to the Branch!");
			System.out.println("3: Go back to the previous page! should take you to menu LIB2!");
			System.out.println("Input: ");
			int answer = input.nextInt();
			if (answer == 1) {
				LIB4(input);
			} else if (answer == 2) {
				LIB5(input);
			} else if (answer == 3) {
				dontGoBack = false;
			}
		}
	}
	/**
	 * Users can update their branch name and address, or not make any changes at all. 
	 * @return void
	 * @param input
	 */
	public static void LIB4(Scanner input) {
		boolean dontGoBack = true;
		while (dontGoBack) {
			System.out.println("You have chosen to update the Branch...Enter ‘quit’ at any prompt to cancel operation.");
			System.out.println("Please enter new branch name or enter N/A for no change:");
			System.out.print("input:");
			String branchName = input.next();
			if (branchName.equalsIgnoreCase("N/A")) {
				System.out.println("No branch name Update ");
			} else if (branchName.equalsIgnoreCase("Quit")) {
				break;
			} else {
				System.out.println("------------ Branch name updated succesfully!! ------------" + "\n"
						+ "New Branch name: " + "" + branchName);
			}
			System.out.println("Please enter new branch address or enter N/A for no change:");
			String branchNewAddress = input.next();

			if (branchNewAddress.equalsIgnoreCase("N/A")) {
				System.out.println("No branch address Update ");
			} else if (branchNewAddress.equalsIgnoreCase("Quit")) {
				break;
			} else {
				System.out.println("------------ New Branch address update succesfully!! -------" + "\n"
						+ "New branch Address: " + "" + branchNewAddress);
			}
			dontGoBack = false;
		}
	}
	/**
	 * gives users different books to select to their branch, with an option of quitting at any time during the operation. 
	 * @return void
	 * @param input
	 */
	public static void LIB5(Scanner input) {
		boolean dontGoBack = true;
		while (dontGoBack) {
			System.out.println("Pick the book you want to add copies to your branch!");
			System.out.println("1: Lost Tribe by Sidney Sheldon.");
			System.out.println("2: The Haunting by Stepehen King.");
			System.out.println("3: Microtrends by Mark Penn.");
			System.out.println("4: 'QUIT' to cancel the operation!");
			System.out.println("Input: ");
			String str = input.next();
			if(str.equalsIgnoreCase("quit")) {
				break;
			}
			int answer =Integer.parseInt(str);
			if (answer == 1 || answer == 2 || answer == 3) {
				System.out.println("Existing number of copies: 3 ");
				System.out.println("Enter new number of copies: ");
				int answer4 = input.nextInt();
				System.out.println("----------- Succesfully updated -------------" + " \n " + "New # of copies: "
						+ (3 + answer4));
			} else if (answer != 1 && answer != 2 && answer != 3 && answer != 4) {
				System.out.println("Invalid choice! \n please choose either 1, 2, 3 or 4! ");
			} else if (answer == 4) {
				dontGoBack = false;
			} else if (str.equalsIgnoreCase("Quit")) {
				break;
			}
		}
	}
	/**
	 *  Borrower allows users to input card number and gives an option of going to previous page. 
	 * @param input
	 * @return void
	 * 
	 */
	public static void Borrower(Scanner input) {
		boolean dontGoBack = true;
		while (dontGoBack) {
			System.out.println("-------------- Borrower page -----------------");
			// enter a valid credit card number
			System.out.println("1: Enter your card number: ");
			System.out.println("2: Go back to previous");
			System.out.println("Input: ");
			int answer = input.nextInt();
			if (answer == 1) {
				Borrower2(input);
			} else if (answer == 2) {
				dontGoBack = false;
			} else {
				System.out.println("Invalid choice. Please pick 1 or 2!");
			}
		}
	}
	
	/**
	 * Allows user to check out/return books 
	 * @return void 
	 * @param input
	 */
	public static void Borrower2(Scanner input) {
		boolean dontGoBack = true;
		while (dontGoBack) {
			System.out.println("----------------- book info ------------- ");
			System.out.println("1: Check out a book.");
			System.out.println("2: Return a book.");
			System.out.println("3: Go back to previous(Should take you to main menu).");
			System.out.println("Input: ");
			int answer = input.nextInt();
			if (answer == 1) {
				System.out.println("Please enter the Branch you want to check the book.....");
				System.out.println("1: University Library, Boston");
				System.out.println("2: State Library, New York");
				System.out.println("3: Federal Library, Washington DC");
				System.out.println("4: County Library, McLean VA ");
				System.out.println("5: Go back to previous! ");
				System.out.println("Input: ");
				int ans = input.nextInt();
				LIB5(input);
			} else if (answer == 2) {
				LIB5(input);
			} else if (answer == 3) {
				dontGoBack = false;
			} else {
				System.out.println("Invalid choice. Please pick 1, 2 or 3.!");
			}
		}
	}
	/**
	 * allows user to choose 3 different categories and presents them with the next steps based on the selection.
	 * @return void
	 * @param args
	 * @author merhawitgezahegn 
	 */ 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean isMain = true;
		while (isMain) {
			System.out.println("Welcome to the GCIT Library Management System. Which category of a user are you?");
			System.out.println("Category 1: Librarian");
			System.out.println("Category 2: Administrator");
			System.out.println("Category 3: Borrower");
			System.out.println("Input:  ");
			int answer = input.nextInt();
			if (answer == 1) {
				LIB1(input);
			} else if (answer == 2) {
//				Admin(input);
			} else if (answer == 3) {
				Borrower(input);
			} else {
				System.out.println("Invalid choice. Please pick 1, 2 or 3!");
			}
			System.out.println(" ------------------ BACK TO MAIN MENU ----------------");
		}
		
	}
}
