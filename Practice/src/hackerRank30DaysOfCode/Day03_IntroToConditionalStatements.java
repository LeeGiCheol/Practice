/*
 
	Objective
	In this challenge, we're getting started with conditional statements. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Given an integer, n, perform the following conditional actions:
	
	If n is odd, print Weird
	If n is even and in the inclusive range of 2 to 5, print Not Weird
	If n is even and in the inclusive range of 6 to 20, print Weird
	If n is even and greater than 20, print Not Weird
	Complete the stub code provided in your editor to print whether or not n is weird.
	
	Input Format
	
	A single line containing a positive integer, n.
	
	Constraints
	1 <= n <= 100;
	
	Output Format
	
	Print Weird if the number is weird; otherwise, print Not Weird.
	
	Sample Input 0
	
	3
	Sample Output 0
	
	Weird
	Sample Input 1
	
	24
	Sample Output 1
	
	Not Weird

	
	-- 풀이 --
	너무너무 쉽게 해석한 문제이다.
	15분 이하로 걸렸다. (영어 독해를 생각하면 어제 그제랑 비교하면 굉장히 빠른 속도이다.)
	먼저 Weird라는 단어를 몰라 찾아보니 "기묘한"이란 뜻이라고 한다. (?????)
	알고보니 odd는 홀수 말고 "이상한" 이란 뜻을 가지고 있는데 이것 때문인것 같다.
	(왜 홀수가 이상한 수인지까진 모르겠다)
	
	홀수면 Weird를 출력하고,
	짝수인데 2 ~ 5 사이면 Not Weird를
	짝수인데 6 ~ 20 사이면 Weird를
	짝수인데 20보다 크면 Not Weird를 출력하라는 간단한 문제였다.

	Complete the stub code provided in your editor to print whether or not n is weird.
	n이 이상한지 아닌지 출력하려면 에디터가 제공하는 stub code로 완성하라???
	stub code가 뭔지 잘모르겠다.. 코드 뭉탱이? 아마 메서드를 의미하는것 같아보여서
	메서드를 만들어서 메인문에서 호출하도록 만들었다.
	
	역시나 문제 풀이는 어려운게 없었다.

 */
package hackerRank30DaysOfCode;
import java.util.Scanner;

public class Day03_IntroToConditionalStatements {

	
	static String weirdNotWeird(int num) {
		String solution = "";
		
		if(num % 2 != 0) {
			solution = "Weird";
		}
		else {
			if(num <= 4)
				solution = "Not Weird";
			else if(6 <= num && num <= 20) {
				solution = "Weird";
			}
			else if(num > 20){
				solution = "Not Weird";
			}
		}
		return solution;
	}



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        
        System.out.println(weirdNotWeird(N));
        
        scanner.close();
    }
}
	
	
