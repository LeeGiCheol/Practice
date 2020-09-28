/*
 
	^ 문자열 시작
	$ 문자열 종료
	. 임의의 한 문자 (\(역슬래시)는 넣을 수 없음)
	* 앞 문자가 없을 수도 무한정 많을 수도 있음
	+ 앞 문자가 하나 이상
	? 앞 문자가 없거나 하나 있음
	[] 문자의 집합이나 범위를 나타내며 두 문자 사이는 - 기호로 범위를 나타낸다.
		[] 내에서 ^가 선행하여 존재하면 not
	{} 횟수 또는 범위를 나타낸다
	() 소괄호 안의 문자를 하나의 문자로 인식
	| 패턴 안에서 or 연산을 수행할 때 사용
	\ 확장문자 (역슬래시 다음에 일반 문자가 오면 특수문자로 취급하고 역슬래시 다음에 특수문자가 오면 그 문자 자체를 의미)
	\b 단어의 경계
	\B 단어가 아닌것에 대한 경계
	\A 입력의 시작 부분
	\G 이전 매치의 끝
	\Z 입력의 끝이지만 종결자가 있는 경우
	\z 입력의 끝
	\s 공백 문자
	\S 공백 문자가 아닌 나머지 문자
	\w 알파벳이나 숫자
	\W 알파벳이나 숫자를 제외한 문자
	\d 숫자[0-9]와 동일
	\D 숫자를 제외한 모든 문자
	(?i) 대소문자를 구분하지 않는다
	
	- 출처 https://coding-factory.tistory.com/529

 */

package regularExpression;

import java.util.regex.Pattern;

public class _01_RegularExpressionExample {
	public static void main(String[] args) {
		// 숫자만
		// ^으로 패턴 시작을 알리고 [0-9]는 0~9 사이의 숫자 *는 글자 수가 많을 수 있다. $로 패턴종료 
		String pattern = "^[0-9]*$";
		
		// 대상 문자열
		String val = "123456789";
		String val2 = "abcdefg";
		
		boolean regex = Pattern.matches(pattern, val);
		boolean regex2 = Pattern.matches(pattern, val2);
		
		// true
		System.out.println(regex);
		
		// false
		System.out.println(regex2);
		
	}
}
