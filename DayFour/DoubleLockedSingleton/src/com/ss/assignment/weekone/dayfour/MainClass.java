/**
 * 
 */
package com.ss.assignment.weekone.dayfour;

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Demonstrate double locked singleton by running multiple threads to get and print the object
		SingletonRunThread t1 = new SingletonRunThread();
		SingletonRunThread t2 = new SingletonRunThread();
		SingletonRunThread t3 = new SingletonRunThread();
		SingletonRunThread t4 = new SingletonRunThread();
		SingletonRunThread t5 = new SingletonRunThread();
		
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		new Thread(t4).start();
		new Thread(t5).start();
	}
	
	private static class SingletonRunThread implements Runnable {

		@Override
		public void run() {
			DoubleLockedSingleton singleton = DoubleLockedSingleton.getInstance();
			System.out.println(singleton);
		}
		
	}
}
