/**
 * 
 */
package com.ss.assignment.weekone.dayfour;

import java.util.Scanner;

/**
 * @author Michael
 *
 */
public class MainClass {
	public static void main(String[] args) {
		//Generate and run producers and consumers
		Scanner input = new Scanner(System.in);
		System.out.print("Producer count: ");
		Integer producerCount = input.nextInt();
		System.out.print("Consumer count: ");
		Integer consumerCount = input.nextInt();
		
		BoundedBuffer<Integer> buffer = new BoundedBuffer<>(10);
		
		for (int i = 0; i < producerCount; i++) {
			new Thread(new Producer(i, buffer)).start();
		}

		for (int i = 0; i < consumerCount; i++) {
			new Thread(new Consumer(i, buffer)).start();
		}
	}
}
