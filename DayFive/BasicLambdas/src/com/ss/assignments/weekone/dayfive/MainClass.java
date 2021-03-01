/**
 * 
 */
package com.ss.assignments.weekone.dayfive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Demonstrate lambdas by sorting
		ArrayList<String> testArray = new ArrayList<>();
		testArray.add("abce");
		testArray.add("ibhd");
		testArray.add("pieai");
		testArray.add("fiaj");
		testArray.add("faaj");
		testArray.add("tpeis");
		testArray.add("add");
		testArray.add("ade");
		
		Stream<String> sortAlphabetical = testArray.stream().sorted((s1, s2) -> s1.compareTo(s2));
		List<String> alphabeticalOutput = sortAlphabetical.collect(Collectors.toList());
		printStringArray(alphabeticalOutput);
		
		Stream<String> sortReverseAlphabetical = testArray.stream().sorted((s1, s2) -> s2.compareTo(s1));
		List<String> reverseAlphabeticalOutput = sortReverseAlphabetical.collect(Collectors.toList());
		printStringArray(reverseAlphabeticalOutput);
		
		Stream<String> sortFirstLetter = testArray.stream().sorted((s1, s2) -> s1.charAt(0) - s2.charAt(0));
		List<String> sortFirstLetterOutput = sortFirstLetter.collect(Collectors.toList());
		printStringArray(sortFirstLetterOutput);
		
		Stream<String> sortEFirst = testArray.stream().sorted((s1, s2) -> {
			if (s1.contains("e")) {
				return -1;
			} else if (s2.contains("e")) {
				return 1;
			}
			
			return 0;
		});
		List<String> sortEFirstOutput = sortEFirst.collect(Collectors.toList());
		printStringArray(sortEFirstOutput);

		Stream<String> sortEFirstWithHelper = testArray.stream().sorted((s1, s2) -> sortEFirstHelper(s1, s2));
		List<String> sortEFirstWithHelperOutput = sortEFirstWithHelper.collect(Collectors.toList());
		printStringArray(sortEFirstWithHelperOutput);
		
		Integer[] intList = {1, 3, 4, 8, 10};
		printIntegerList(Arrays.asList(intList));
		
		printStringArray(filterStartsWithAAndThreeCharacters(testArray));
	}
	
	public static int sortEFirstHelper(String s1, String s2) {
		if (s1.contains("e")) {
			return -1;
		} else if (s2.contains("e")) {
			return 1;
		}
		
		return 0;
	}
	
	public static List<String> filterStartsWithAAndThreeCharacters(List<String> input) {
		Stream<String> filterStream = input.stream().filter((s) -> s.startsWith("a") && s.length() == 3);
		return filterStream.collect(Collectors.toList());
	}
	
	public static void printStringArray(List<String> array) {
		StringBuffer output = new StringBuffer("[ ");
		
		if (array.size() > 0) {
			output.append("\"").append(array.get(0)).append("\"");
			
			for (int i = 1; i < array.size(); i++) {
				output.append(", \"").append(array.get(i)).append("\"");
			}
		}
		
		output.append(" ]");
		System.out.println(output.toString());
	}

	public static void printIntegerList(List<Integer> ints) {
		StringBuffer output = new StringBuffer("[ ");
		
		ints.forEach((i) -> {
			output.append(i % 2 == 0 ? "e" : "o").append(i).append(", ");
		});
		
		output.append(" ]");
		System.out.println(output.toString());
	}
}
