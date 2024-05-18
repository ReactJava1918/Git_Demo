package Interview;

import java.util.LinkedList;

public class StringValidatorWithBrackets {

	public static void main(String[] args) {
		String a="{}{}{)[abc]";
		String arr[]=a.split("");
		
		LinkedList openList =new LinkedList<String>();
		LinkedList closedList =new LinkedList<String>();
		
		for(int i=0;i<=arr.length-1;i++)
		{
			
				if(arr[i].equals("{")|| arr[i].equals("(")|| arr[i].equals("["))
				{
					openList.add(arr[i]);
				}
				
				else if(arr[i].equals("}")|| arr[i].equals(")")|| arr[i].equals("]"))
				{;
					closedList.add(arr[i]);
				}
			
			
		}
		
		
		System.out.println(openList);
		System.out.println(closedList);
		
		if(openList.size() == closedList.size() )
		{
			 for(int i=0 ; i< openList.size()-1; i++)
			 {
				 String check=(String)openList.get(i)+(String)closedList.get(i);
				 if(check.equals("{}") || check.equals("()") || check.equals("[]") )
				 {
					 System.out.println("valid String----------------check"+check) ;
						
				 }
				 
				 else
				 {
					System.out.println("not a valid String----------------check"+check) ;
					
					break;
				
				 }
				 
				 }
			 }
			
			
		}

	

}
