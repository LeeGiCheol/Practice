/*
	Given When Then은 테스트코드의 라이프 사이클을 정해놓은 영역 구분이다.
	Given (테스트할 준비), When (테스트할 대상 실행), Then (검증)의 패턴이다.
 */

package TDD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class GivenWhenThen {
	
	@Test
	public void plus() throws Exception {
		// Given
		Calculator calculator = new Calculator();
		
		// When
		double result = calculator.sum(2.0, 5.0);
		
		// Then
		assertEquals(7,result);
	}
	
}
