package Interview;

public class Fibnoic {
	public static void main(String [] args)
	{
		int a =0;
		int b=1;
		int c=0;
		
	//	0112358
		
		
		for(int i=0;i<100;i++)
		{
			
			if(i==0 || i==1)
			{
				c=a+i;
				System.out.println(c);
			}
			
			
			else
			{
			c=a+b;
			System.out.println(c);
			a=b;
			b=c;
			
			}
			
		}
		
	}

}
