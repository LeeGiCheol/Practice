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
	
	
	public void append(int data) {
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

	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(4);
		ll.append(2);
		ll.append(7);
		ll.append(8);
		ll.append(11);
		ll.print();
		
	}
	
	
}
