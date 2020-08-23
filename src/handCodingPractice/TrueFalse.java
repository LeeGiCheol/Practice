// 1~10 10개의 랜덤의 숫자 중 동일한 값이 있으면 true, 없으면 false 반환 손코딩 후 체크

package handCodingPractice;

import java.util.Random;

public class TrueFalse {

	static boolean trueFalse() {
		Random rd = new Random();
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = rd.nextInt(10)+1;

			System.out.println(arr[i]);
		}

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 10; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			if (arr[i] == arr[i + 1])
				return true;
			else
				return false;
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(trueFalse());
	}

}
