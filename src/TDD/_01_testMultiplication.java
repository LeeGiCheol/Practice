package TDD;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class _01_testMultiplication {
	@Test
	public static void main(String[] args) {
		
	Dollar five = new Dollar(5);

	five.times(2);

	assertEquals(10, five.amount);
	}
}
