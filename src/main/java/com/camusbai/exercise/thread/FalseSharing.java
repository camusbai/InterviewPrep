package com.camusbai.exercise.thread;

public class FalseSharing {
    public static int NUM_THREAD = 4;
    public final static long ITERATIONS = 50_000_000L;

    private static VolatileLongPadded[] paddedLongs;
    private static VolatileLongUnPadded[] unPaddedLongs;

    public final static class VolatileLongPadded {
        public long q1, q2, q3, q4, q5, q6;
        public volatile long value = 0L;
        public long q8, q9, q10, q11, q12, q13;
    }

    public final static class VolatileLongUnPadded {
        public volatile long value = 0L;
    }

    static {
        paddedLongs = new VolatileLongPadded[NUM_THREAD];
        for (int i = 0; i < paddedLongs.length; i++) {
            paddedLongs[i] = new VolatileLongPadded();
        }
        unPaddedLongs = new VolatileLongUnPadded[NUM_THREAD];
        for (int i = 0; i < unPaddedLongs.length; i++) {
            unPaddedLongs[i] = new VolatileLongUnPadded();
        }
    }

    public static void main(String[] args) throws Exception{
        runBenchmark();
    }

    private static void runBenchmark() throws Exception {
        long begin, end;
        for (int n = 1; n <= NUM_THREAD; n++) {
            Thread[] threads = new Thread[n];

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createPaddedRunnable(j));
            }
            begin = System.currentTimeMillis();
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            end = System.currentTimeMillis();
            System.out.println("Padded with " + n + " threads: " + (end - begin) + "ms");

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createUnPaddedRunnable(j));
            }
            begin = System.currentTimeMillis();
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            end = System.currentTimeMillis();
            System.out.println("UnPadded with " + n + " threads: " + (end - begin) + "ms");
            System.out.println();
        }
    }

    private static Runnable createPaddedRunnable(final int k) {
        return () ->{
            long i = ITERATIONS + 1;
            while (i != 0) {
                paddedLongs[k].value = i;
                i--;
            }
        } ;
    }

    private static Runnable createUnPaddedRunnable(final int k) {
        return () ->{
            long i = ITERATIONS + 1;
            while (i != 0) {
                unPaddedLongs[k].value = i;
                i--;
            }
        } ;
    }
}