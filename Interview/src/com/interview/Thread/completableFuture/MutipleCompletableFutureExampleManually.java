package com.interview.Thread.completableFuture;

import java.util.concurrent.CompletableFuture;

public class MutipleCompletableFutureExampleManually {
    public static void main(String[] args) {
        // Create a list of CompletableFutures
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> performTask("Task A"));
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> performTask("Task B"));
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> performTask("Task C"));

        // Combine all CompletableFutures into one
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2, future3);

        // Wait for all CompletableFutures to complete
        allOf.join();

        // Collect results
        int result1 = future1.join();
        int result2 = future2.join();
        int result3 = future3.join();

        // Process results
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
    }

    private static int performTask(String taskName) {
        System.out.println("Executing " + taskName);
        // Simulate some task processing
        return taskName.length();
    }
}