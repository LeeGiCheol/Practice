/*
	Objective
	Today we're learning about running time! Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself. Given a number, n, determine and print whether it's Prime or Not prime.
	
	Note: If possible, try to come up with a O(√n) primality algorithm, or see what sort of optimizations you come up with for an O(n) algorithm. Be sure to check out the Editorial after submitting your code!
	
	Input Format
	
	The first line contains an integer, T, the number of test cases.
	Each of the T subsequent lines contains an integer, n, to be tested for primality.
	
	
	Output Format
	
	For each test case, print whether n is Prime or Not prime on a new line.
	
	Sample Input
	
	3
	12
	5
	7
	
	Sample Output
	
	Not prime
	Prime
	Prime
	
	
	
	---풀이---
	해석은 좀 재밌게 할 수 있었던 편이였다.
	소수찾기는 지난번에 에라토스테네스의 체 알고리즘으로 풀어본 기억이 있어서
	기억을 더듬어 풀이를 하다보니 금새 막혔다. 	
	이유는 당시엔 input이 1개였는데 지금은 여러개가 가능하다보니
	머리가 잘 굴러가질 않았다. 그래서 제타위키를 참고했다..
	
	생각보다 쉽게 풀이가 되있었다.

	n을 2부터 n의 제곱근까지 모두 나누어 0으로 나누어 떨어지는지 체크를 한다.
	나누어떨어진다면 Not prime 아니라면 Prime
	
	에라토스테네스의 체를 기억하자면 2의제곱, 3의제곱... 
	나아가면서 나누어떨어지면 0, Loop중 0을 만날 경우 continue
	
	Loop을 다 돌게되면 0이 아닌것은 PrimeNumber였다.
	
	같은 방식인듯 아닌듯 헷갈리는 것 같다.
	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day25_RunningTimeAndComplexity_PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        
		for (int i=0; i<T; i++) {
            int n = sc.nextInt();
            if(primeNumber(n)) {
            	System.out.println("Prime");
            }
            else {
            	System.out.println("Not Prime");
            }
        }
	}
	
	static boolean primeNumber(int n) {
		if(n < 2) return false;
		
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
}
