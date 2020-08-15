package TDD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class _01_testMultiplicationTest {

	@Test
	public void sumTest() {
		int sum = 1 + 1;
		assertEquals(2, sum);
	}
	
	
	@Test
	public void testSum() {
		Calcurator c = new Calcurator();
		double result = c.sum(10, 50);
		assertEquals(60, result, 0);
	}
	
}



