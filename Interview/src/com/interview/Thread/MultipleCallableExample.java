package com.interview.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultipleCallableExample {

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool size
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // List of Callable tasks
        List<Callable<String>> callableTasks = List.of(
                createCallableTask("Task 1"),
                createCallableTask("Task 2"),
                createCallableTask("Task 3")
        );

        try {
            // Invoke all Callable tasks
            List<Future<String>> futures = executorService.invokeAll(callableTasks);

            // Process the results
            for (Future<String> future : futures) {
                try {
                    String result = future.get(); // Blocking call to get the result
                    System.out.println("Result: " + result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the ExecutorService
            executorService.shutdown();
        }
    }

    private static Callable<String> createCallableTask(String taskName) {
        return () -> {
            // Simulate a time-consuming task
            Thread.sleep(2000);
            return taskName + " completed";
        };
    }
}
