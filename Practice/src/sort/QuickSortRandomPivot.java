package sort;

import java.util.Random;
import java.util.Scanner;

public class QuickSortRandomPivot {
	
	static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int index = partition(arr, start, end);
			
			quickSort(arr, start, index - 1);
			quickSort(arr, index + 1, end);
			
		}else {
			return;
		}
	}
	
	static int partition(int[] arr, int start, int end) {
		
		Random rand = new Random();

		int randNum = start + (rand.nextInt(end-start+1));
//		int rd = rand.nextInt((end - start) + 1) + start;
		
		swap(arr, randNum, end);
		
		int pivot = end;
		int index = start;
		
		for (int i = start; i < end; i++) {
			if(arr[i] < arr[pivot]) {
				swap(arr, i, index);
				index++;
			}
		}
		
		swap(arr, index, pivot);
				
		return index;
	}
	
	static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {55, 2, 34, 10, 7, 42, 1};
		
		System.out.println("before");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		quickSort(arr, 0, arr.length - 1);

		System.out.println("\nafter");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
