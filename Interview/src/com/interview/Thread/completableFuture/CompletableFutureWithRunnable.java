package com.interview.Thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureWithRunnable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		 
		 // Create a CompletableFuture without specifying an executor
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // Your asynchronous task here
            return "Task Result";
        });

        // You can then use this CompletableFuture to chain further actions or retrieve the result
        String result = completableFuture.get();
        System.out.println("Result: " + result);
        
        
        //---------------------------------------------------
        Runnable runnableLogic = () ->{
			System.out.println("hello this from runnable ");
		};
		
		
		CompletableFuture<Void> completableFutureRunnable = CompletableFuture.runAsync(runnableLogic);
		completableFutureRunnable.join();
		//==================================================
	}

}
