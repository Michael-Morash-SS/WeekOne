/**
 * 
 */
package com.ss.dayone.assignment.one;

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Prints to the console
		int i = 0;
		int j = 0;
		String output = "";
		
		System.out.println("1)");
		for (i = 1; i <= 4; i++) {
			output = "";
			
			for (j = 0; j < i; j++) {
				output = output + "*";
			}
			
			System.out.println(output);
		}
		System.out.println(".........");
		System.out.println();
		
		System.out.println("2)");
		System.out.println("..........");
		for (i = 4; i >= 1; i--) {
			output = "";
			
			for (j = 0; j < i; j++) {
				output = output + "*";
			}
			
			System.out.println(output);
		}
		System.out.println();
		
		System.out.println("3)");
		for (i = 1; i <= 4; i++) {
			output = "  ";
			
			for (j = 0; j < 4 - i; j++) {
				output += " ";
			}
			
			output += "*";
			
			for (j = 1; j < i; j++) {
				output += "**";
			}
			
			System.out.println(output);
		}
		System.out.println("...........");
		System.out.println();
		
		System.out.println("4)");
		System.out.println("............");
		for (i = 4; i >= 1; i--) {
			output = "  ";
			
			for (j = 0; j < 4 - i; j++) {
				output += " ";
			}
			
			output += "*";
			
			for (j = 1; j < i; j++) {
				output += "**";
			}
			
			System.out.println(output);
		}
		System.out.println();
	}

}
