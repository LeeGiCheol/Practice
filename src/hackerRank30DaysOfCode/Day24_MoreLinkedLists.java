/*
	Objective
	Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	A Node class is provided for you in the editor. A Node object has an integer data field, , and a Node instance pointer, , pointing to another Node (i.e.: the next Node in a list).
	
	A removeDuplicates function is declared in your editor, which takes a pointer to the  Node of a linked list as a parameter. Complete removeDuplicates so that it deletes any duplicate Nodes from the list and returns the head of the updated list.
	
	Note: The  pointer may be null, indicating that the list is empty. Be sure to reset your  pointer when performing deletions to avoid breaking the list.
	
	Input Format
	
	You do not need to read any input from stdin. The following input is handled by the locked stub code and passed to the removeDuplicates function:
	The first line contains an integer, , the number of Nodes to be inserted.
	The  subsequent lines each contain an integer describing the  value of a Node being inserted at the list's tail.
	
	Constraints
	
	The data elements of the linked list argument will always be in non-decreasing order.
	Output Format
	
	Your removeDuplicates function should return the head of the updated linked list. The locked stub code in your editor will print the returned list to stdout.
	
	Sample Input
	
	6
	1
	2
	2
	3
	3
	4
	Sample Output
	
	1 2 3 4 
	
	
	---풀이---
	영어가 잘 이해 안되었다.
	그래서 평소보다 더 해석에 신경을 썼다.
	 
	사실 LinkedList 문제이고, removeDuplicates란 메서드만 봐도
	어떤 문제일지는 감이왔었다. 이게 클린코드 책에서 말한 이름의 중요성인 것 같다.
	
	아무튼, 처음엔 아래 주석처럼 풀이를 했다.
	당연히 맞겠거니 제출을 했더니 5개 Test 중에 2개가 틀렸다고 나왔다.
	
	바로 디버깅을 하다가 깨달았다.
	아, 마지막 Node를 검사하면서 next node가 존재하지 않을 수도 있구나.
	그래서 innerLoop 조건에 ptr.next != null 라는 예외처리를 해주었다.
	마찬가지로 outerLoop 조건에 ptr != null을 추가해주어 예외처리를 해주었다.
	
	
 */
package hackerRank30DaysOfCode;



import java.util.Scanner;

class Node4 {
	int data;
	Node4 next;

	Node4(int d) {
		data = d;
		next = null;
	}

}

public class Day24_MoreLinkedLists {

	public static Node4 removeDuplicates(Node4 head) {
		Node4 ptr = head;
		
		while(ptr != null && ptr.next != null) {
			while(ptr.next != null && ptr.data == ptr.next.data) {
				ptr.next = ptr.next.next;
			}
			ptr = ptr.next;
		}
		return head;
	}
	
//		Node4 ptr = head;
//		
//		while(ptr.next != null) {
//			while(ptr.data == ptr.next.data) {
//				ptr.next = ptr.next.next;
//			}
//			ptr = ptr.next;
//		}
//		return head;
//	}

	public static Node4 insert(Node4 head, int data) {
		Node4 p = new Node4(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			Node4 start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}

	public static void display(Node4 head) {
		Node4 start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node4 head = null;
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		head = removeDuplicates(head);
		display(head);

	}
}
