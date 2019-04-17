package com.leo.henry.messenger.lecture.thread;

public class Starvation {
    private static Object lock = new Object();
    public static void main(String[] args) {
    Thread thread1 = new Thread(new Worker(ThreadColor.ANSI_RED),"Priority 10");
    Thread thread2 = new Thread(new Worker(ThreadColor.ANSI_BLUE),"Priority 8");
    Thread thread3 = new Thread(new Worker(ThreadColor.ANSI_GREEN),"Priority 6");
    Thread thread4 = new Thread(new Worker(ThreadColor.ANSI_CYAN),"Priority 4");
    Thread thread5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE),"Priority 2");
    thread1.setPriority(10);
    thread2.setPriority(8);
    thread3.setPriority(6);
    thread4.setPriority(4);
    thread5.setPriority(2);

    thread3.start();
    thread5.start();
    thread4.start();
    thread2.start();
    thread1.start();
    }
    private static class Worker implements Runnable{
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i=0; i<100;i++)
            {
                synchronized (lock){
                    System.out.format(threadColor+"%s: runCount = %d\n",Thread.currentThread().getName(),runCount++);
                }
            }
        }
    }
}
