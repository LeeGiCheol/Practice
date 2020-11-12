/*
 
	Objective
	Today, we're working with Binary Search Trees (BSTs). Check out the Tutorial tab for learning materials and an instructional video!
	
	Task
	The height of a binary search tree is the number of edges between the tree's root and its furthest leaf. You are given a pointer, root, pointing to the root of a binary search tree. Complete the getHeight function provided in your editor so that it returns the height of the binary search tree.
	
	Input Format
	
	The locked stub code in your editor reads the following inputs and assembles them into a binary search tree:
	The first line contains an integer, n, denoting the number of nodes in the tree.
	Each of the n subsequent lines contains an integer, data, denoting the value of an element that must be added to the BST.
	
	Output Format
	
	The locked stub code in your editor will print the integer returned by your getHeight function denoting the height of the BST.
	
	Sample Input
	
	7
	3
	5
	2
	1
	4
	6
	7
	Sample Output
	
	3
	
	
	---풀이---
	BST 같은 경우엔 3~4월쯤에 한참 공부를 했었다.
	삽입 삭제 조회까지, 그렇지만 지금다시 만들어보라고하면 못할 것 같다고 생각했었는데
	마침 문제로 나와줬다. 원했던 문제는 아니지만 깊이를 구하는 메서드를 만드는 문제였다.
	재귀함수를 통해 문제풀이를 했다.
	
	사실 문제풀이보단 그 당시 문제 풀이했을 때와 
	다른 방식으로 insert 메서드가 짜여져 있어서 더욱 공부가 된 것 같다.
	재귀함수는 전혀 생각도 못했었는데, 역시 재귀함수가 짧고 간결하게 풀이할 수 있는 것 같다.
	
 */

package hackerRank30DaysOfCode;

import java.util.*;

class Node2 {
	Node2 left, right;
	int data;

	Node2(int data) {
		this.data = data;
		left = right = null;
	}
}



public class Day22_BinarySearchTree {

	public static int getHeight(Node2 root) {
		if (root == null)
			return -1;

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		return Math.max(left, right) + 1;
	}

	public static Node2 insert(Node2 root, int data) {
		if (root == null) {
			return new Node2(data);
		} else {
			Node2 cur;
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
		Node2 root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		int height = getHeight(root);
		System.out.println(height);
	}
}