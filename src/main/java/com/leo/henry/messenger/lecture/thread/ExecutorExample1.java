package com.leo.henry.messenger.lecture.thread;

import java.util.concurrent.*;

public class ExecutorExample1 {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Runnable, return void, nothing, submit and run the task async
        executor.submit(() -> System.out.println("I'm Runnable task."));
        executor.execute(new FreshThread());

        // Callable, return a future, submit and run the task async
        Future<Integer> futureTask1 = executor.submit(() -> {
            System.out.println("I'm Callable task.");
            return 1 + 1;
        });

        /* Before Java 8
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm Runnable task.");
            }
        });

        Future<Integer> futureTask1 = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println("I'm Callable task.");
                return 1 + 1;
            }
        });*/

        try {

            otherTask("Before Future Result");

            // block until future returned a result, 
            // timeout if the future takes more than 5 seconds to return the result
            Integer result = futureTask1.get(5, TimeUnit.SECONDS);

            System.out.println("Get future result : " + result);

            otherTask("After Future Result");


        } catch (InterruptedException | TimeoutException | ExecutionException e) {// thread was interrupted
            System.out.println("Something went wrong with the whole thing");
        } finally {

            // shut down the executor manually
            executor.shutdown();

        }

    }

    private static void otherTask(String name) {
        System.out.println("I'm other task! " + name);
    }
}

class FreshThread implements Runnable{
    @Override
    public void run() {
        System.out.println("This is from the FreshThread ");
    }
}