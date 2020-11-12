/*
		
	Objective
	Today, we're learning and practicing an algorithmic concept called Recursion. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Write a factorial function that takes a positive integer, N as a parameter and prints the result of N! (N factorial).
	
	Note: If you fail to use recursion or fail to name your recursive function factorial or Factorial, you will get a score of 0.
	
	Input Format
	
	A single integer, N (the argument to pass to factorial).
	
	Constraints
	2 <= N <= 12
	
	Your submission must contain a recursive function named factorial.
	Output Format
	
	Print a single integer denoting N!.
	
	Sample Input
	
	3
	Sample Output
	
	6
	
		
	---풀이---
	양수를 매개변수로 받아서 팩토리얼을 구하는 팩토리얼 함수를 만들어라.
	만약 재귀를 사용하지 않거나 
	함수명이 recursive function factorial , Factorial이 아닌경우 점수는 0점이다.
	
	팩토리얼은 공식을 기억하고 있어서 바로 풀 수 있었다.
	그치만 문제는
	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
	였다.
	
	System.getenv("OUTPUT_PATH") 라는것을 처음봤다.
	
	StackOverFlow에서는 해커랭크에선 정의된 환경변수를 읽고,
	분석을 위해 결과를 저장할 위치를 지정해야한다고 되있었다. 흠..?

	실행시켜보니 NullPointerException이 나왔고,
	BufferWriter를 사용안하고 그냥 result를 출력해보니
	원하던 값은 잘나왔다. 제출해보니 정답도 잘 나왔다.
	
	그래서 RunConfigurations에 OUTPUT_PATH를 지정해보았다.
	NPE는 발생하지 않았지만 정상작동 하지 못했다.

 */


package hackerRank30DaysOfCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Day09_Recursion3 {

	// Complete the factorial function below.
	static int factorial(int n) {
		if(n <= 1)
			return n;
		else 
			return n * factorial(n - 1);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = factorial(n);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
