/*
 * 
	Welcome to Day 18! Today we're learning about Stacks and Queues. Check out the Tutorial tab for learning materials and an instructional video!
	
	A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards and forwards. Can you determine if a given string, s, is a palindrome?
	
	To solve this challenge, we must first take each character in s, enqueue it in a queue, and also push that same character onto a stack. Once that's done, we must dequeue the first character from the queue and pop the top character off the stack, then compare the two characters to see if they are the same; as long as the characters match, we continue dequeueing, popping, and comparing each character until our containers are empty (a non-match means s isn't a palindrome).
	
	Write the following declarations and implementations:
	
	Two instance variables: one for your stack, and one for your queue.
	A void pushCharacter(char ch) method that pushes a character onto a stack.
	A void enqueueCharacter(char ch) method that enqueues a character in the queue instance variable.
	A char popCharacter() method that pops and returns the character at the top of the stack instance variable.
	A char dequeueCharacter() method that dequeues and returns the first character in the queue instance variable.
	Input Format
	
	You do not need to read anything from stdin. The locked stub code in your editor reads a single line containing string s. It then calls the methods specified above to pass each character to your instance variables.
	
	Constraints
	
	 is composed of lowercase English letters.
	Output Format
	
	You are not responsible for printing any output to stdout.
	If your code is correctly written and  is a palindrome, the locked stub code will print The word, s, is a palindrome.; otherwise, it will print The word, s, is not a palindrome.
	
	Sample Input
	
	racecar
	Sample Output
	
	The word, racecar, is a palindrome.


	---풀이---
	간단한 Queue와 Stack 문제였다. 
	사실 이 문제는 스택과 큐를 직접 만들었어야 더 공부가 됬을거라고 생각한다. 
	우선 영어 독해가 굉장히 어려웠다. 
	뭘 원하는지는 알겠는데 해석을 못하겠는 느낌이었다.
	
	30일 챌린지 하면서 구글번역기를 가장 많이 쓴날인 것 같다...
	
	ex) ABCBA = The word, ABCBA, is a palindrome.
		ABCDE = The word, ABCDE, is not a palindrome.
		
	먼저 입력한 값을 char 배열로 변환 후 스택과 큐에 각각 넣어두고,
	하나씩 빼면서 동일한 값인지 체크하는 문제였다.
	끝까지 모두 동일하다면 ABCBA와 같은 문자열일 것이고,
	아니라면 ABCDE와 같은 문자열일 것이다.
	  
	
 */


package hackerRank30DaysOfCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class Day18_QueuesAndStacks {

	
	Stack<Character> stack = new Stack<Character>();
	Queue<Character> queue = new LinkedList<Character>();
	
	void pushCharacter(char c) {
		stack.push(c);
	}
	
	void enqueueCharacter(char c) {
		queue.add(c);
	}
	
	char popCharacter() {
		return stack.pop();
	}
	
	char dequeueCharacter() {
		
		return queue.remove();
	}
	

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String input = scan.nextLine();
	        scan.close();

	        // Convert input String to an array of characters:
	        char[] s = input.toCharArray();

	        // Create a Solution object:
	        Day18_QueuesAndStacks p = new Day18_QueuesAndStacks();

	        // Enqueue/Push all chars to their respective data structures:
	        for (char c : s) {
	            p.pushCharacter(c);
	            p.enqueueCharacter(c);
	        }

	        // Pop/Dequeue the chars at the head of both data structures and compare them:
	        boolean isPalindrome = true;
	        for (int i = 0; i < s.length/2; i++) {
	            if (p.popCharacter() != p.dequeueCharacter()) {
	                isPalindrome = false;                
	                break;
	            }
	        }

	        //Finally, print whether string s is palindrome or not.
	        System.out.println( "The word, " + input + ", is " 
	                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
	    }
	}
