package linkedList;

public class LinkedList {

	Node head;
	
	
	public class Node {
		Node next;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
	public void addFirst(int data) {
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			return;
		}
		
		Node crnt = new Node(data);
		crnt.next = head;
		head = crnt;
			
	}
	
	
	public void addLast(int data) {
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			return;
		}
		Node crnt = head;

		while (crnt.next != null) {
			crnt = crnt.next;
		}
		crnt.next = node;			
	}
	
	public void removeFirst() {
		if(head == null)
			return;
		
		head = head.next;
	}
	
	public void removeLast() {
		
		if(head == null) {
			return;
		}
		
		if(head.next == null) {
			head = null;
			return;
		}
		
		Node crnt = head;
		Node prev = null;
		
		while(crnt.next != null) {
			prev = crnt;
			crnt = crnt.next;
		}
		prev.next = null;
	}
	
	// index로 값찾기
	public int searchNode(int index) {
		
		if(head == null) {
			System.out.println("비어있습니다.");
			return -1;
		}
		
		else {
			Node crnt = head;
			
			for (int i = 0; i < index; i++) {
				if(crnt.next == null)
					return -1;
				crnt = crnt.next;
			}
			
			return crnt.data;
		}
	}
	
	// 값으로 인덱스 찾기
	public int searchIndex(int data) {
		if(head == null) {
			System.out.println("비어있습니다.");
			return -1;
		}
		
		Node node = new Node(data);
		Node crnt = head;
		
		int idx = 0;
		
		while(crnt.data != node.data) {
			crnt = crnt.next;
			idx++;
		}
		
		return idx;
		
	}
	
	
	public void print() {
        Node current = head;
        if (head == null) {
            System.out.println("empty.");
            return;
        }

        while (current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print(current.data + "\n");
    }
}
