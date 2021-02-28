/**
 * 
 */
package com.ss.assignment.weekone.dayfour;

/**
 * @author Michael
 *
 */
public class DoubleLockedSingleton {
	private static volatile DoubleLockedSingleton instance;
	
	protected DoubleLockedSingleton() {};
	
	public static DoubleLockedSingleton getInstance() {
		//Get the instance for the singleton class
		
		//Using local reference, apparently improves execution time by accessing volatile field once when
		//instance is initialized
		DoubleLockedSingleton localRef = instance;
		
		if (localRef == null) {
			synchronized (DoubleLockedSingleton.class) {
				localRef = instance;
				if (localRef == null) {
					instance = new DoubleLockedSingleton();
					localRef = instance;
				}
			}
		}
		
		return instance;
	}
}
