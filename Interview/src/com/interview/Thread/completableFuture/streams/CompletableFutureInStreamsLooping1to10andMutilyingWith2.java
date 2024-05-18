package com.interview.Thread.completableFuture.streams;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureInStreamsLooping1to10andMutilyingWith2 {
    public static void main(String[] args) {
        List<Integer> inputList = List.of(1,2,3,4,5,6,7,8,9);
        
        //  // Use CompletableFuture to perform asynchronous tasks
        // Use to perform paraller tasks
        
       List<CompletableFuture<Integer>> completableFutureList= inputList.stream().map(number->CompletableFuture.supplyAsync(()->
        		{
        	
        	return number*2;
        	
        		})).collect(Collectors.toList());
       
       //NOW WE HAVE 10 COMPLETABLE FUTURE Threads
       //Now we need to combine all Completble future Threads
       
       CompletableFuture<Void>   allof =CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));
       
       
       
       allof.join();
       
       
        
 
 
        

    // Retrieve results from completed CompletableFuture tasks using lambda expressions
       List<Integer> results = completableFutureList.stream()
               .map(future -> future.join())
               .collect(Collectors.toList());


        // Process the final results
        results.forEach(System.out::println);
    }

    private static String processInput(String input) {
        // Simulate some asynchronous processing
        return input.toUpperCase();
    }
}
