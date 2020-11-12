/*
	Objective
	Today's challenge puts your understanding of nested conditional statements to the test. You already have the knowledge to complete this challenge, but check out the Tutorial tab for a video on testing!
	
	Task
	Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any). The fee structure is as follows:
	
	1. If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine = 0.
	2. If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, fine = 15Hackos x (the number of days late).
	3. If the book is returned after the expected return month but still within the same calendar year as the expected return date, the fine = 500Hackos x (the number of months late).
	4. If the book is returned after the calendar year in which it was expected, there is a fixed fine of 10000Hackos.
	
	Input Format
	
	The first line contains 3 space-separated integers denoting the respective day, month, and year on which the book was actually returned.
	The second line contains  space-separated integers denoting the respective day, month, and year on which the book was expected to be returned (due date).
	
	
	Output Format
	
	Print a single integer denoting the library fine for the book received as input.
	
	Sample Input
	
	9 6 2015
	6 6 2015
	
	Sample Output
	
	45
	
	
	---풀이---
	별로 어려운 문제는 아니었다.
	도서관의 연체료를 계산하는 문제였다.
	정해진 대여일이 지나기 전에 반납을 하면 0
	하루에 45, 한달엔 500, 1년엔 10000
	
	NestedLogic을 찾아보니 중첩로직인데,
	자바에는 NestedClass가 가능하다고 한다.
	그렇지만 지금 풀이방식에 중첩이 보이지는 않는다.
	
	그래서 사실은 무엇을 원하고 낸 문제인지 잘 모르겠다..
	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day26_NestedLogic {
	static int getFine(int actualDay, int actualMonth, int actualYear, 
			int expectedDay, int expectedMonth, int expectedYear) {
		if (actualYear > expectedYear)
			return 10000;
		if (actualYear < expectedYear)
			return 0;
		if (actualMonth > expectedMonth) {
			return 500 * (actualMonth - expectedMonth);
		}
		if (actualMonth < expectedMonth)
			return 0;
		if (actualDay > expectedDay) {
			return 15 * (actualDay - expectedDay);
		}
		return 0;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		
		int actualDay = sc.nextInt();
		int actualMonth = sc.nextInt();
		int actualYear = sc.nextInt();
		int expectedDay = sc.nextInt();
		int expectedMonth = sc.nextInt();
		int expectedYear = sc.nextInt();
		
		int fine = getFine(actualDay, actualMonth, actualYear, expectedDay, expectedMonth, expectedYear);
		
		System.out.println(fine);
	}
}
