/*
	Objective				
	Yesterday's challenge taught you to manage exceptional situations by using try and catch blocks. In today's challenge, you're going to practice throwing and propagating an exception. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Write a Calculator class with a single method: int power(int,int). The power method takes two integers, n and p, as parameters and returns the integer result of n^p. If either n or p is negative, then the method must throw an exception with the message: n and p should be non-negative.
	
	Note: Do not use an access modifier (e.g.: public) in the declaration for your Calculator class.
	
	Input Format
	
	Input from stdin is handled for you by the locked stub code in your editor. The first line contains an integer, T, the number of test cases. Each of the T subsequent lines describes a test case in 2 space-separated integers denoting n and p, respectively.
	
	Constraints
	
	No Test Case will result in overflow for correctly written code.
	Output Format
	
	Output to stdout is handled for you by the locked stub code in your editor. There are T lines of output, where each line contains the result of n^p as calculated by your Calculator class' power method.
	
	Sample Input
	
	4
	3 5
	2 4
	-1 -2
	-1 3
	Sample Output
	
	243
	16
	n and p should be non-negative
	n and p should be non-negative
	
	
	---풀이---
	Calculator 클래스를 만들고
	power 메서드를 만든다.
	매개변수로 int 두개를 받는데,
	n^p 형태로 만드는 문제이다.
	
	음수일 경우 n and p should be non-negative를 출력한다.
	
	Math.pow() 메서드를 사용해서 만들어주었다.
	음수일 경우는 throw new Exception 을 사용해 처리를 해주었다.
	
 */
package hackerRank30DaysOfCode;

	import java.util.Scanner;

	//Write your code here

	class Calculator {
		int power(int n, int p) throws Exception {
			
			if(n < 0 || p < 0) {
				throw new Exception("n and p should be non-negative");
			}

			return (int)Math.pow(n, p);
		}
	}
	
	
	public class Day17_MoreException {

	    public static void main(String[] args) {
	    
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        while (t-- > 0) {
	        
	            int n = in.nextInt();
	            int p = in.nextInt();
	            Calculator myCalculator = new Calculator();
	            try {
	                int ans = myCalculator.power(n, p);
	                System.out.println(ans);
	            }
	            catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	        }
	        in.close();
	    }
	}
