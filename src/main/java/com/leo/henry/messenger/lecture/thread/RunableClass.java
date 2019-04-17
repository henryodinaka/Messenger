package com.leo.henry.messenger.lecture.thread;

public class RunableClass implements Runnable {
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE+"From the runnable class");
    }
}
