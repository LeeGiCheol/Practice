package linkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addLast(1);
		ll.addLast(4);
		ll.addLast(2);
		ll.addLast(7);
		ll.addLast(8);
		ll.addLast(11);
		ll.addFirst(23);
		ll.addFirst(24);
		ll.print();
		
//		ll.removeFirst();
//		ll.removeLast();
		System.out.println(ll.searchNode(4));
		System.out.println(ll.searchIndex(23));
//		ll.print();
		
//		ll.print();
	}
}
