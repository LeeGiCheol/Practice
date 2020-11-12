/*
	Objective
	Today, we're learning about Interfaces. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	The AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for you in the editor below.
	
	Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface. The implementation for the divisorSum(n) method must return the sum of all divisors of n.
	
	Input Format
	
	A single line containing an integer, n.
	
	Constraints
	1 <= n <= 1000
	
	Output Format
	
	You are not responsible for printing anything to stdout. The locked template code in the editor below will call your code and print the necessary output.
	
	Sample Input
	
	6
	Sample Output
	
	I implemented: AdvancedArithmetic
	12
	
	
	---풀이---
	AdvancedArithmetic Interface에 선언된 divisorSum 메서드를
	Calculator 클래스에서 정의하는 문제이다.
	메서드는 매개변수로 받는 n의 제수의 합을 구하는 것인데,
	제수가 뭔지 몰랐다...
	알아보니 약수와 같은 뜻인 것 같다.
	ex) 6 = 1, 2, 3, 6 이 제수(약수) 이다.
	1+2+3+6 을 구하는 것이었다.
	
	for문을 통해서 n을 i로 나누었을때 나누어 떨어지는 수를
	sum 변수에 더하는 방식으로 풀이했다.

 */

package hackerRank30DaysOfCode;

	import java.util.Scanner;

	interface AdvancedArithmetic{
	   int divisorSum(int n);
	}
	class Calculator2 implements AdvancedArithmetic {
	    public int divisorSum(int n) {
	    	int sum = 0;
	    	
	    	for (int i = 1; i <= n; i++) {
				if(n % i == 0)
					sum += i;
			}
	    	return sum;
	    }
	}

	public class Day19_Interface {

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        scan.close();
	        
	      	AdvancedArithmetic myCalculator = new Calculator2(); 
	        int sum = myCalculator.divisorSum(n);
	        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
	        System.out.println(sum);
	    }
	}
