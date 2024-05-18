package Interview;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a= {1,3,8,19,30,76,3,4,1};
		
		int sizeOfarray=a.length;
		
		for(int i=0;i<a.length-1;i++)
		{
			for (int j=0 ; j<a.length-1;j++)
			{
				//System.out.println(a[j]);
				if(a[j] > a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					
				}
			}
		}
		
		
		System.out.println(Arrays.toString(a));
		

	}

}
