
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Postfix {
	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		List<Object> ll = new ArrayList<Object>();		



		System.out.println("Enter postfix expression: ");

		//		while(in.hasNext())
		//		{
		//			Object next = in.next();
		//			ll.add(next);
		//		}
		
		
		while(in.hasNext())
		{
			Object next = in.next();
			
		    if(next.equals("!")) {
		        break;
		    }
		    else{
		    	ll.add(next);
		    }
		}
		//System.out.println(evalPostfix(ll));

		//System.out.println(ll);
//		for (Object s : ll) {
//		    System.out.println(s);
//		}
		
		evalPostfix(ll);
	}


	

	public static int evalPostfix(List<Object> ll){
		Stack s = new Stack();
		Object data, x, y;
		boolean validExpression;
		int count = 0;
		int size = s.size();
		int result;

		while(ll.iterator().hasNext())
		{	
			data = ll.iterator().next();
			//if(data instanceof Number)
			if(ll.iterator().has))
			{
				s.push(data);
			}
			else
			{
				y = s.pop();
				x = s.pop();
				if(data == "+"){
					s.push((int)x + (int)y);
				}
				if(data == "-"){
					s.push((int)x - (int)y);
				}
				if(data == "*"){
					s.push((int)x * (int)y);
				}
				if(data == "/"){
					s.push((int)x / (int)y);
				}
			}
		}

		return result = (int) s.pop();
	}
}

