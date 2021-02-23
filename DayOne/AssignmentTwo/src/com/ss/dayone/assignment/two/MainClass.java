/**
 * 
 */
package com.ss.dayone.assignment.two;

import java.util.Random;
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
		// Coin flip game
		Scanner inputScanner = new Scanner(System.in);
		
		Random rng = new Random();
		int randomNumber = rng.nextInt(100);
		int userInput = 0;
		
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter a number: ");
			userInput = inputScanner.nextInt();
			
			if (randomNumber - 10 <= userInput && randomNumber + 10 >= userInput) {
				System.out.println("Correct. The number is " + Integer.toString(randomNumber));	
				return;
			} else if (i < 4) {
				System.out.println("Sorry. Try again.");
			}
		}
		
		System.out.println("Sorry. The correct number is " + Integer.toString(randomNumber));
	}

}
