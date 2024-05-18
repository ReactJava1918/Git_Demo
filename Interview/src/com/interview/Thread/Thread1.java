package com.interview.Thread;
class A extends Thread
{
	@Override
	public void run()
	{
		
		System.out.println("executed run method");
		
	}
	
	
	
	
	}
	
class B  implements Runnable

{
	
	public void run()
	{
		
		System.out.println("executed from Thread "+Thread.currentThread().getName());
		
	}
	
	
}	

public class Thread1 {
	
	public static void main(String [] args)
	{
		
		A a=new A();
		a.start();
		//
		B b1 = new B();
		Thread t = new Thread(b1);
		t.start();
		
		//
		
		Thread t1 = new Thread(()->{
			
			System.out.println("executed from Thread "+Thread.currentThread().getName());
		});
		
Thread t2 = new Thread(()->{
			
			System.out.println("executed from Thread "+Thread.currentThread().getName());
		});

Thread t3 = new Thread(()->{
	
	System.out.println("executed from Thread "+Thread.currentThread().getName());
});

t1.start();
t2.start();
t3.start();
		
	}

}
