/**
 * 
 */
package com.ss.assignment.weekone.daythree.listdir;

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
		// Get input file and print out content of file
		Scanner input = new Scanner(System.in);
		System.out.print("Enter file path: ");
		String directoryPath = input.nextLine();
		
		DirectoryLister lister = new DirectoryLister(directoryPath);
		lister.print();
		
		input.close();
	}

}
