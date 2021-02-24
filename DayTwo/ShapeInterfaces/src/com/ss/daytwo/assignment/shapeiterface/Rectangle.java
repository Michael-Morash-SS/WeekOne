/**
 * 
 */
package com.ss.daytwo.assignment.shapeiterface;

/**
 * @author Michael
 *
 */
public class Rectangle implements IShape {
	private double height;
	private double width;

	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return height * width;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle[width = " + width + "; height = " + height + "]");
	}

}
