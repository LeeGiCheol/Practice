/*
	필통안의 내용물을 모두 보고싶은 경우이다.
	Iterator와 Stream을 활용한 코드이다.
	
	두가지 모두 일회용이니 참고할 것
	
	-- 예제 출처 https://sas-study.tistory.com/108
 */

package stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExam {
	public static void main(String[] args) {
		List<String> pencilCase = new ArrayList<String>();
		pencilCase.add("볼펜");
		pencilCase.add("지우개");
		pencilCase.add("샤프");
		pencilCase.add("형광펜");
		pencilCase.add("커터칼");
		
		// Iterator를 사용할 경우
		Iterator<String> iter = pencilCase.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		
		// Stream을 사용할 경우
		Stream<String> stream = pencilCase.stream();
		stream.forEach(s -> System.out.println(s));
		
	}
}
