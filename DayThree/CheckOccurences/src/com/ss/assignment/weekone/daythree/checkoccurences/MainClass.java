/**
 * 
 */
package com.ss.assignment.weekone.daythree.checkoccurences;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		// Read file and count occurrences of a pattern
		Scanner input = new Scanner(System.in);
		int occuranceCount = 0;
		
		System.out.print("File: ");
		String filePath = input.nextLine();
		System.out.print("Pattern: ");
		String pattern = input.nextLine();
		PatternMatchStateMachine matcher = new PatternMatchStateMachine(pattern);
		
		BufferedReader fileReader = null;
		String fileLine = null;

		try {
			fileReader = new BufferedReader(new FileReader(filePath));
			fileLine = fileReader.readLine();
			
			while (fileLine != null) {
				occuranceCount += getOccurenceCount(fileLine, matcher);
				
				fileLine = fileReader.readLine();
			}
			
			System.out.println("Occurences of pattern: " + occuranceCount);
		} catch (FileNotFoundException e) {
			System.out.println("File " + filePath + " not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		input.close();
	}
	
	public static int getOccurenceCount(String input, PatternMatchStateMachine patternMatcher) {
		boolean isMatched = false;
		int occurenceCount = 0;
		
		patternMatcher.setState(0);
		
		for (int i = 0; i < input.length(); i++) {
			isMatched = patternMatcher.step(input.charAt(i));
			
			if (isMatched) {
				occurenceCount += 1;
				patternMatcher.setState(0);
			}
		}
		
		return occurenceCount;
	}

}
