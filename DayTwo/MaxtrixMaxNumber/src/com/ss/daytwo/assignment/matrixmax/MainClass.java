package com.ss.daytwo.assignment.matrixmax;
import java.util.Random;

/**
 * 
 */

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Generates a matrix and finds the max number contained in it
		// Expects two integers inputs for row and column count, defaults them to 5 if not present
		Random rng = new Random();
		
		int matrixRowCount = 5;
		int matrixColumnCount = 5;
		
		if (args.length >= 1) {
			matrixRowCount = Integer.parseInt(args[0]);
		} 
		
		if (args.length >= 2) {
			matrixColumnCount = Integer.parseInt(args[1]);
		}
		
		int[][] matrix = new int[matrixRowCount][matrixColumnCount];
		
		int maxNumberRow = 0;
		int maxNumberColumn = 0;
		
		//Initialize randomized matrix and print to console
		StringBuffer printOutput = null;
		
		for (int rowIteration = 0; rowIteration < matrixRowCount; rowIteration++) {
			printOutput = new StringBuffer("[ ");
			for (int columnIteration = 0; columnIteration < matrixColumnCount; columnIteration++) {
				matrix[rowIteration][columnIteration] = rng.nextInt(100);
				printOutput.append(matrix[rowIteration][columnIteration]).append(" ");
			}
			printOutput.append("]");
			System.out.println(printOutput.toString());
		}
		
		//Find maximum and print position and value to console
		for (int rowIteration = 0; rowIteration < matrixRowCount; rowIteration++) {
			for (int columnIteration = 0; columnIteration < matrixColumnCount; columnIteration++) {
				if (matrix[rowIteration][columnIteration] > matrix[maxNumberRow][maxNumberColumn]) {
					maxNumberRow = rowIteration;
					maxNumberColumn = columnIteration;
				}
			}
		}
		
		printOutput = new StringBuffer("Maximum value: ").append(matrix[maxNumberRow][maxNumberColumn])
				.append("     Position: ").append(maxNumberRow).append(", ").append(maxNumberColumn);
		System.out.println(printOutput.toString());
	}

}
