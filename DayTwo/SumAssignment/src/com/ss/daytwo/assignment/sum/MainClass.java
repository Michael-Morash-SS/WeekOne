/**
 * 
 */
package com.ss.daytwo.assignment.sum;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Gets input from command line and computes sum
		double sum = 0.0;
		String continueInputting = "y";
		Scanner input = new Scanner(System.in);
		StringBuffer errorOutput = null;
		StringBuffer output = new StringBuffer("Sum: ");

		do {
			try {
				System.out.print("Input a number: ");
				sum += input.nextDouble();
			} catch (InputMismatchException e) {
				errorOutput = new StringBuffer("Error reading non-numeric input: ");
				errorOutput.append(input.next());
				System.out.println(errorOutput.toString());
			}
			
			do {
				System.out.print("Continue input (y/n): ");
				continueInputting = input.next().toLowerCase();
			} while (!continueInputting.equals("y") && !continueInputting.equals("n"));
		} while (continueInputting.equals("y"));
		
		System.out.println(output.append(sum).toString());
	}

}
