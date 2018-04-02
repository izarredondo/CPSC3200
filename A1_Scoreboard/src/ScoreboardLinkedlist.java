public class ScoreboardLinkedlist<E> {
	private static class Node<E>
	{
		private E element;
		private Node<E> next;
		private int score;
		
		public Node(E e, Node<E> n)
		{
			element = e;
			next = n;
		}
		
		public Node(GameEntry g)
		{
			score = g.getScore();
		}
		
		public E getElement()
		{
			return element;
		}
		
		public Node<E> getNext()
		{
			return next;
		}
		
		public void setNext(Node<E> n)
		{
			next = n;
		}
		
//		public int getScore(GameEntry g)
//		{
//			return g.getScore(); 
//		}
		
	} // end nested node
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public ScoreboardLinkedlist() {}
	
	/* Accessor Methods */
	public int size() 
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public E first() 
	{
		if(isEmpty())
		{
			return null;
		}
		
		return head.getElement();
	}
	
	public E last() 
	{
		if(isEmpty())
		{
			return null;
		}
		
		return tail.getElement();
	}
	
	void printList()
	{
		Node temp = head;
		while (temp != null)
		{
			System.out.println(temp.getElement().toString());
			temp = temp.next;
		}

		System.out.println();
	}
	
	/* Mutator Methods */
	
	public void shiftLeft()
	{
		if(head == null || head.next == null){
		       return;    
		    }
		    Node<E> temp = new Node<E>(null, head.next);     
		    temp = head;           
		    head = head.next;  
		    temp.next = null;   
		    tail.next = temp;  
		    tail = temp; 
	}  
	
	public void add(E e)
	{
		Node newest = new Node(e, null);
		int newScore = newest.score;
		
		// check for elements
		if(isEmpty())
		{
			head = newest;
		}
		else
		{
			Node temp = head;
			Node beforeTemp = head;
			
			while(temp.getNext() != null 
					&& temp.score >= newScore)
			{
				beforeTemp = temp;
				temp = temp.next;
			}
			
			if(temp.next == null)
			{
				if(temp.score < newScore)
				{
					if(temp == head)
					{
						head = newest;
					}
					else
					{
						beforeTemp.setNext(newest);
					}
					newest.setNext(temp);
				}
				else
				{
					temp.setNext(newest);
				}
			}
			else if(temp.score < newScore)
			{
				if(temp == head)
				{
					head = newest;
				}
				else
				{
					beforeTemp.setNext(newest);
				}
				newest.setNext(temp);
			}
		}
	}
	
	
	
	public void addFirst(E e)
	{
		head = new Node<>(e, head);
		
		if(size == 0)
		{
			tail = head;
		}
		
		size++;
				
	}
	
	
	public void addLast(E e)
	{
		Node<E> newest = new Node<>(e, null);
		
		if(isEmpty())
		{
			head = newest;
		}
		else
		{
			tail.setNext(newest);
		}
		
		tail = newest;
		size++;
	}
	
	public E removeFirst()
	{
		if (isEmpty())
		{
			return null;
		}
		
		E answer = head.getElement();
		head = head.getNext();
		size--;
		
		if(size == 0)
		{
			tail = null;
		}
		return answer;
	}
	
	/* Methods to Sort List*/
	
	/* This is the main function that sorts
    the linked list.*/
	void sort()
	{
		Node temp = head.next;
		Node temp2 = head.next;
		
		/* Create 2 dummy nodes and initialize as
        heads of linked lists */
		Node Ahead = new Node(0, temp), Dhead = new Node(0, temp2);


		// Split the list into lists
		splitList(Ahead, Dhead);

		Ahead = Ahead.next;
		Dhead = Dhead.next;

		// reverse the descending list
		Dhead = reverseList(Dhead);

		// merge the 2 linked lists
		head = mergeList(Ahead,Dhead);
	}

	/* Function to reverse the linked list */
	Node reverseList(Node Dhead)
	{
		Node current = Dhead;
		Node prev = null;
		Node next;
		while (current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		Dhead = prev;
		return Dhead;
	}

	// A utility function to merge two sorted linked lists
	Node mergeList(Node head1, Node head2)
	{
		// Base cases
		if (head1 == null) return head2;
		if (head2 == null) return head1;

		Node temp = null;
		//if (head1.data < head2.data)
		if (head1.score < head2.score)
		{
			temp = head1;
			head1.next = mergeList(head1.next, head2);
		}
		else
		{
			temp = head2;
			head2.next = mergeList(head1, head2.next);
		}
		return temp;
	}

	// This function alternatively splits a linked list with head
	// as head into two:
	// For example, 10->20->30->15->40->7 is split into 10->30->40
	// and 20->15->7
	// "Ahead" is reference to head of ascending linked list
	// "Dhead" is reference to head of descending linked list
	void splitList(Node Ahead, Node Dhead)
	{
		Node ascn = Ahead;
		Node dscn = Dhead;
		Node curr = head;

		// Link alternate nodes

		while (curr != null)
		{
			// Link alternate nodes in ascending order
			ascn.next = curr;
			ascn = ascn.next;
			curr = curr.next;

			if (curr != null)
			{
				dscn.next = curr;
				dscn = dscn.next;
				curr = curr.next;
			}
		}

		ascn.next = null;
		dscn.next = null;
	}
}
