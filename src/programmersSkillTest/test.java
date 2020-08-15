//문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
//str에 나타나는 숫자 중 최소값과 최대값을 찾아 
//이를 (최소값) (최대값)형태의 문자열을 반환하는 함수, solution을 완성하세요.
//예를들어 s가 1 2 3 4라면 1 4를 리턴하고, -1 -2 -3 -4라면 -4 -1을 리턴하면 됩니다.

package programmersSkillTest;

import java.util.Arrays;

public class test {
	static String solution(String s) {
		String answer = "";
		
		
		String[] arr = s.split(" ");
		int[] arr2 = new int[arr.length];
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			arr2[cnt++] = Integer.parseInt(arr[i]);
		}
		
		
		int max = arr2[0];
		int min = arr2[0];
		for (int i = 0; i < arr2.length; i++) {
			if(arr2[i] > max)
				max = arr2[i];
			if(arr2[i] < min)
				min = arr2[i];
		}
		
		
		answer = "" + min + "" + max ;
		
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("-1 -1"));
	}
}
