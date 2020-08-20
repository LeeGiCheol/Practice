/*
	값의 의한 호출
	원본값이 변하지 않는다.
	
	swap 메서드의 매개변수인 x, y와
	swap 메서드를 호출 시 사용한 인자 a, b는 다르기 때문
	
	출처 - https://re-build.tistory.com/3
 */


package callBy;

import java.util.HashMap;
import java.util.Map;

public class CallByValue {
	public static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		System.out.println("swap() 호출 전 : a = " + a + ", b = " + b);
		
		swap(a, b);
		
		System.out.println("swap() 호출 후 : a = " + a + ", b = " + b);

	}
}
