import static org.junit.Assert.*;

import org.junit.Test;

public class TestFile {

	@Test
	public void test() {
		Complex com1 = new Complex(4.5, 50);
		Complex com2 = new Complex(3.0, 23.4);
		Complex com0 = new Complex(0, 0);
		Complex result;
		
		//test addition
		result = com1.add(com2);
		assertEquals("7.50 + 73.40i", result.toString());
		//test subtraction
		result = com1.sub(com2);
		assertEquals("1.50 + 26.60i", result.toString());
		//test multiplication
		result = com1.mult(com2);
		assertEquals("-1156.50 + 255.30i", result.toString());
		//test division
		result = com1.div(com2);
		assertEquals("2.13 + 0.08i", result.toString());
		//test divide by zero
		result = com1.div(com0);
		assertEquals("Not Valid", result.toString());
	}

}
