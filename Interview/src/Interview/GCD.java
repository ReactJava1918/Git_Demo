package Interview;

public class GCD {

	public static void main(String[] args) {
	
		int firstNumber=50;
		int secondNumber=60;
		int gcd=0;
		
		
		for(int i=1;i<=firstNumber && i<secondNumber;i++)
		{
			
			if(firstNumber%i==0 && secondNumber%i==0)
			{
				gcd=i;
			}
			
			
		}
		
		System.out.println("GCD of given numbers are -"+gcd);

	}

}
