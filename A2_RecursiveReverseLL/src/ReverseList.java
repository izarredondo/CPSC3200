
public class ReverseList {


	static Node head;

	static class Node

	{

	int data;

	Node next;

	Node(int a)

	{

	data = a;

	next = null;

	}

	}

	Node reverse(Node node)

	{

	Node previous = null;

	Node current = node;

	Node next = null;

	while ( current !=null){

	next = current .next;

	current.next = previous;

	previous = current;

	current = next;

	}

	node = previous;

	return node;

	}

	void printList(Node node) {

	while(node !=null)

	{

	System.out.println(node.data + " ");

	node = node.next;

	}

	}

	public static void main(String [] args ){

	ReverseList list = new ReverseList();

	list.head= new Node(74);

	list.head.next= new Node(80);

	list.head.next.next= new Node(87);

	list.head.next.next.next= new Node(28);

	list.head.next.next.next.next= new Node(83);

	System.out.println("The singly linked list is:");

	list.printList(head);

	head=list.reverse(head);

	System.out.println(" ");

	System.out.println("the reversed singly linked list is:");

	list.printList(head);

	}

	}

