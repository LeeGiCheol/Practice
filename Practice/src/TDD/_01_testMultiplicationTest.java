package TDD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



class _01_testMultiplicationTest {

	@Test
	public void sumTest() {
		int sum = 1 + 1;
		assertEquals(2, sum);
	}
	
	
	@Test
	public void testSum() {
		Calculator c = new Calculator();
		double result = c.sum(10, 50);
		assertEquals(60, result, 0);
	}
	
}



