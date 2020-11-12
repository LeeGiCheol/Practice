/*
	Objective
	Today, we're learning about Key-Value pair mappings using a Map or Dictionary data structure. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	Given n names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers. You will then be given an unknown number of names to query your phone book for. For each name queried, print the associated entry from your phone book on a new line in the form name=phoneNumber; if an entry for name is not found, print Not found instead.
	
	Note: Your phone book should be a Dictionary/Map/HashMap data structure.
	
	Input Format
	
	The first line contains an integer, n, denoting the number of entries in the phone book.
	Each of the n subsequent lines describes an entry in the form of 2 space-separated values on a single line. The first value is a friend's name, and the second value is an 8-digit phone number.
	
	After the n lines of phone book entries, there are an unknown number of lines of queries. Each line (query) contains a name to look up, and you must continue reading lines until there is no more input.
	
	Note: Names consist of lowercase English alphabetic letters and are first names only.
	
	Sample Input

	3
	sam 99912222
	tom 11122222
	harry 12299933
	sam
	edward
	harry
	
	Sample Output
	
	sam=99912222
	Not found
	harry=12299933
	
	
	--- 풀이 ---
	Map을 사용하는 문제였다.
	친구들의 전화번호를 통해서 전화번호부를 만들것이다.
	Key-Value(이름-전화번호)를 사용하는 Map을 활용한다.
	전화번호부를 조회할 때 이름=전화번호 형태로 출력하고,
	없는 이름일 경우, Not found를 출력한다.
	
	phoneBook이라는 맵객체를 하나 만들고,
	phoneBook에 바로 저장할 수 있도록
	이름과 전화번호를 입력하는 for문 안에서 put을 해주었다.
	
	while (scanner.hasNext())
	Iterator에서는 hasNext가 다음 요소가 있는지 확인하는 역할이였다.
	API를 확인해보니 입력값에 다른 토큰이 있다면 true를 반환한다고 되어있었다.
	
	아마도 무한루프를 노린듯.
	exit라고 입력시 루프를 탈출하도록 작성했다.
	
	containsKey() 메서드는 인자로 주어지는 key의 값이
	해당 맵 객체 안에 존재하는지 확인해주는 메서드이다.
	
	확인 후 존재한다면 get() 메서드를 통해 출력하고
	존재하지 않다면 Not found를 출력했다.
	
 */

package hackerRank30DaysOfCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day08_DictionariesAndMaps {

	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		Map<String, Integer> phoneBook = new HashMap<String, Integer>();
		
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int phone = in.nextInt();
			
			phoneBook.put(name, phone);
			
		}
		while (in.hasNext()) {
			String name = in.next();
			
			if(name.equals("exit"))
				break;
			
			if(phoneBook.containsKey(name)) {
				System.out.println(name + "=" + phoneBook.get(name));
			}
			else {
				System.out.println("Not found");
			}
		}
		in.close();
	}
}
