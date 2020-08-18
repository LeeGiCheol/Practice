// Comparator 객체를 생성하여 Collections나 배열 등을 정렬할 수 있다
// 익명함수나 람다식으로 사용 가능하다

package incorrectAnswerSheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


public class ComparatorAnonymous {
	public static void comparatorExam() {
		List<String> strings = new ArrayList<>();
	    strings.add("This code is free software");
	    strings.add("you can redistribute it");
	    strings.add("under the terms of the GNU General Public License version 2 only");
	    strings.add("This code is distributed in the hope that it will be useful");
	    strings.add("Please contact Oracle");
	    strings.add("500 Oracle Parkway, Redwood Shores, CA 94065 USA");

		// sort 전에 출력해서 확인
	    for (String str : strings) {
			System.out.println(str);
		}
	    
	    // 익명함수를 통해 문자열 길이를 비교해 sort
	    Collections.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
	    });
	    
	    System.out.println();
	    
	    // sort후 출력
	    for (String str : strings) {
			System.out.println(str);
		}
	    
	}


	public static void main(String[] args) {
		comparatorExam();
	}
}
