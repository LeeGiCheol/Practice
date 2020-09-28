/*
	Objective
	Today, we're getting started with Exceptions by learning how to parse an integer from a string and print a custom error message. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Read a string, S, and print its integer value; if S cannot be converted to an integer, print Bad String.
	
	Note: You must use the String-to-Integer and exception handling constructs built into your submission language. If you attempt to use loops/conditional statements, you will get a 0 score.
	
	Input Format
	
	A single string, S.
	
	Output Format
	
	Print the parsed integer value of S, or Bad String if S cannot be converted to an integer.
	
	Sample Input 0
	
	3
	Sample Output 0
	
	3
	Sample Input 1
	
	za
	Sample Output 1
	
	Bad String
	
	
	---풀이---
	String to int 변환을 해야한다.
	Integer.parseInt() 메서드를 사용해서 형변환이 가능하다.
	하지만 입력받은 String이 숫자가 아닌 문자라면
	NumberFormatException이 발생하게 된다.
	이를 방지해 Exception이 발생할 경우 Bad String 이라고 출력하는 문제이다.
	
	조건문이나 반복문을 쓸 경우 0점이라고 한다.
	try-catch문을 사용해야 한다.
	
	try에 parseInt(S)를 사용해 int로 형변환 후 출력을 한다.
	이 과정에서 Exception 발생 시 catch문으로 넘어가서
	Bad String을 출력하게 된다.
	
	이 문제는 쉽게 해석하고 풀이했다.
	
	
 */
package hackerRank30DaysOfCode;

import java.util.Scanner;
public class Day16_ExceptionsStringToInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        
        try {
        	int value = Integer.parseInt(S);
        	System.out.println(value);
        }catch(Exception e){
        	System.out.println("Bad String");
        }
        
    }
}
