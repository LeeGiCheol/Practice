/*
	문제 설명
	0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
	
	예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
	
	0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
	
	제한 사항
	numbers의 길이는 1 이상 100,000 이하입니다.
	numbers의 원소는 0 이상 1,000 이하입니다.
	정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
	입출력 예
	numbers	return
	[6, 10, 2]	6210
	[3, 30, 34, 5, 9]	9534330
	
	
	
	---- 풀이 ----
	오늘도 틀렸다. 그렇지만 많이 배웠다.
	처음에 문제 해석을 잘못해버려서
	정말 가장 큰수를 찾는걸 구현해버렸다 
	ex) 6, 10, 2 -> 6210	3, 30, 34, 5, 9 -> 9543330
	.............
	문제를 좀 더 꼼꼼히 볼 필요가 있다고 느꼈다.
	또한 int to String 변환 시 "" + int 로 하면 될줄 알았는데 (되긴 하지만)
	String.valueOf()를 사용하라고 했다.
	전자는 효율성이 매우 떨어진다고 하더라.. 
	
	값을 비교하는 Comparator, CompareTo도 새롭게 배울 수 있었다.
	
	두번째로 본 방식도 굉장히 대단했다.
	
	이런 문제풀이에서 익명함수를 많이 사용하는것같다.
	
	Comparator, CompareTo, Lambda에 대해 공부해야 할듯하다.
	
 */

package programmersAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class _02_LargestNumber_X {

	public static String solution(int[] numbers) {
		String answer = "";

		// int 배열을 String 배열로 변환
		String[] arr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = (String.valueOf(numbers[i]));
		}

		// 배열 정렬, 정렬 규칙으로는 2개를 더하여 더 큰 쪽이 우선순위가 있도록 정렬
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});

		// 0000 처럼 0으로만 구성되어있으면 0 return
		if (arr[0].equals("0"))
			return "0";

		// 그 외의 경우 순차적으로 연결하여 answer return
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		return answer;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////

	// 또 다른 풀이법
	
//	import java.util.ArrayList;
//	import java.util.Collections;
//	import java.util.List;
//
//	public class _02_LargestNumber_X {
//	    public static String solution(int[] numbers) {
//	        String answer = "";
//
//	        List<Integer> list = new ArrayList<>();
//	        for(int i = 0; i < numbers.length; i++) {
//	            list.add(numbers[i]);
//	        }
//	        Collections.sort(list, (a, b) -> {
//	            String as = String.valueOf(a), bs = String.valueOf(b);
//	            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
//	        });
//	        StringBuilder sb = new StringBuilder();
//	        for(Integer i : list) {
//	            sb.append(i);
//	        }
//	        answer = sb.toString();
//	        if(answer.charAt(0) == '0') {
//	            return "0";
//	        }else {
//	            return answer;
//	        }
//	    }
//	}

////////////////////////////////////////////////////////////////////////////////////////


	public static void main(String[] args) {
		int[] arr = { 6, 10, 2 };
//		int[] arr = {3,30,34,5,9};
		System.out.println(solution(arr));
	}
}
