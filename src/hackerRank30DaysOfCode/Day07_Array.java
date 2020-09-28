/*

	Objective
	Today, we're learning about the Array data structure. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Given an array, A, of N integers, print A's elements in reverse order as a single line of space-separated numbers.
	
	Input Format
	
	The first line contains an integer, N (the size of our array).
	The second line contains N space-separated integers describing array A's elements.
	
	Constraints
	1 <= N <= 1000
	1 <= A^i <= 10000, where A^i is the i^th integer in the array.
	Output Format
	
	Print the elements of array A in reverse order as a single line of space-separated numbers.
	
	Sample Input
	
	4
	1 4 3 2
	Sample Output
	
	2 3 4 1
	
	--- 풀이 ---
	독해는 무난한 편이였다. (코드 제출까지 약 15분?)
	배열 뒤집기 문제였다.
	N으로 배열의 크기를 정하고
	배열 요소를 채운다.
	
	이때 String 배열로 입력을 받는다.
	요소 간 공백(스페이스바)을 기준으로 split 하기 위함으로 보인다. (이미 주어진 코드였음)
	
	새로운 배열을 만들어서 for문으로 기존 배열을 거꾸로 돌려서 
	새 배열을 만들었다.
	
	제출은 이방식으로 했고, 정답이긴 하지만 다른 풀이를 확인했더니,
	for문을 통해 arr[n - i - 1]을 출력하는 방식으로 되어있었다.

	코드도 훨씬 짧고 더 가독성 있는것같다.

 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day07_Array {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}
		
//		int[] answer = new int[n];
//		int j = 0;
//		for (int i = n-1; i >= 0; i--) {
//			answer[j] = arr[i];
//			j++;
//		}
//		
//		for (int i : answer) {
//			System.out.print(i);
//		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[n - i - 1] + " ");
		}
		
		scanner.close();
	}

}
