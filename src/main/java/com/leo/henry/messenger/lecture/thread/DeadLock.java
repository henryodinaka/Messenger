package com.leo.henry.messenger.lecture.thread;

public class DeadLock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
    new Thread1().start();
    new Thread2().start();
    }
    private static class Thread1 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 1 : Has lock1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e)
                {

                }
                System.out.println("Thread 1 waiting for lock 2");
                synchronized (lock2){
                    System.out.println("Thread 2 has lock 1 and lock 2");
                }
                System.out.println("Thread 1: Released lock2");
            }
            System.out.println("Thread 2: Released lock 2. Exiting...");
        }
    }
    private static class Thread2 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 2 : Has lock1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e)
                {

                }
                System.out.println("Thread 2 waiting for lock 2");
                synchronized (lock2){
                    System.out.println("Thread 2 has lock1 and lock 2");
                }
                System.out.println("Thread 2: Released lock2");
            }

            System.out.println("Thread 2: Released lock 2. Exiting...");
        }
    }
}
