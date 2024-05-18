package com.interview.Thread.completableFuture.streams;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureInStreams {
    public static void main(String[] args) {
        List<String> inputList = List.of("one", "two", "three", "four", "five");

        // Use CompletableFuture to perform asynchronous tasks
        List<CompletableFuture<String>> futures = inputList.stream()
                .map(input -> CompletableFuture.supplyAsync(() -> processInput(input)))
                .collect(Collectors.toList());

        // Combine results when all CompletableFuture tasks are completed
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        // Wait for all CompletableFuture tasks to complete
        allOf.join();

        // Retrieve results from completed CompletableFuture tasks
        List<String> results = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        // Process the final results
        results.forEach(System.out::println);
    }

    private static String processInput(String input) {
        // Simulate some asynchronous processing
        return input.toUpperCase();
    }
}
