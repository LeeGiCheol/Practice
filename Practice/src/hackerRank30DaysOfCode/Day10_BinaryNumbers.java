/*
	Objective
	Today, we're working with binary numbers. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Given a base-10 integer, n, convert it to binary (base-2). Then find and print the base-10 integer denoting the maximum number of consecutive 1's in n's binary representation.
	
	Input Format
	
	A single integer, n.
	
	
	Output Format
	
	Print a single base-10 integer denoting the maximum number of consecutive 1's in the binary representation of n.
	
	Sample Input 1
	
	5
	Sample Output 1
	
	1
	Sample Input 2
	
	13
	Sample Output 2
	
	2
	Explanation
	
	Sample Case 1:
	The binary representation of  is , so the maximum number of consecutive 's is .
	
	Sample Case 2:
	The binary representation of  is , so the maximum number of consecutive 's is .
 
 
 	---풀이---
 	사실 풀지못한 문제이다..
 	5를 입력하면 2진수값인 101에서
 	1이 연속으로 나온 횟수를 구하는 문제였다. 
 	
 	나는 toBinaryString을 이용해 2진수로 변경 후 찾아내려했는데 실패했다.
 	연속되는 값을 찾는게 좀 까다롭게 느껴졌던거같다.
 	
 	정답은 제타위키에서 긁어왔다.
 	더 분발해야될듯..
 	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day10_BinaryNumbers {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int cnt = 0, max = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				cnt++;
				if (cnt > max)
					max = cnt;
			} else
				cnt = 0;
			n /= 2;
		}
		System.out.println(max);
		scanner.close();
	}
}
