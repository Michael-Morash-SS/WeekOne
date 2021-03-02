/**
 * 
 */
package com.ss.assignments.weekone;

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test groupSumClump
		
		int[] testOne = {2, 4, 8};
		int[] testTwo = {2, 4, 6, 8, 8};
		int[] testThree = {2, 4, 4, 8};
		
		System.out.println("testOne expects true; is " + groupSumClump(testOne, 10));
		System.out.println("testTwo expects true; is " + groupSumClump(testTwo, 20));
		System.out.println("testThree expects false; is " + groupSumClump(testThree, 14));
	}
	
	public static boolean groupSumClump(int[] array, int desiredSum) {
		//Convenience function for groupSumClump starting at index 0
		return groupSumClump(0, array, desiredSum);
	}
	
	public static boolean groupSumClump(int fromIndex, int[] array, int desiredSum) {
		//Find if possible to reach desired sum in array respecting clumps
		if (array.length <= fromIndex) {
			return false;
		}
		
		int count = 1;
		int indexCounter = fromIndex;
		
		while (indexCounter < array.length) {
			if (indexCounter + 1 < array.length && array[indexCounter] == array[indexCounter + 1]) {
				indexCounter += 1;
				count += 1;
				
				continue;
			}
			
			if (array[indexCounter] * count == desiredSum) {
				return true;
			} else if (groupSumClump(indexCounter + 1, array, desiredSum - array[indexCounter] * count)) {
				return true;
			}
			
			indexCounter += 1;
			count = 1;
		}
		
		return false;
	}

}
