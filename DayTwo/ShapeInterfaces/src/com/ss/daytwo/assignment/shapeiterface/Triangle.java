/**
 * 
 */
package com.ss.daytwo.assignment.shapeiterface;

/**
 * @author Michael
 *
 */
public class Triangle implements IShape {
	private double width;
	private double height;

	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return width * height / 2;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Triangle[width = " + width + "; height = " + height + "]");
	}

}
