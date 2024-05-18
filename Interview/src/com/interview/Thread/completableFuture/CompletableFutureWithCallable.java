package com.interview.Thread.completableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureWithCallable {

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
        Callable callableLogic = () ->{
			 return 8;
		};
		
		
		CompletableFuture<Object> completableFutureCallable = CompletableFuture.supplyAsync(() -> {
            try {
                // Call the callable and return the result
                return callableLogic.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
		
		
	Integer data	= (Integer) completableFutureCallable.join();
	
	System.out.println("completable future data ---"+data);
		//==================================================
	}

}
