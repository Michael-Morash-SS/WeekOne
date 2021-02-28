/**
 * 
 */
package com.ss.assignment.weekone.dayfour;

/**
 * @author Michael
 * Consumes contents from buffer
 */
public class Consumer implements Runnable {
	private BoundedBuffer<Integer> buffer;
	private Integer id;
	private Integer cumulativeSum = 0;
	private boolean isActive = true;
	
	public Consumer(Integer id, BoundedBuffer<Integer> buffer) {
		this.id = id;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// Consumes from buffer and prints sum
		while (isActive) {
			try {
				cumulativeSum += buffer.remove();
				System.out.println("Consumer " + id.toString() + " Sum: " + cumulativeSum.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void interrupt() {
		this.isActive = false;
	}
}
