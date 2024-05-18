package com.interview.Thread;

public class Threadyeild {

	public static void main(String[] args) {
		
		Thread t1= new Thread(()->
		
		{
			Thread.yield();
			
			System.out.println("Thead ------------------"+Thread.currentThread().getName());
		});


Thread t2= new Thread(()->

{
	
	try
	{
	//t1.join();
	
	}catch(Exception e)
	{
		
	}
	
	System.out.println("Thead ------------------"+Thread.currentThread().getName());
});


Thread t3= new Thread(()->

{
	try
	{
	//t2.join();
	
	}catch(Exception e)
	{
		
	}
	
	System.out.println("Thead ------------------"+Thread.currentThread().getName());
});

t1.setName("siva");
t2.setName("siva1");
t3.setName("siva2");

t1.start();
t3.start();
t2.start();

	}

}
