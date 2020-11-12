/*
	Objective
	Today we're working with Linked Lists. Check out the Tutorial tab for learning materials and an instructional video!
	
	A Node class is provided for you in the editor. A Node object has an integer data field, data, and a Node instance pointer, next, pointing to another node (i.e.: the next node in a list).
	
	A Node insert function is also declared in your editor. It has two parameters: a pointer, head, pointing to the first node of a linked list, and an integer data value that must be added to the end of the list as a new Node object.
	
	Task
	Complete the insert function in your editor so that it creates a new Node (pass data as the Node constructor argument) and inserts it at the tail of the linked list referenced by the head parameter. Once the new node is added, return the reference to the head node.
	
	Note: If the head argument passed to the insert function is null, then the initial list is empty.
	
	Input Format
	
	The insert function has 2 parameters: a pointer to a Node named head, and an integer value, data.
	The constructor for Node has 1 parameter: an integer value for the data field.
	
	You do not need to read anything from stdin.
	
	Output Format
	
	Your insert function should return a reference to the head node of the linked list.
	
	Sample Input
	
	The following input is handled for you by the locked code in the editor:
	The first line contains T, the number of test cases.
	The T subsequent lines of test cases each contain an integer to be inserted at the list's tail.
	
	4
	2
	3
	4
	1
	Sample Output
	
	The locked code in your editor prints the ordered data values for each element in your list as a single line of space-separated integers:
	
	2 3 4 1
	
	
	---풀이---
	사실 LinkedList는 꽤 많이 접해봤다.
	Doubly LinkedList도 구현을 해보았기 때문에
	간단하게 풀이할 수 있었다.
	
	먼저 insert 메서드 작성이었다.
	꼬리쪽으로 값을 넣는 메서드였는데,
	빈 노드일 경우 매개변수로 받은 data값을 return,
	빈 노드가 아닐 경우 while문을 통해 마지막 노드를 찾는다.
	그리고 마지막 노드.next에 crnt를 넣어주고 head를 return하면 끝이다.
	
	
 */

package hackerRank30DaysOfCode;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

public class Day15_LinkedList {

	public static Node insert(Node head, int data) {
		Node crnt = new Node(data);
		if(head == null) {
			return crnt;
		}
		
		Node node = head;
		
		while(node.next != null) {
			node = node.next;
		}
		node.next = crnt;
		
		return head;
		
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int N = sc.nextInt();

		while (N-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		display(head);
		sc.close();
	}
}
