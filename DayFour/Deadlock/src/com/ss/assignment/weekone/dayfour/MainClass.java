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
		// Start two threads with the intention of creating a deadlock
		Integer resourceOne = 5;
		Integer resourceTwo = 10;
		
		Thread t1 = new Thread(new BadThread(resourceOne, resourceTwo));
		Thread t2 = new Thread(new BadThread(resourceTwo, resourceOne));
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(5000);
			
			if (t1.isAlive() && t2.isAlive()) {
				System.out.println("Deadlock created");
			} else {
				System.out.println("Deadlock failed");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static class BadThread implements Runnable {
		private Integer resourceOne;
		private Integer resourceTwo;

		public BadThread(Integer resourceOne, Integer resourceTwo) {
			this.resourceOne = resourceOne;
			this.resourceTwo = resourceTwo;
		}
		
		@Override
		public void run() {
			// Get resourceOne, sleep than get resourceTwo;
			synchronized (resourceOne) {
				try {
					resourceOne += 1;
					Thread.sleep(100);
					synchronized (resourceTwo) {
						resourceTwo += resourceOne;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
