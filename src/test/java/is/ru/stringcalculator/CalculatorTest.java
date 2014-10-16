package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	
	@Test
	public void testOneNumber2() {
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	
	
	@Test
	public void testTwoNumbers2() {
		assertEquals(5, Calculator.add("4,1"));
	}

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	
	@Test
	public void testMultipleNumbers2() {
		assertEquals(10, Calculator.add("6,1,3"));
	}
	
	@Test
	public void testMultipleNumbers3() {
		assertEquals(15, Calculator.add("5,2,3,1,4"));
	}
	
	@Test 
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	
	@Test 
	public void testNewLine2() {
		assertEquals(5, Calculator.add("1\n2\n2"));
	}
	
	@Test 
	public void testNewLine3() {
		assertEquals(6, Calculator.add("2,2\n2"));
	}
	
	@Test 
	public void testDifferentDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test 
	public void testDifferentDelimiter2() {
		assertEquals(10, Calculator.add("//}\n1}2}3}4"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSingleNegativeNumber() {
		Calculator.add("-1,-2,-3");
	}
	
	@Test 
	public void testBigNumberes() {
		assertEquals(3, Calculator.add("1,1001,2"));
	}
	
	@Test 
	public void testBigNumberes2() {
		assertEquals(3, Calculator.add("1,1001,2,1005"));
	}
	
	@Test 
	public void testLongDelimiters() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	
	@Test 
	public void testLongDelimiters2() {
		assertEquals(6, Calculator.add("//[|||]\n1|||2|||3"));
	}
	
	@Test 
	public void testMultipleDelimiters() {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}
	
}