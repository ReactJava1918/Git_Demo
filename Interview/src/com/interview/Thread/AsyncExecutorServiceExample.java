package com.interview.Thread;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AsyncExecutorServiceExample {

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool size of 3
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // List of URLs to download content from
        List<String> urls = List.of(
                "https://www.example.com",
                "https://www.example.org",
                "https://www.example.net"
        );

        // List to store Future objects representing the asynchronous tasks
        List<Future<String>> futures = new ArrayList<>();

        // Submit tasks to the ExecutorService
        for (String url : urls) {
            Callable<String> downloadTask = createDownloadTask(url);
            Future<String> future = executorService.submit(downloadTask);
            futures.add(future);
        }

        System.out.println("311111111111111111111111111111111111");
        System.out.println("Doing other jobs.........................");
        // Perform other tasks while the downloads are in progress

        // Retrieve and process the results when ready
        for (Future<String> future : futures) {
            try {
                String content = future.get(); // Blocking call to get the result
                System.out.println("Downloaded content: " + content.length() + " characters");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the ExecutorService
        executorService.shutdown();
    }

    private static Callable<String> createDownloadTask(String url) {
        return () -> {
            try {
                // Simulate downloading content from a URL (replace with your actual download logic)
            	Thread.sleep(5000);
            	System.out.println("Doing callable task logic---------------"+Thread.currentThread().getName());
                return downloadContent(url);
            } catch (IOException e) {
                throw new RuntimeException("Error downloading content from " + url, e);
            }
        };
    }

    private static String downloadContent(String url) throws IOException {
        // Simulate downloading content from a URL (replace with your actual download logic)
        // For simplicity, using a dummy content here
        return "Content from " + url;
    }
}
