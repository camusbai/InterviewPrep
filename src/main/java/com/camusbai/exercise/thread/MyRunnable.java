package com.camusbai.exercise.thread;

/**
 * Created by camusbai on 5/1/16.
 */
public class MyRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
