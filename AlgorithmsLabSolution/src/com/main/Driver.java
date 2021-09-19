package com.main;

import java.util.Scanner;

import com.service.CurrencyService;
import com.service.MergeSort;
import com.service.TransactionService;

/**
 * @author AnubhavChaturvedi
 * @category AlgorithmsLabSolution
 * @date 2021-09-19
 */

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lScanner = new Scanner(System.in);
		int lChoice = -1;

		do {
			System.out.print("\nPlease enter the Problem Statement from the following \n"
					+ "1. Question 1 (Transaction Service) \n" + "2. Question 2 (Currency Service) \n"
					+ "\nPress 0 to Exit \n");

			lChoice = lScanner.nextInt();
			switch (lChoice) {

			// Exit the program
			case 0: {
				break;
			}

			// Question 1 (Transaction Service)
			case 1: {
				System.out.println("\n*****Welcome to Transaction Service*****\n");
				int sizeOfTransactions = 0, noOfTargets, target, output;

				System.out.println("Enter the size of transaction array: ");
				while (sizeOfTransactions <= 0) {
					sizeOfTransactions = lScanner.nextInt();
					if (sizeOfTransactions <= 0)
						System.out.println("Array size cannot be negative or zero."
								+ "\nEnter again the size of transaction array: ");
				}
				int[] transactions = new int[sizeOfTransactions];

				System.out.println("Enter the values of array: ");
				for (int i = 0; i < sizeOfTransactions; i++) {
					int checkInput = lScanner.nextInt();
					if (checkInput > 0)
						transactions[i] = checkInput;
					else {
						System.out.println("Transaction value cannot be negative or zero." + "\nEnter Transaction "
								+ ((i--) + 1) + " value again");
					}
				}

				System.out.println("Enter the total no of targets that needs to be achieved: ");
				noOfTargets = lScanner.nextInt();

				while (noOfTargets != 0) {
					System.out.println("Enter the value of target: ");
					target = lScanner.nextInt();
					output = new TransactionService(transactions, target).checkTarget();

					if (output <= 0)
						System.out.println("Given target is not achieved.");
					else
						System.out.println("Target achieved after " + output + " transaction(s).");

					noOfTargets--;
				}
			}
				break;

			// Question 2 (Currency Service)
			case 2: {
				System.out.println("\n*****Welcome to Currency Service*****\n");
				int sizeOfCurencyDenominations = 0, amount;

				System.out.println("Enter the size of currency denomination(s): ");
				while (sizeOfCurencyDenominations <= 0) {
					sizeOfCurencyDenominations = lScanner.nextInt();
					if (sizeOfCurencyDenominations <= 0)
						System.out.println("Array size cannot be negative or zero."
								+ "\nEnter again the size of currency denominations: ");
				}
				int[] currencies = new int[sizeOfCurencyDenominations];
				int[] output = new int[sizeOfCurencyDenominations];

				System.out.println("Enter the currency denomination(s) value: ");
				for (int i = 0; i < sizeOfCurencyDenominations; i++) {
					int checkInput = lScanner.nextInt();
					if (checkInput > 0)
						currencies[i] = checkInput;
					else {
						System.out.println("Currency value cannot be negative or zero." + "\nEnter Currency "
								+ ((i--) + 1) + " denomination again");
					}
				}

				System.out.println("Enter the amount you want to pay: ");
				amount = lScanner.nextInt();
				currencies = new MergeSort().getSortedArray(currencies);
				output = new CurrencyService(currencies).checkAmount(amount);

				if (output != null) {
					System.out.println("Your payment approach in order to give min no of note(s) will be.");
					for (int i = 0; i < output.length; i++) {
						if (output[i] > 0) {
							System.out.println(currencies[i] + " : " + output[i]);
						}
					}
				} else
					System.out.println("Given amount can not be paid through input denomination(s).");
			}
				break;

			default:
				System.out.println("Invalid choice. Enter a valid no.");
			}
		} while (lChoice != 0);
		System.out.println("You are done with your work");
		lScanner.close();
	}
}
