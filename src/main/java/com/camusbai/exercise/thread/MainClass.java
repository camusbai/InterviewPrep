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

        Runnable run1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + 1 + " - Daemon " + Thread.currentThread().isDaemon() + " ");
                System.out.println("Runnable defined as lambda " + Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(run1);
        thread1.setDaemon(true);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}