package com.leo.henry.messenger.lecture.thread;

public class AnotherThread extends Thread {

    @Override
    public void run(){
        System.out.println(ThreadColor.ANSI_PURPLE);
        System.out.println("Hello from another thread class");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            System.out.println("I was interrupted");
            return;
        }
        System.out.println("I am awake after 6 seconds");
    }
}
