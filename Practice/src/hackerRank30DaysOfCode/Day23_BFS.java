/*
	Objective
	Today, we're going further with Binary Search Trees. Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	A level-order traversal, also known as a breadth-first search, visits each level of a tree's nodes from left to right, top to bottom. You are given a pointer, root, pointing to the root of a binary search tree. Complete the levelOrder function provided in your editor so that it prints the level-order traversal of the binary search tree.
	
	Hint: You'll find a queue helpful in completing this challenge.
	
	Input Format
	
	The locked stub code in your editor reads the following inputs and assembles them into a BST:
	The first line contains an integer, T (the number of test cases).
	The T subsequent lines each contain an integer, data, denoting the value of an element that must be added to the BST.
	
	Output Format
	
	Print the data value of each node in the tree's level-order traversal as a single line of N space-separated integers.
	
	Sample Input
	
	6
	3
	5
	4
	7
	2
	1
	
	Sample Output
	
	3 2 5 1 4 7 
	
	
	---풀이---
	Breadth First Search (BFS) 문제이다.
	사실 BFS를 처음 접해봤다.
	Queue를 사용해서 풀이하라고 안내가 되어있긴 하지만,
	감이 잘안왔다. while문과 재귀함수로 풀이를 해보려했지만 잘안됬다.
	결국 제타위키에서 정답을 보고 공부하는 방식으로 풀이했다.
	
	Queue안에 root를 넣고, peek로 확인 후
	해당 node의 값을 삭제 후 출력한다.
	그 node의 left, right를 확인 후 다시 Queue에 넣는다.
	
	이를 Queue가 비어질 때까지 반복한다.
	
	BFS 사진자료는 항상 Graph에 활용된 사진만 있어서 더욱 감이 안 왔다.
	자료구조 공부할 때 Graph를 공부 못한것이 너무 아쉽다.
	
	문제를 풀이해보니 Queue로 구현하는 이유를 알 것 같다.
	
 */

package hackerRank30DaysOfCode;

import java.util.*;

class Node3 {
	Node3 left, right;
	int data;

	Node3(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Day23_BFS {

	static void levelOrder(Node3 root) {
		Queue<Node3> queue = new LinkedList<Node3>();
		queue.add(root);
		
		while(queue.peek() != null) {
			Node3 node = queue.remove();
			System.out.printf("%d ", node.data);
			
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) { 
				queue.add(node.right);
			}
		}
	}

	public static Node3 insert(Node3 root, int data) {
		if (root == null) {
			return new Node3(data);
		} else {
			Node3 cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node3 root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		levelOrder(root);
	}
}
