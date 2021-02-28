/**
 * 
 */
package com.ss.assignments.weekone.dayfour.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ss.assignments.weekone.dayfour.Line;

import junit.framework.TestCase;

/**
 * @author Michael
 *
 */
class LineTest extends TestCase {
	
	@Test
	void testGetSlope() {
		Line slopeNoError = new Line(0, 0, 1, 1);
		Line slopeWithError = new Line(0,0,0,1);
		
		assertEquals(1.0, slopeNoError.getSlope());
		Assertions.assertThrows(ArithmeticException.class, slopeWithError::getSlope);
	}

	@Test
	void testGetDistance() {
		Line line = new Line(0,0,3,4);
		
		assertEquals(5.0, line.getDistance());
	}
	
	@Test
	void testParralelTo() {
		Line standard = new Line(0,0,1,1);
		Line parellel = new Line(-1,-1,0,0);
		Line notParellel = new Line(1,-1,0,0);
		
		assertTrue(standard.parallelTo(parellel));
		assertFalse(standard.parallelTo(notParellel));
	}
}
