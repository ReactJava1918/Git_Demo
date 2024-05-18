package com.interview.Thread.completableFuture;
import java.util.concurrent.*;

public class CompletableFutureWithExecutorService {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of size 5
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Create a CompletableFuture using a custom ExecutorService
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            // Your asynchronous task here
            System.out.println("Task running in thread: " + Thread.currentThread().getName());
            return 8;
        }, executorService);

        // Define actions to be performed when the CompletableFuture completes
        CompletableFuture<Integer> resultFuture = completableFuture.thenApplyAsync(result -> {
            // Additional processing on the result
            System.out.println("Additional processing in thread: " + Thread.currentThread().getName());
            return result * 2;
        }, executorService);

        // Handle the final result
        resultFuture.whenComplete((result, exception) -> {
            if (exception == null) {
                System.out.println("Final Result: " + result);
            } else {
                System.err.println("Exception occurred: " + exception.getMessage());
            }
        });

        // Shutdown the ExecutorService when done
        executorService.shutdown();
    }
}
