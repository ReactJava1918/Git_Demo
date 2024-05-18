package Interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DulicatesRemoval {
	
	public static void main(String [] args)
	{
		String s="8976564567123";
		String s1[]=s.split("");
		
		

		String temp=null;
		
		
		//String afterJoining=Arrays.stream(s.split("")).distinct().collect(Collectors.joining("-"));
		//System.out.println(afterJoining);
		//String afterJoiningsorted=Arrays.stream(s.split("")).distinct().sorted().collect(Collectors.joining("-"));
		//System.out.println(afterJoiningsorted);
		//String afterJoiningreversesorted=Arrays.stream(s.split("")).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.joining("-"));
		//System.out.println(afterJoiningreversesorted);
		
		for(int i=0;i<s1.length-1;i++)
		{
			for(int j=0;j<s1.length-1;j++)
			{
				
				 int number=s1[j].compareTo(s1[j+1]);
				 
				 if(number>0)
				 {
					 temp=s1[j];
					 s1[j]=s1[j+1];
					 s1[j+1]=temp;
				 }
				
				
			}
			
		}
		
		
		System.out.println("sort----------------------");
		for(int i=0;i<s1.length;i++)
		{
			System.out.println(s1[i]);
			
		}
		
		
		System.out.println("Remove Duplicates----------------------");
		
		int duplicateRemovalSize = s1.length;
		
		
		for(int i= 0;i<duplicateRemovalSize;i++)
		{
			for(int j=i+1;j<duplicateRemovalSize;j++)
			{
				
				if(s1[i].equals(s1[j]))
				{
					
					
					for(int k=j;k<duplicateRemovalSize-1;k++)
					{
						s1[k]=s1[k+1];
					}
					
					duplicateRemovalSize--;
					j--;
				}
				
				
			}
			
		}
		
		
		
		for(int i=0;i<duplicateRemovalSize;i++)
		{
			System.out.println(s1[i]);
			
		}
	
		 
		
		
	}

}
