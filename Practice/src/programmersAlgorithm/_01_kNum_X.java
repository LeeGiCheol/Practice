/*
	배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
	
	예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
	
	array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
	1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
	2에서 나온 배열의 3번째 숫자는 5입니다.
	배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	
	제한사항
	array의 길이는 1 이상 100 이하입니다.
	array의 각 원소는 1 이상 100 이하입니다.
	commands의 길이는 1 이상 50 이하입니다.
	commands의 각 원소는 길이가 3입니다.
	입출력 예
	array	commands	return
	[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
	입출력 예 설명
	[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
	[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
	[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
	
	30분 정도 풀다가 실패해서 다른 사람의 풀이법을 보고 주석달았음..
 */

package programmersAlgorithm;

import java.util.Arrays;

public class _01_kNum_X {

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		int length = commands.length;

		for (int i = 0; i < length; i++) {
			// 전달받은 배열의 특정 범위에 해당하는 요소만을 새로운 배열로 복사하여 반환
			// Arrays.copyOfRange(배열, 시작값, 끝값-1)
			// index이기 때문에 시작값은 -1을 해주어야 원하는 값이 나오고, 끝값은 어차피 매개변수의 -1 까지 복사하기 때문에 그대로 써도 된다
			int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

			// 정렬
			sort(temp, 0, temp.length - 1);
			System.out.println(Arrays.toString(temp));
			// 2차원배열의 [i][2] - 1를 temp의 인덱스로 하여 찾은 값을 새배열에 담는다
			// 위의 값으로 새롭게 담을 값이 몇번째 수인지 알 수 있다.
			answer[i] = temp[commands[i][2] - 1];
		}

		return answer;
	}

	// 퀵소트
	static void sort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2]; // 중간값
		
		do {
			while(a[pl] < x)
				pl++;
			while(a[pr] > x)
				pr--;
			
			if(pl <= pr) {
				int temp = a[pl];
				a[pl] = a[pr];
				a[pr] = temp;
				pl++;
				pr--;
			}
			
		} while(pl <= pr);
		
		if(left < pr)
			sort(a, left, pr);
		if(right > pl)
			sort(a, pl, right);
		
	}

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		System.out.println(Arrays.toString(solution(array, commands)));
	}
}
