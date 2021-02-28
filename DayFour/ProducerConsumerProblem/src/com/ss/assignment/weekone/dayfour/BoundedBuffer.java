/**
 * 
 */
package com.ss.assignment.weekone.dayfour;

import java.util.ArrayList;

/**
 * @author Michael
 * Buffer that stalls inserting and reading based on the availability of space
 */
public class BoundedBuffer<T> {
	private volatile ArrayList<T> buffer;
	private int max_size;
	
	public BoundedBuffer(int max_size) {
		this.max_size = max_size;
		this.buffer = new ArrayList<>(max_size);
	}
	
	public synchronized void insert(T object) throws InterruptedException {
		while (buffer.size() == max_size) {
			Thread.sleep(10);
		}
		
		synchronized(buffer) {
			buffer.add(object);
		}
	}
	
	public synchronized T remove() throws InterruptedException {
		while (buffer.size() == 0) {
			Thread.sleep(10);
		}
		
		synchronized(buffer) {
			return buffer.remove(0);
		}
	}
}
