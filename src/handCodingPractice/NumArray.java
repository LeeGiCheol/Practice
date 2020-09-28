// 배열 중 6~7 까지의 값을 담아라

package handCodingPractice;

import java.util.ArrayList;

public class NumArray {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 5, 6, 4, 5, 6, 3, 2, 7, 8, 33, 6, 5, 3, 5, 7 };
		int length = arr.length;

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			if (arr[i] == 6) {
				list.add(arr[i]);
				for (int j = i + 1; j < length; j++) {
					if (arr[j] != 7) {
						list.add(arr[j]);
						i++;
					}
					if (arr[j] == 7) {
						list.add(arr[j]);
						i++;
						break;
					}
				}
			}
		}

		for (Integer answer : list) {
			System.out.print(answer);
		}
	}
}
