/**
 * 
 */
package com.ss.assignment.weekone.dayfour;

import java.util.Random;

/**
 * @author Michael
 *
 */
public class Producer implements Runnable {
	//Creates contents for a buffer
	private BoundedBuffer<Integer> buffer;
	private Integer id;
	private boolean isActive = true;
	
	public Producer(Integer id, BoundedBuffer<Integer> buffer) {
		this.id = id;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		Random rng = new Random();
		Integer nextInt;
		
		while (isActive) {
			nextInt = rng.nextInt(100);
			try {
				buffer.insert(nextInt);
				System.out.println("Producer " + id + " Added: " + nextInt);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void interrupt() {
		this.isActive = false;
	}
}
