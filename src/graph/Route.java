package graph;

import java.util.LinkedList;

import graph.Graph.Node;

public class Route {

	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		
		Node(int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	Node[] nodes;
	
	Route(int size) {
		nodes = new Node[size];
		
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
		
	}
	
	
	
	void initMarks() {
		for(Node n : nodes) {
			n.marked = false;
		}
	}
	
	
	boolean search(int i1, int i2) {
		return search(nodes[i1], nodes[i2]);
	}
	
	boolean search(Node start, Node end) {
		initMarks();
		LinkedList<Node> q = new LinkedList<Node>();
		
		q.add(start);
		
		while(!q.isEmpty()) {
			Node root = q.removeFirst();
			
			if(root == end) {
				return true;
			}
			
			for (Node n : root.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					q.add(n);
				}
				
			}
		}
		
		return false;
	}
}
