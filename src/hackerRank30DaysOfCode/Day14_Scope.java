/*
	Objective
	Today we're discussing scope. Check out the Tutorial tab for learning materials and an instructional video!
	
	The absolute difference between two integers,  and , is written as . The maximum absolute difference between two integers in a set of positive integers, , is the largest absolute difference between any two integers in .
	
	The Difference class is started for you in the editor. It has a private integer array () for storing  non-negative integers, and a public integer () for storing the maximum absolute difference.
	
	Task
	Complete the Difference class by writing the following:
	
	A class constructor that takes an array of integers as a parameter and saves it to the  instance variable.
	A computeDifference method that finds the maximum absolute difference between any  numbers in  and stores it in the  instance variable.
	Input Format
	
	You are not responsible for reading any input from stdin. The locked Solution class in your editor reads in  lines of input; the first line contains , and the second line describes the  array.
	
	Constraints
	
	, where 
	Output Format
	
	You are not responsible for printing any output; the Solution class will print the value of the  instance variable.
	
	Sample Input
	
	3
	1 2 5
	Sample Output
	
	4
	
	
	---풀이---
	클래스가 주어진다. 필드에 int배열과 maximumDifference 변수가 주어진다.
	생성자를 만들고, computeDifference 메서드를 만들어야한다.
	computeDifference 메서드는 배열의 요소 중,
	가장 큰값 - 가장 작은 값을 구해 maximumDifference 변수에 저장하는 메서드이다.
	
	사실 문장이 이해가 잘 안가긴했다. 대충 알아들은거로 풀어서 만족스럽진않다.
	풀이는 간단하게했다. max, min 변수에 각각 int 중 가장 작은값, 큰값을 저장해두고
	배열의 각 요소를 max, min과 비교해 가장 크고, 작은 값을 찾아낸다.
	그리고 maximumDifference 변수에 저장한다.
	다행이 정답이었다.
	
	처음엔 for문을 사용했고 this를 사용하지 않았다.
	풀이 완료하고 제타위키를 보니
	forEach를 사용했고 this 키워드를 사용했다.
	
	훨씬 가독성이 좋아보여서 변경했다.
	
 */
package hackerRank30DaysOfCode;

public class Day14_Scope {
	public static void main(String[] args) {
		int[] arr = {1,2,5};
		
		Difference d = new Difference(arr);
		d.computeDifference();
	}
}

class Difference {
	private int[] elements;
	public int maximumDifference;

	
	
	// Add your code here
	public Difference(int[] elements) {
		this.elements = elements;
	}

	void computeDifference() {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i : this.elements) {
			if(i > max) max = i;
			if(i < min) min = i;
		}
		
		this.maximumDifference = max - min;
		
		System.out.println(maximumDifference);
	}
} // End of Difference class

