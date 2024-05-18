package com.interview.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class CallableImplementation implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        // Your computation here
        return 5;
    }
}

public class ExampleOnCallable {
    public static void main(String[] args) throws Exception {
     
        Callable<Integer> callableTask = () -> {
            // Your computation here
        	System.out.println("---------------------"+Thread.currentThread().getName());
            return 5;
        };
        
        
       // passingCallableToNormalThreadConstructorByUsingFuture(callableTask);
        
        
        //Below is executor service
        //To automate the threds creation process we are using Executor service logic
        
        
        
       // passingCallableToExecutorServiceByusingFutureObject(callableTask);
        
        passingCallableToExecutorServiceDirectly(callableTask);
        
        
        
        
        
    }

	private static void passingCallableToExecutorServiceDirectly(Callable<Integer> callableTask) throws InterruptedException, ExecutionException {
		
		
ExecutorService executorService = Executors.newFixedThreadPool(5);

        
       Future<Integer> task= executorService.submit(callableTask);
       task.get();
		
	}

	private static void passingCallableToExecutorServiceByusingFutureObject(Callable<Integer> callableTask) {
		FutureTask<Integer> futureTask2 = new FutureTask<>(callableTask);
        
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        
        executorService.submit(futureTask2);
        executorService.submit(()->{
        	
        	System.out.println("Runnable logic executing from executoe service  ======"+Thread.currentThread().getName());
        });
        
        
        try {
            Integer resultfromCallable = futureTask2.get();
            System.out.println("Result from Exector service: " + resultfromCallable);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
	}

	private static void passingCallableToNormalThreadConstructorByUsingFuture(Callable<Integer> callableTask)
			throws InterruptedException, ExecutionException {
		FutureTask<Integer> futureTask1 = new FutureTask<>(callableTask);
        
        Thread thread = new Thread(futureTask1);
        thread.setName("Normal Thread");
        thread.start();

        // Get the result when the thread completes
        Integer result = futureTask1.get();

        System.out.println("Result: " + result);
	}
}
