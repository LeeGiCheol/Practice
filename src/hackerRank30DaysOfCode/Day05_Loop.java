/*
	Objective
	In this challenge, we're going to use loops to help us do some simple math. Check out the Tutorial tab to learn more.
	
	Task
	Given an integer, n, print its first 10 multiples. Each multiple n x i (where 1 <= i <= 10) should be printed on a new line in the form: n x i = result.
	
	Input Format
	
	A single integer, n.
	
	Constraints
	2 <= n <= 20
	
	Output Format
	
	Print  lines of output; each line i (where 1 <= i <= 10) contains the result of n x i in the form:
	n x i = result.
	
	Sample Input
	
	2
	Sample Output
	
	2 x 1 = 2
	2 x 2 = 4
	2 x 3 = 6
	2 x 4 = 8
	2 x 5 = 10
	2 x 6 = 12
	2 x 7 = 14
	2 x 8 = 16
	2 x 9 = 18
	2 x 10 = 20
	
	-- 풀이 --
	오늘 문제는 대충봐도 구구단 문제로 보였다.
	문장도 짧은 편이여서 술술 읽히는 편이였다.
	
	처음에 n을 입력하면 n x i = result 의 형태로 10개의 곱셈을 하고,
	개행을 해서 출력하라 (on a new line in the form)
	
	그렇기 때문에 아무래도 구구단은 printf 함수를 사용하는 것이 편하다 생각해서
	사용하게 되었고, printf는 개행을 따로 하지 않기 때문에 \n으로 개행을 해주었다.
	
	오늘은 굉장히 간단하게 풀이가 완료되었다.
	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day05_Loop {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d\n", n, i, n * i);
		}

		scanner.close();
	}
}
