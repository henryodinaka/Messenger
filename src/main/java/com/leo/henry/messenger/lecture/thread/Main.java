package com.leo.henry.messenger.lecture.thread;

public class Main {
    public static void main(String[] args) {
       /* CountDown countDown = new CountDown();
        CountDownThread countDownThread = new CountDownThread(countDown);
        countDownThread.setName("Thread 1");
        CountDownThread countDownThread1 = new CountDownThread(countDown);
        countDownThread1.setName("Thread 2");

        countDownThread.start();
        countDownThread1.start();*/
/*        System.out.println(ThreadColor.ANSI_GREEN);
        System.out.println("Hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.start();
        System.out.println("Hello again from the main");
        Thread runnableClass = new Thread(new RunableClass());
        runnableClass.start();
        anotherThread.interrupt();
        System.out.println("The main thread continues");*/

    //Live lock . A situation where threads are actively waiting for another threads to release a lock
        /*final Worker worker1 = new Worker("Worker 1 ",true);
        final Worker worker2 = new Worker("Worker 2 ",true);
        final SharedResource sharedResource = new SharedResource(worker1);
        new Thread(()->worker1.work(sharedResource,worker2)).start();
        new Thread(()->worker2.work(sharedResource,worker1)).start();*/
    }
}
