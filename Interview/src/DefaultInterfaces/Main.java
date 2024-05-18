package DefaultInterfaces;

interface c
{
	
	default void m1()
	{
		System.out.println(" from interface c.................");
	}
}

public class Main implements c {

	public static void main(String[] args) {
	
c c1=new Main();
c1.m1();
	}

}
