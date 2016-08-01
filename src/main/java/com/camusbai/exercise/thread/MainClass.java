package com.camusbai.exercise.thread;

/**
 * Created by camusbai on 5/1/16.
 */
public class MainClass {
    public static void main(String[] args) {
        MyThread imp = new MyThread("Thread 1");
        MyThread imp2 = new MyThread("Thread 2");

//        imp2.setPriority(Thread.MAX_PRIORITY);
//        imp.start();
//        imp2.start();

        Thread my = new Thread(new MyRunnable(), "MyRunnable");
        my.run();
        my.start();
    }
}
