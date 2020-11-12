/*
	Objective
	Today, we're building on our knowledge of Arrays by adding another dimension. Check out the Tutorial tab for learning materials and an instructional video!
	
	Context
	Given a 6x6 2D Array, A:
	
	1 1 1 0 0 0
	0 1 0 0 0 0
	1 1 1 0 0 0
	0 0 0 0 0 0
	0 0 0 0 0 0
	0 0 0 0 0 0
	We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:
	
	a b c
	  d
	e f g
	There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values.
	
	Task
	Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.
	
	Input Format
	
	There are 6 lines of input, where each line contains 6 space-separated integers describing 2D Array A; every value in A will be in the inclusive range of -9 to 9.
	
	
	Output Format
	
	Print the largest (maximum) hourglass sum found in A.
	
	Sample Input
	
	1 1 1 0 0 0
	0 1 0 0 0 0
	1 1 1 0 0 0
	0 0 2 4 4 0
	0 0 0 2 0 0
	0 0 1 2 4 0
	
	Sample Output
	
	19
	
	
	---풀이---
	6x6 배열이 있다.
	그 안에는 16개의 모래시계가 있다.
	3x3으로 된 배열을 말하는 것.
	그 중 가장 큰 값을 가지는 모래시계의 값을 찾아내는것이였다.
	
	3x3씩 총합을 더하고 최댓값 구하는 것 처럼
	가장 큰값을 가진 배열을 찾았다.
	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

public class Day11_2DArrays {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
        
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for (int i = 1; i < 5; i++) {
        	for (int j = 1; j < 5; j++) {
				
        		sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1]
        				+ arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
        		
        		if(sum > max) {
        			max = sum;
        		}
        	}
		}
        
        System.out.println(max);
        
    }
}
