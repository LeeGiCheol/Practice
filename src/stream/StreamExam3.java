/*
	정렬 예제
	
	-- 예제 출처 https://sas-study.tistory.com/108

 */

package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamExam3 {
	public static void main(String[] args) {
		List<String> pencilCase = new ArrayList<String>();
		pencilCase.add("볼펜");
		pencilCase.add("지우개");
		pencilCase.add("샤프");
		pencilCase.add("형광펜");
		pencilCase.add("커터칼");
		
		// 라이브러리를 사용한 정렬 가나다 순으로 정렬함
		Collections.sort(pencilCase);
		System.out.println(pencilCase);
		System.out.println();
		
		// List 인터페이스의 sort 메서드를 사용한 정렬 lambda
		// 길이순서, 가나다순대로 정렬
		pencilCase.sort((s1,s2) -> s1.length() - s2.length());
		System.out.println(pencilCase);
		System.out.println();
		
		// Stream을 사용한 정렬
		Stream<String> stream = pencilCase.stream();
		stream.sorted((s1, s2) -> s2.length() - s1.length()).forEach(item -> System.out.println(item));
	}
}
