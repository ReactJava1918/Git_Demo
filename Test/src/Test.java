

//Write a function to split a large array into smaller arrays, each with a maximum of n elements.
//Example 1 input: [5,7,3,9,4,6,3,8,0,2,5]
//expected output with max elements 4 => [ [5,7,3,9], [4,6,3,8], [0,2,5] ]
//expected output with max elements 3 => [ [5,7,3], [9,4,6], [3,8,0], [2,5] ]

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		int  [] data= {5,7,3,9,4,6,3,8,0,2,5};
		
		StringBuffer s= new StringBuffer();
		for(int i=0;i<data.length;i++)
		{
			s.append(","+data[i]);
		}
		
		ArrayList<String> a= new ArrayList<String>();
		System.out.println(s);
		
		a.add(s.substring(0,4));
		a.add(s.substring(5,8));
		a.add(s.substring(9,10));
		 
		
		System.out.println(a);
		

	}

}
