public class ScoreboardLinkedlistTester {
	public static void main(String args[])
	{
		ScoreboardLinkedlist<GameEntry> llist = new ScoreboardLinkedlist<GameEntry>();
		GameEntry one = new GameEntry("a", 1);
		int oneS = one.getScore();
		GameEntry two = new GameEntry("b", 2);
		int twoS = two.getScore();
		GameEntry three = new GameEntry("c", 3);
		int threeS = three.getScore();
		GameEntry four = new GameEntry("d", 4);
		int fourS = four.getScore();
		
		//llist.addFirst(two);
		//llist.addFirst(one);
		//llist.addFirst(four);
		//llist.addFirst(three);
		
		llist.add(two);
		llist.add(one);
		llist.add(four);
		llist.add(three);
		
		llist.printList();
		
		//llist.removeFirst();
		//llist.sort();
		
		//llist.addAfter(three, two);
		//llist.shiftRight();
		//llist.printList();
	}
}
