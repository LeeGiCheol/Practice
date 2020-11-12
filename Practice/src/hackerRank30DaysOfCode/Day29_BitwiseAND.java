/*
	Objective
	Welcome to the last day! Today, we're discussing bitwise operations. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Given set S = {1, 2, 3 ... N}. Find two integers, A and B (where A < B ), from set S such that the value of A & B is the maximum possible and also less than a given integer, K. In this case, & represents the bitwise AND operator.
	
	Input Format
	
	The first line contains an integer, T, the number of test cases.
	Each of the T subsequent lines defines a test case as 2 space-separated integers, N and K, respectively.
	
	Constraints
	
	Output Format
	
	For each test case, print the maximum possible value of  on a new line.
	
	Sample Input
	
	3
	5 2
	8 5
	2 2
	Sample Output
	
	1
	4
	0
	
	
	---풀이---
	비트연산자 문제이다. 자바 공부하면서 유독 어렵고 힘들었던 부분이다. 아직도 어렵다.
	사실 문제 해석이 잘 안된다.
	
	ex) k=5; n=8;
	if (((k - 1) | k) <= n)
	숫자를 2진수로 변환해 양쪽 중 하나라도 1이면 1 둘다 0이라면 0이 된다.
	
	4는 2진수로 100이다. 5는 101이다. 두개를 비트 OR 연산자를 사용하면
	101으로 10진수 변환을 하면 5가된다.
	이 조건문은 True가 된다.
	
	한달간 열심히 풀었는데 마지막 문제를 제대로 못풀어서 아쉽다.
	다른 챌린지도 도전해 볼 예정이다. 
	
	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day29_BitwiseAND {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);

			if (((k - 1) | k) <= n)
				System.out.println(k - 1);
			else
				System.out.println(k - 2);
		}

		scanner.close();
	}
}
