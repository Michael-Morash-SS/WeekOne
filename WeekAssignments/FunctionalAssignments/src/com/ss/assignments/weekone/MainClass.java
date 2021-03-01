/**
 * 
 */
package com.ss.assignments.weekone;

import java.util.ArrayList;

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Print out the results from the functions
		int[] input = {16, 8, 886, 8, 1};
		int[] rightDigitOutput = rightDigit(input);
		int[] multiplyOutput = multiplyByTwo(input);
		
		String[] noXInput = {"xxax", "xbxbx", "xxcx"};
		String[] noXOutput = removeX(noXInput);
		
		System.out.println(intArrayToString(rightDigitOutput));
		System.out.println(intArrayToString(multiplyOutput));
		System.out.println(stringArrayToString(noXOutput));
	}

	public static int[] rightDigit(int[] input) {
		// Return an array of the right most digits
		int [] output = new int[input.length];
		
		for (int i = 0; i < input.length; i++) {
			output[i] = input[i] % 10;
		}
		
		return output;
	}
	
	public static int[] multiplyByTwo(int[] input) {
		// Return an array of the input * 2
		int[] output = new int[input.length];
		
		for (int i = 0; i < input.length; i++) {
			output[i] = input[i] * 2;
		}
		
		return output;
	}
	
	public static String[] removeX(String[] input) {
		String[] output = new String[input.length];
		StringBuilder outputBuilder;
		
		for (int i = 0; i < input.length; i++) {
			outputBuilder = new StringBuilder();
			
			for (int j = 0; j < input[i].length(); j++) {
				if (input[i].charAt(j) != 'x') {
					outputBuilder.append(input[i].charAt(j));
				}
			}
			
			output[i] = outputBuilder.toString();
		}
		
		return output;
	}
	
	public static String intArrayToString(int[] input) {
		//Converts an array of ints to a String
		StringBuffer output = new StringBuffer("[ ");
		
		if (input.length > 0) {
			output.append(input[0]);
			
			for (int i = 1; i < input.length; i++) {
				output.append(", ").append(input[i]);
			}
		}
		
		output.append(" ]");
		
		return output.toString();
	}
	
	public static String stringArrayToString(String[] input) {
		//Converts an array of strings to a single string
		StringBuffer output = new StringBuffer("[ ");
		
		if (input.length > 0) {
			output.append("\"").append(input[0]).append("\"");
			
			for (int i = 1; i < input.length; i++) {
				output.append(", \"").append(input[i]).append("\"");
			}
		}
		
		output.append(" ]");
		return output.toString();
	}
}
