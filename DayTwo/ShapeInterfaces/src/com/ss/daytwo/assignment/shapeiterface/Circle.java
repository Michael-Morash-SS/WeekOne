/**
 * 
 */
package com.ss.daytwo.assignment.shapeiterface;

/**
 * @author Michael
 *
 */
public class Circle implements IShape {
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radius * radius;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Circle[radius = " + radius + "]");
	}

}
