package regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_RegularExpressionExample {
	public static void main(String[] args) {
		// 영문자만
		// ^으로 패턴시작 [a-zA-Z] 소문자 a-z 대문자 A-Z까지 (모든 알파벳 허용) * 무한정 올 수 있다. $로 패턴 종료
		Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
		
		// 대상 문자열
		String val = "abcdef";
		String val2 = "123456789";
		
		Matcher matcher = pattern.matcher(val);
		Matcher matcher2 = pattern.matcher(val2);

		// true
		System.out.println(matcher.find());
		
		// false
		System.out.println(matcher2.find());
	}
}
