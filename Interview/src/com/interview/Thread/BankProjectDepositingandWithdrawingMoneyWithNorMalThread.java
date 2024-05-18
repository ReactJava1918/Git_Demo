package com.interview.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BankThread
{
	int totalamount=10;
	
	public synchronized void withdraw(int amountWithdraw) throws InterruptedException
	{
		
		if(amountWithdraw > totalamount )
		{
			System.out.println("Here thread will wait "+Thread.currentThread().getName());
			this.wait();
			totalamount	=totalamount-amountWithdraw;
			System.out.println("successfully withdrawn now total amount is "+totalamount);
		}
		
		
		 
	}
	
	public synchronized void deposit (int depositMoney)
	{
		
		totalamount=totalamount+depositMoney;
		System.out.println("Money deposited by thread  "+Thread.currentThread().getName());
		this.notifyAll();
		
	}
	
	
	
	
}

public class BankProjectDepositingandWithdrawingMoneyWithNorMalThread {
	public static void main(String[] args) {

		
		//normalThreadFlow();
	
		executorServiceFlow();
		
		
		

	}

	private static void executorServiceFlow() {
		
		BankThread bankThread = new BankThread();
		 ExecutorService executorService = Executors.newFixedThreadPool(2);
		 
		 executorService.submit(()->{
			 
			 try
				{
				bankThread.withdraw(100);
				
				}catch(Exception e)
				{
					
				}
			 
		 });
		 
		 
 executorService.submit(()->{
	 bankThread.deposit(200);
			 
		 });
		 
		// TODO Auto-generated method stub
		
	}

	private static void normalThreadFlow() {
		BankThread bankThread = new BankThread();
		// By using Normal Thread creation
		
		Thread t1 = new Thread(()->
		{
		  
			try
			{
			bankThread.withdraw(100);
			
			}catch(Exception e)
			{
				
			}
			
			
		});
		
		
		Thread t2 = new Thread(()->
		{
		  
			try
			{
			bankThread.deposit(200);
			
			}catch(Exception e)
			{
				
			}
			
			
		});
		
		t1.setName("Withdraw");
		t2.setName("deposit");
		t1.start();
		t2.start();
	}

}
