// Stream 평균 구하기

package stream;

import java.util.Arrays;
import java.util.OptionalDouble;

public class StreamExam4 {
	public static void main(String[] args) {
		
		int[] arr = {80, 30, 20, 90, 11};
		double[] arr2 = {10.2, 30.2, 32.5};
		// 배열의 평균을 반환
		double avg = Arrays.stream(arr).average().getAsDouble();

		// 배열의 총합을 반환
		double sum = Arrays.stream(arr).sum();
		
		// 배열의 개수를 반환
		double count = Arrays.stream(arr).count();

		/* 
		   배열의 최대, 최소값 반환
		   API를 확인해보니 타입이 OptionalInt이었다.
		   굉장히 생소하다. 그래서인지 double 타입의 배열은 지원안하는것같다.
		   하지만 double 타입으로 반환은 가능했다. 
		   
		   또한 OptionalDouble 타입으로 double 타입 배열도 사용 가능했다.
		   Optional에 대해서 따로 알아볼 예정
		   Optional은 Null인 값도 포함할 수 있는 컨테이너 오브젝트라고 한다..
		*/
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		OptionalDouble max2 = Arrays.stream(arr2).max();
		
		System.out.println(avg);
		System.out.println(sum);
		System.out.println(count);
		System.out.println(max);
		System.out.println(min);
		System.out.println(max2);
	}
}
