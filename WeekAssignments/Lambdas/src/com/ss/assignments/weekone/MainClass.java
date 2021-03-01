package com.ss.assignments.weekone;

/**
 * @author Michael
 *
 */
public class MainClass {
	public static void main(String[] args) {
		//Demonstrate lambda functions
		PerformOperation odd = isOdd();
		PerformOperation prime = isPrime();
		PerformOperation pallindrome = isPallindrome();
		
		System.out.println("4 is " + (odd.execute(4) ? "Odd" : "Even"));
		System.out.println("5 is " + (prime.execute(5) ? "Prime" : "Not Prime" ));
		System.out.println("898 is " + (pallindrome.execute(898) ? "A Pallindrome" : "Not a Pallindrome"));
		System.out.println("3 is " + (odd.execute(3) ? "Odd" : "Even"));
		System.out.println("12 is " + (prime.execute(12) ? "Prime" : "Not Prime"));
	}
	
	public static PerformOperation isOdd() {
		return (x) -> x % 2 == 1;
	}
	
	public static PerformOperation isPrime() {
		return (x) -> {
			for (int i = 2; i < x / 2; i++) {
				if (x % i == 0) {
					return false;
				}
			}
			return true;
		};
	}
	
	public static PerformOperation isPallindrome() {
		return (x) -> {
			String strX = Integer.toString(x);
			
			for (int i = 0; i < strX.length() / 2; i++) {
				if (strX.charAt(i) != strX.charAt(strX.length() - i - 1)) {
					return false;
				}
			}
			
			return true;
		};
	}
}
