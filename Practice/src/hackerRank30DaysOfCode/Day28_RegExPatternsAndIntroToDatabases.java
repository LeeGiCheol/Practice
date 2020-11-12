/*
	Objective
	Today, we're working with regular expressions. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Consider a database table, Emails, which has the attributes First Name and Email ID. Given N rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends in @gmail.com.
	
	Input Format
	
	The first line contains an integer, N, total number of rows in the table.
	Each of the N subsequent lines contains 2 space-separated strings denoting a person's first name and email ID, respectively.
	
	Constraints
	
	2 <= N <= 30
	Each of the first names consists of lower case letters [a-z] only.
	Each of the email IDs consists of lower case letters [a-z], @ and . only.
	The length of the first name is no longer than 20.
	The length of the email ID is no longer than 50.
	Output Format
	
	Print an alphabetically-ordered list of first names for every user with a gmail account. Each name must be printed on a new line.
	
	Sample Input
	
	6
	riya riya@gmail.com
	julia julia@julia.me
	julia sjulia@gmail.com
	julia julia@gmail.com
	samantha samantha@gmail.com
	tanya tanya@gmail.com
	Sample Output
	
	julia
	julia
	riya
	samantha
	tanya
	
	
	
	---풀이---
	지난번에 정규표현식을 공부했었어서 어렵지 않게 풀이할 수 있었다.
	이름은 소문자 알파벳만 사용가능하며 20글자 이하이어야한다.
	이메일은 소문자 알파벳, @ 그리고 . 만 사용가능하며 50글자 이하여야한다.
	사용가능한 계정을 알파벳순으로 정렬해 출력하는 문제이다.
	
	지난번에 했던 정규표현식을 참고하면서 패턴을 작성했고,
	입력된 값과 matches 메서드를 사용해 확인을 한 후 list에 넣었다.
	정렬은 Collections.sort()를 사용했다.
	
 */

package hackerRank30DaysOfCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day28_RegExPatternsAndIntroToDatabases {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		List<String> list = new LinkedList<String>();
		
		for (int NItr = 0; NItr < N; NItr++) {
			String[] firstNameEmailID = scanner.nextLine().split(" ");

			String firstName = firstNameEmailID[0];

			String emailID = firstNameEmailID[1];
			
			if(!firstName.matches("^[a-z]{1,20}$"))
				continue;
			if(!emailID.matches("^[a-z\\.]{1,50}@gmail.com$"))
				continue;
			
			list.add(firstName);
			
		}
		
		Collections.sort(list);

		
		for (String string : list) {
			System.out.println(string);
		}
		scanner.close();
	}
}
