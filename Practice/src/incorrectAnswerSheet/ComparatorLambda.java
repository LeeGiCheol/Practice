// Comparator 객체를 생성하여 Collections나 배열 등을 정렬할 수 있다
// 익명함수나 람다식으로 사용 가능하다

package incorrectAnswerSheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorLambda {
	public void comparatorExam() {
		List<String> strings = new ArrayList<>();
	    strings.add("This code is free software");
	    strings.add("you can redistribute it");
	    strings.add("under the terms of the GNU General Public License version 2 only");
	    strings.add("This code is distributed in the hope that it will be useful");
	    strings.add("Please contact Oracle");
	    strings.add("500 Oracle Parkway, Redwood Shores, CA 94065 USA");

	    for (String str : strings) {
			System.out.println(str);
		}
	    
	    Collections.sort(strings, (s1, s2) -> s1.length() - s2.length());
	    
	    System.out.println();
	    
	    for (String str : strings) {
			System.out.println(str);
		}
	}
}
