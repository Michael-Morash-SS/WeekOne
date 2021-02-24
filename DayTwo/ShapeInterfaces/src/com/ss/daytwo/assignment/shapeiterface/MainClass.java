/**
 * 
 */
package com.ss.daytwo.assignment.shapeiterface;

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Demonstrate shape interface
		Rectangle rectangle = new Rectangle(5.0, 4.0);
		Circle circle = new Circle(3.5);
		Triangle triangle = new Triangle(2.0, 3.0);
		
		IShape shape = rectangle;
		System.out.println("Area: " + shape.calculateArea());
		shape.display();
		
		shape = circle;
		System.out.println("Area: " + shape.calculateArea());
		shape.display();
		
		shape = triangle;
		System.out.println("Area: " + shape.calculateArea());
		shape.display();
	}

}
