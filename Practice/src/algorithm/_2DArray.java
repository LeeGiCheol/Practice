/*
	문제
	예제를 보고 적당한 배열을 선언한 후 1행의 1열과 3열 5열을 각각 1로 초기화하고 나머지는 모두 0으로 초기화 한 후 2행부터는 바로 위행의 왼쪽과 오른쪽의 값을 더하여 채운 후 출력하는 프로그램을 작성하시오.
	
	출력 예
	1 0 1 0 1
	0 2 0 2 0
	2 0 4 0 2
	0 6 0 6 0
	6 0 12 0 6
 */

package algorithm;

import java.util.Arrays;

public class _2DArray {
	public static void main(String[] args) {
		
		// 초기배열 셋팅
		int[][] arr = new int[7][7];
		arr[0][0] = 0; arr[0][6] = 0;
		arr[0][1] = 1; arr[0][2] = 0; arr[0][3] = 1; arr[0][4] = 0; arr[0][5] = 1;
		
		int[][] result = new int[5][5];
		
		// 맨 왼,오른쪽은 0이므로 7x7 배열을 만들어서 풀이
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1];
			}
		}
		
		// 옮겨담기
		int ia = 0;
		int ja = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 5; j++) {
				result[ia][ja] = arr[i][j];
				ja++;
			}
			ia++;
			ja=0;
		}
		System.out.println(Arrays.deepToString(result));
		
		
		// 옮기지 않고 0, 6번 인덱스 제외하고 출력할 경우
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(arr[i][j+1] + " ");
			}
			System.out.println();
		}
		
		
		
	}
}
