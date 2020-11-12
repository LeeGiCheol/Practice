/*
	Objective
	Today, we're discussing a simple sorting algorithm called Bubble Sort. Check out the Tutorial tab for learning materials and an instructional video!
	
	Consider the following version of Bubble Sort:
	
	for (int i = 0; i < n; i++) {
	    // Track number of elements swapped during a single array traversal
	    int numberOfSwaps = 0;
	    
	    for (int j = 0; j < n - 1; j++) {
	        // Swap adjacent elements if they are in decreasing order
	        if (a[j] > a[j + 1]) {
	            swap(a[j], a[j + 1]);
	            numberOfSwaps++;
	        }
	    }
	    
	    // If no elements were swapped during a traversal, array is sorted
	    if (numberOfSwaps == 0) {
	        break;
	    }
	}
	Task
	Given an array, a, of size n distinct elements, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following 3 lines:
	
	Array is sorted in numSwaps swaps.
	where numSwaps is the number of swaps that took place.
	First Element: firstElement
	where firstElement is the first element in the sorted array.
	Last Element: lastElement
	where lastElement is the last element in the sorted array.
	Hint: To complete this challenge, you will need to add a variable that keeps a running tally of all swaps that occur during execution.
	
	Input Format
	
	The first line contains an integer, n, denoting the number of elements in array a.
	The second line contains n space-separated integers describing the respective values of a0, a1, ... an-1.
	
	
	Output Format
	
	Print the following three lines of output:
	
	Array is sorted in numSwaps swaps.
	where numSwaps is the number of swaps that took place.
	First Element: firstElement
	where firstElement is the first element in the sorted array.
	Last Element: lastElement
	where lastElement is the last element in the sorted array.
	Sample Input 0
	
	3
	1 2 3
	
	Sample Output 0
	
	Array is sorted in 0 swaps.
	First Element: 1
	Last Element: 3
	
	
	Sample Input 1
	
	3
	3 2 1
	Sample Output 1
	
	Array is sorted in 3 swaps.
	First Element: 1
	Last Element: 3
	
	
	
	---풀이---
	사실 상 문제에 모든 정답이 나와있다.
	BubbleSort 알고리즘으로 정렬을 해야한다.
	정렬되는 횟수만큼 numSwaps 변수의 값을 증가시킨다.
	그리고 정렬된 후의 첫번째, 마지막 값을 구하라.
	
	너무나도 간단하게 풀이할 수 있었다.

 */

package hackerRank30DaysOfCode;

import java.util.Scanner;
public class Day20_Sort {

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        
	        int numSwaps = 0;
	        for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if(a[j] > a[j + 1]) {
						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
						numSwaps++;
					}
				}
				
				if(numSwaps == 0) break;
			}
	        
	        System.out.println("Array is sorted in " + numSwaps + " swaps.");
	        System.out.println("First Element: " + a[0]);
	        System.out.println("Last Element: " + a[a.length-1]);
	    }
	}
