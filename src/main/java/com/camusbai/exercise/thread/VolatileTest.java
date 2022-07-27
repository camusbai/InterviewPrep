package com.camusbai.exercise.thread;

public class VolatileTest {
    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println("Looping...");
            }

            System.out.print(number+" ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Reader reader = new Reader();
            reader.start();
            number = 42;
            ready = true;
            reader.join();
            number = 0;
            ready = false;
        }
    }
}
