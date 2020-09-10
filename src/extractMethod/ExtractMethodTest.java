/*
	extractMethod 메서드 추출 단축키이다.
	오늘 처음 알게되서 너무 놀라운 기능이다..
	해당 코드를 드래그 후 command(windows에선 ctrl) + option + m 을 누르면
	알맞는 메서드를 만들어준다. (커스텀가능)
	
	사실 별거 아닌듯한 기능이지만,	클린코드, 리팩토링을 하기 매우 좋아보인다.
 */

package extractMethod;

public class ExtractMethodTest {
	public static void main(String[] args) {
		int a = 5;
		int b = 5;
		extracted(a, b);
		
	}

	private static void extracted(int a, int b) {
		int sum = a + b;
	}
}
