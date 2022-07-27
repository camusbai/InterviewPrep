package com.camusbai.exercise.thread;

public class HappensBefore {
    static int index=0;

    static synchronized void increment() {
        for (int i = 0; i < 1000; i++) {
            index++;
        }
    }

    static synchronized void print() {
        System.out.print(index+" ");
    }

    static void run1() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Runnable r1 = HappensBefore::print;
            Runnable r2 = HappensBefore::increment;

            Thread t1 = new Thread(r1, "PrintThread");
            Thread t2 = new Thread(r2, "IncrementThread");

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }
    }

    static synchronized void increment2() {
        index++;
    }

    static synchronized void print2() {
        System.out.print(index);
    }

    static void run2() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            index = 0;
            Runnable r1 = HappensBefore::increment2;
            Runnable r2 = HappensBefore::print2;

            Thread t1 = new Thread(r1, "PrintThread");
            Thread t2 = new Thread(r2, "IncrementThread");

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        run2();
    }
}
