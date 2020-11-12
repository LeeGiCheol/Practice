/*
 
	This problem is all about unit testing.
	
	Your company needs a function that meets the following requirements:
	
	For a given array of n integers, the function returns the index of the element with the minimum value in the array. If there is more than one element with the minimum value, the returned index should be the smallest one.
	If an empty array is passed to the function, it should raise an Exception.
	Note: The arrays are indexed from 0.
	
	Another co-worker has prepared functions that will perform the testing and validate returned results with expectations. Your task is to implement 3 classes that will produce test data and the expected results for the testing functions. More specifically: function get_array() in TestDataEmptyArray class and functions get_array() and get_expected_result() in classes TestDataUniqueValues and TestDataExactlyTwoDifferentMinimums following the below specifications:
	
	get_array() method in class TestDataEmptyArray has to return an empty array.
	get_array() method in class TestDataUniqueValues has to return an array of size at least 2 with all unique elements, while method get_expected_result() of this class has to return the expected minimum value index for this array.
	get_array() method in class TestDataExactlyTwoDifferentMinimums has to return an array where there are exactly two different minimum values, while method get_expected_result() of this class has to return the expected minimum value index for this array.
	Take a look at the code template to see the exact implementation of functions that your colleagues already implemented.
	
	
	
	---풀이---
	메인 메서드를 보면 
	TestWithEmptyArray();
	TestWithUniqueValues();
	TestWithExactlyTwoDifferentMinimums();
	총 3개의 메서드가 호출되어있다.
	내부를 살펴보니 테스트코드작성이 아니라
	이 메서드에 맞게 테스트를 해보라는 것으로 알아들었다.
	
	
	상단 3개의 클래스안에는 get_array 혹은 get_array와 get_expected_result 메서드를 가진다.
	
	TestDataEmptyArray 클래스의 get_array()는 비어있는 배열을 리턴하고,
	TestDataUniqueValues 클래스의 get_array()는 사이즈가 최소 2 이상인 각자 다른 값을 가진 배열을 리턴,
	TestDataExactlyTwoDifferentMinimums 클래스의 get_array()는 최소값이 2개인 배열을 리턴,  
	get_expected_result()는 몇번 인덱스에 최소값이 위치하는지 리턴한다.
	
 */

package hackerRank30DaysOfCode;

import java.util.*;

public class Day27_Testing {

	public static int minimum_index(int[] seq) {
		if (seq.length == 0) {
			throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");
		}
		int min_idx = 0;
		for (int i = 1; i < seq.length; ++i) {
			if (seq[i] < seq[min_idx]) {
				min_idx = i;
			}
		}
		return min_idx;
	}

	static class TestDataEmptyArray {
		public static int[] get_array() {
			// complete this function
			return new int[] {};
		}
	}

	static class TestDataUniqueValues {
		public static int[] get_array() {
			// complete this function
			return new int[] {1, 2, 3};
		}

		public static int get_expected_result() {
			// complete this function
			return 0;
		}
	}

	static class TestDataExactlyTwoDifferentMinimums {
		public static int[] get_array() {
			// complete this function
			return new int[] {4, 2, 3, 2};
		}

		public static int get_expected_result() {
			// complete this function
			return 1;
		}
	}

	public static void TestWithEmptyArray() {
		try {
			int[] seq = TestDataEmptyArray.get_array();
			int result = minimum_index(seq);
		} catch (IllegalArgumentException e) {
			return;
		}
		throw new AssertionError("Exception wasn't thrown as expected");
	}

	public static void TestWithUniqueValues() {
		int[] seq = TestDataUniqueValues.get_array();
		if (seq.length < 2) {
			throw new AssertionError("less than 2 elements in the array");
		}

		Integer[] tmp = new Integer[seq.length];
		for (int i = 0; i < seq.length; ++i) {
			tmp[i] = Integer.valueOf(seq[i]);
		}
		if (!((new LinkedHashSet<Integer>(Arrays.asList(tmp))).size() == seq.length)) {
			throw new AssertionError("not all values are unique");
		}

		int expected_result = TestDataUniqueValues.get_expected_result();
		int result = minimum_index(seq);
		if (result != expected_result) {
			throw new AssertionError("result is different than the expected result");
		}
	}

	public static void TestWithExactlyTwoDifferentMinimums() {
		int[] seq = TestDataExactlyTwoDifferentMinimums.get_array();
		if (seq.length < 2) {
			throw new AssertionError("less than 2 elements in the array");
		}

		int[] tmp = seq.clone();
		Arrays.sort(tmp);
		if (!(tmp[0] == tmp[1] && (tmp.length == 2 || tmp[1] < tmp[2]))) {
			throw new AssertionError("there are not exactly two minimums in the array");
		}

		int expected_result = TestDataExactlyTwoDifferentMinimums.get_expected_result();
		int result = minimum_index(seq);
		if (result != expected_result) {
			throw new AssertionError("result is different than the expected result");
		}
	}

	public static void main(String[] args) {
		TestWithEmptyArray();
		TestWithUniqueValues();
		TestWithExactlyTwoDifferentMinimums();
		System.out.println("OK");
	}
}
