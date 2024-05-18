package com.interview.Thread.completableFuture;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FileProcessingToDbWithCompletableFutureWith5Threads {
    public static void main(String[] args) {
        String filePath = "your_file_path.txt";

        // Create a custom ExecutorService with a fixed number of threads
        ExecutorService customExecutor = Executors.newFixedThreadPool(5);

        CompletableFuture<Integer> processingResult = processFileAsync(filePath, customExecutor);

        // Block and get the result
        int result = processingResult.join();

        System.out.println("Total records processed: " + result);

        // Shutdown the custom ExecutorService
        customExecutor.shutdown();
    }

    private static CompletableFuture<Integer> processFileAsync(String filePath, ExecutorService executorService) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Path path = Paths.get(filePath);
                long recordsCount = Files.lines(path).count();

                // Simulate storing records in a database
                // Replace this with your actual database logic
                // List<String> records = Files.lines(path).collect(Collectors.toList());

                // Simulate some database processing time
                Thread.sleep(2000);

                // Return the number of records processed
                return (int) recordsCount;
            } catch (Exception e) {
                throw new RuntimeException("Error processing file: " + e.getMessage(), e);
            }
        }, executorService);
    }
}
