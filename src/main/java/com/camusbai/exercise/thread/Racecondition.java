package com.camusbai.exercise.thread;

public class Racecondition {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter.getCount());
    }


    static class Counter {
        int val;
        private Object key = new Object();

        public void increment(){
            synchronized (key) {
                val++;
            }
        }

        public int getCount(){
            return val;
        }
    }
}
