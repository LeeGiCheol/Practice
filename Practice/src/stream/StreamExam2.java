// 	-- 예제 출처 https://sas-study.tistory.com/108


package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExam2 {
	public static void main(String[] args) {
		String array[] = {"홍길동","아무개","하하하","호호호","히히히"};
		
		Stream<String> stream = Arrays.stream(array);
		// stream.forEach(name -> System.out.println(name));
		stream.forEach(name -> {
			System.out.println("이름 : " + name);
			System.out.println("성 : " + name.substring(0, 1));
			System.out.println("이름의 길이 : " + name.length());
		});
	}
}
