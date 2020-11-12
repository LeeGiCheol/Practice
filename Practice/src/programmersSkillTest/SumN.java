// 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
// 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
//
// 제한사항
// N의 범위 : 100,000,000 이하의 자연수

package programmersSkillTest;

public class SumN {

	static int solution(int N) {
		int sum = 0;
		
		int num = 0;
		
		
		while(true) {
			if(N <= 0)
				break;
			
			num = N % 10;
			sum += num;
			N /= 10;
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		System.out.println(solution(127));
	}
}
