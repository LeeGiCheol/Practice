package regularExpression;

import java.util.regex.Pattern;

public class _03_RegularExpressionExample {
	public static void main(String[] args) {
		String name = "이기철";
		String tel = "010-1234-5678";
		String email = "leegicheolgc@gamil.com";
		
		// 유효성 검사
		// 가-힣 (한글 모두) * 무한정 가능 
		boolean nameCheck = Pattern.matches("^[가-힣]*$", name);
		// 01로 시작 3번째로는 ()으로 하나의 문자로 인식하게 함. 0 or 1 or 6~9 사이 숫자가 올 수있다.
		// 4번째는 - 다음은 다시 () 으로 하나의 문자로 인식하게 함 다음은 숫자 3개 or 4개 가 올 수 있고 - 4개의 숫자를 받고 $로 종료
		// 말로 풀려고 하니까 굉장히 이상하다.
		boolean telCheck = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", tel);
		// 이메일은 해석이 잘 안된다.
		// \w는 알파벳이나 숫자를 의미하고 @ 그리고 . (\\.\\w+)이부분은 com net 등등을 의미한다.
		boolean emailCheck = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);
		
		
		System.out.println("이름 : " + nameCheck);
		System.out.println("전화번호 : " + telCheck);
		System.out.println("이메일 : " + emailCheck);
	}
}
