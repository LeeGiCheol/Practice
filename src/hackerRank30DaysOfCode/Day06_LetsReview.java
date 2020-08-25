/*
	Objective
	Today we're expanding our knowledge of Strings and combining it with what we've already learned about loops. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Given a string, S, of length N that is indexed from 0 to N-1, print its even-indexed and odd-indexed characters as  2space-separated strings on a single line (see the Sample below for more detail).
	
	Note:  is considered to be an even index.
	
	Input Format
	
	The first line contains an integer, T (the number of test cases).
	Each line i of the T subsequent lines contain a String, S.
	
	Constraints
	
	Output Format
	
	For each String Sj (where 0 <= j <= T - 1), print Sj's even-indexed characters, followed by a space, followed by Sj's odd-indexed characters.
	
	
	--- 풀이 ---
	스트링과 반복문을 결합해서 지식을 확장한다.
	
	나는 지금 영어 독해도 같이 연습하기 때문에
	Sample input output을 최대한 나중에 본다. (미리 보면 해석을 안하고 풀 수준의 문제들이라...)
	이 문제는 abcdef 를 입력했을 때
	abc def로 출력하라는지 ace bdf로 출력하라는지 헷갈렸다.
	
	print its even-indexed and odd-indexed characters as  2space-separated strings on a single line (see the Sample below for more detail).
	홀수 짝수인덱스를 2개의 영역으로 분리하라는 것인데 이부분 해석이 조금 어려웠다.
	
	scanner를 사용해서 character 배열로 값을 받았고
	반복문으로 홀수, 짝수만 받게 끔 풀이했다.
	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day06_LetsReview {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < T; i++) {
			char[] ch = sc.nextLine().toCharArray();
			
			for (int j = 0; j < ch.length; j+=2) {
				System.out.print(ch[j]);
			}
			System.out.print(" ");
			
			for (int j = 1; j < ch.length; j+=2) {
				System.out.print(ch[j]);
			}
			System.out.println();
		}
		
	}
}