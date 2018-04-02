/**
 * Izabella Arredondo
 * CPSC 3200 
 * Dr. Wu
 * Assignment 2 Problem 1
 * 
 * The class contains a reverse method that reverses the order of the nodes 
 * in a linked list and a print method to display the results. 
 * 
 * Method adapted from source:
 * IDeserve
 * https://www.youtube.com/watch?v=MRe3UsRadKw
 *
 */

public class ReverseLL<E> {
	
	// head of linked list 
	static Node head;
	
	// main method to test class
	public static void main(String [] args ){
		
		// create new list
		ReverseLL ll = new ReverseLL();		
		
		// add elements to list
		ll.head = new Node(1);
		ll.head.next = new Node(2);
		ll.head.next.next = new Node(3);
		ll.head.next.next.next = new Node(4);
		ll.head.next.next.next.next = new Node(5);
		
		// print original list
		System.out.println("Original List: ");
		ll.print(head);
		
		// reverse list
		recursiveReverse(head);
		
		// print reversed list
		System.out.println("Reversed List: ");
		ll.print(head);
	}
	
	// Node class
	public static class Node<E>{
		private E element;
		private Node<E> next;
		
		public Node(E e){
			element = e;
			next = null;
		}
		
		// method to return next node
		public Node getNext(){
			return next;
		}
		
		// method to set next node to another
		public void setNext(Node n){
			next = n;
		}
	}
	
	// recursive method to reverse the order of list
	private static void recursiveReverse(Node node){
		Node curr = node;
		
		// base case
		if(curr == null){				
			return;
		}
		
		// base case: if at last node, make it the head
		// method can now start reversing nodes
		if(curr.getNext() == null){		
			head = curr;
			return;
		}
		
		// recursive call to traverse list to tail
		recursiveReverse(curr.getNext());
		
		// after assigning last node to head,
		// return to previous recursive call,
		// and make current's next point to current
		curr.getNext().setNext(curr);
		
		// set current's next to null so that 
		// the next call will set its next to 
		// preceding node, and when the call is complete
		// the original head will point to null making it
		// the tail 
		curr.setNext(null);
	}
	
	void print(Node<E> node)
	{
		while (node != null)
		{
			System.out.print(node.element + " ");
			node = node.next;
		}
		System.out.println();
	}
}
