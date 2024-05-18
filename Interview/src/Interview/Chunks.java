package Interview;

import java.util.ArrayList;

public class Chunks {

	public static void main(String[] args) {
		
		ArrayList<Integer> list= new ArrayList();
		
		for(int i=1;i<=100;i++)
		{
			list.add(i);
		}
		
		boolean flag= true;
		int start =0;
		int max=6;
		int size=list.size();
		
		while(flag)
		{
			
			System.out.println(list.subList(start, max));
			
			
			start=max;
			max=max+6;
			
			if(size < max)
			{
				System.out.println(list.subList(start, size));
				flag=false;
			}
			
		}

	}

}
