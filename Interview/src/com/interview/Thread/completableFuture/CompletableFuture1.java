package com.interview.Thread.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture1 {
    public static void main(String[] args) throws Exception {
        // Create a CompletableFuture without specifying an executor
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // Your asynchronous task here
            return "Task Result";
        });

        // You can then use this CompletableFuture to chain further actions or retrieve the result
        String result = completableFuture.get();
        System.out.println("Result: " + result);
        
    }
}
