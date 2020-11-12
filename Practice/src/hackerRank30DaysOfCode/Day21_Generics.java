/*
	Objective
	Today we're discussing Generics; be aware that not all languages support this construct, so fewer languages are enabled for this challenge. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Write a single generic function named printArray; this function must take an array of generic elements as a parameter (the exception to this is C++, which takes a vector). The locked Solution class in your editor tests your function.
	
	Note: You must use generics to solve this challenge. Do not write overloaded functions.
	
	Input Format
	
	The locked Solution class in your editor will pass different types of arrays to your printArray function.
	
	Constraints
	
	You must have exactly 1 function named printArray.
	Output Format
	
	Your printArray function should print each element of its generic array parameter on a new line.
	
	
	
	---풀이---
	Generic에 대해서 알긴 했지만,
	ArrayList나 Map처럼 이미 구현되있는 것 말고는
	제대로 사용해본적이 없어서 조금 시간이 걸렸던 문제이다.
	실제로 사용해보니 더 유용한 기능인 것 같다.
	
	영어는 많이 어렵지는 않았다. 
	
	Objective 부분에서는 Generic을 지원하지 않는 언어도 많다는 얘길 했고,
	Task 에서 Generic element를 parameter로 가지는 
	printArray 메서드를 Overloading을 사용하지 않고 구현하라.

	결국 인자로 넘긴 배열의 모든 요소를 출력하는 문제였다. 
	
	
 */

package hackerRank30DaysOfCode;

import java.util.*;

class Printer<T> {

	/**
	 * Method Name: printArray Print each element of the generic array on a new
	 * line. Do not return anything.
	 * 
	 * @param A generic array
	 **/

	// Write your code here
	
	<T> void printArray(T[] arr) {
		for (T t : arr) {
			System.out.println(t);
		}
	}
	
}

public class Day21_Generics {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Integer[] intArray = new Integer[n];
		for (int i = 0; i < n; i++) {
			intArray[i] = scanner.nextInt();
		}

		n = scanner.nextInt();
		String[] stringArray = new String[n];
		for (int i = 0; i < n; i++) {
			stringArray[i] = scanner.next();
		}

		Printer<Integer> intPrinter = new Printer<Integer>();
		Printer<String> stringPrinter = new Printer<String>();
		intPrinter.printArray(intArray);
		stringPrinter.printArray(stringArray);
		if (Printer.class.getDeclaredMethods().length > 1) {
			System.out.println("The Printer class should only have 1 method named printArray.");
		}
	}
}