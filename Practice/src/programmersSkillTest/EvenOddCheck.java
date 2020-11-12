// 정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.


package programmersSkillTest;

public class EvenOddCheck {

	public static String solution(int n) {

		String answer = "";
		
		if(n % 2 == 0)
			return answer = "Even";
		else
			return answer = "Odd";
	}
	
	public static void main(String[] args) {
		System.out.println(solution(155));
	}
}
