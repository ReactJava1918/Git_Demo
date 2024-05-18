package com.interview.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintingExp {

    private Object lock = new Object();
    private int count = 1;
    

  
     
    public void implementPrint() {
   
        
    	while(count <=10)
    	{
        synchronized (lock) {
            try {
                  
            	if(count%3 ==Integer.parseInt(Thread.currentThread().getName()))
            	{

                System.out.println(count + " ----Thread Name-------" + Thread.currentThread().getName());
                count++;

                // Update turn for the next thread
                

                // Notify all waiting threads
                lock.notifyAll();
                
            	}
            	else
            	{
            		lock.wait();
            	}
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
    }
    }
}

	 

public class Exp1Print {

    public static void main(String[] args) {

    	PrintingExp printing = new PrintingExp();

       // normalThread(printing);
        executorService(printing);
    }

	private static void executorService(PrintingExp printing) {
		System.out.println("control Coming to here-------------");
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		 // Set thread names before submitting the tasks
        Runnable runnable1 = () -> {
            Thread.currentThread().setName("1");
            printing.implementPrint();
        };

        Runnable runnable2 = () -> {
            Thread.currentThread().setName("2");
            printing.implementPrint();
        };

        Runnable runnable3 = () -> {
            Thread.currentThread().setName("0");
            printing.implementPrint();
        };

        // Submit tasks for each player
        executorService.submit(runnable1);
        executorService.submit(runnable2);
        executorService.submit(runnable3);

        executorService.shutdown();
		
	}

	private static void normalThread(PrintingExp printing) {
		Runnable runnable = () -> {
        	printing.implementPrint();
           
        };

        Thread t1 = new Thread(runnable, "1");
        Thread t2 = new Thread(runnable, "2");
        Thread t3 = new Thread(runnable, "0");

        t1.start();
        t2.start();
        t3.start();
	}
}
