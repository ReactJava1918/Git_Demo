package com.interview.Thread.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureUseCaseWithAllAsycMethodUseCasess {
    public static void main(String[] args) {
        // Step 1: Receive a message asynchronously
        CompletableFuture<String> receiveMessage = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1: Message Received");
            return "Hello";
        });

        // Step 2: Process the message (thenApply)
        CompletableFuture<String> processMessage = receiveMessage.thenApply(message -> {
            System.out.println("Step 2: Processing Message");
            return message + " World";
        });

        // Step 3: Display the processed message (thenAccept)
        CompletableFuture<Void> displayMessage = processMessage.thenAccept(processedMessage -> {
            System.out.println("Step 3: Displaying Processed Message: " + processedMessage);
        });

        // Step 4: Combine with another CompletableFuture (thenCombine)
        CompletableFuture<String> additionalProcessing = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 4: Additional Processing");
            return "!";
        });

        CompletableFuture<String> combinedResult = processMessage.thenCombine(additionalProcessing, (processed, additional) -> {
            System.out.println("Step 4: Combining Results");
            return processed + additional;
        });

        // Step 5: Handle exception
        CompletableFuture<Object> exceptionHandling = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 5: Simulating Exception");
            throw new RuntimeException("Error occurred");
        }).exceptionally(ex -> {
            System.err.println("Step 5: Handling Exception: " + ex.getMessage());
            return "Handled Exception";
        });

        // Step 6: Chain the results together
        CompletableFuture<Void> finalResult = displayMessage.thenCombine(combinedResult, (voidResult, combined) -> {
            System.out.println("Step 6: Final Result: " + combined);
            return null; // CompletableFuture<Void> requires a non-value return
        });

        // Blocking call to get the final result
        finalResult.join();
    }
}
