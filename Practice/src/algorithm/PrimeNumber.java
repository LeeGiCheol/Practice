/*

	---에라토스테네스의 체---
	소수찾기 문제를 풀이해봤는데, 풀진 못했다.
	검색을 하다보니 에라토스테네스의 체 라는 공식? 을 보게되었는데
	굉장히 간단하게 풀이할 수 있었다.
	
	2의 배수부터 순차적으로 값을 지워서 걸러내기때문에 체라고 부르는것같다.
	중간중간 이미 걸러진 수의 배수는 따로 확인하지 않기 때문에
	속도도 잘 나오는 것 같다.
	
 */

package algorithm;

import java.util.Scanner;

public class PrimeNumber {
	public static int solution(int n) {
		
		int answer = 0;
		
		int[] number = new int[n + 1];
		
		// 2부터 모든 수를 담는다
		for (int i = 2; i <= n; i++) {
			number[i] = i;
		}
		
		// 2부터 그의 배수를 0으로 만든다
		for (int i = 2; i <= n; i++) {
			if(number[i] == 0)
				continue;
			
			for (int j = 2*i; j <= n; j+=i) {
				number[j] = 0;
			}
		}
		
		// 0이 아닌 것들의 개수를 센다
		for (int i = 0; i < n; i++) {
			if(number[i] != 0)
				answer++;
		}
		
		return answer;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		
		System.out.println(solution(num));
		
	}
}
