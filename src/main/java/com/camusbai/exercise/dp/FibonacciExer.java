package com.camusbai.exercise.dp;

public class FibonacciExer {
    static int simpleFib(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return simpleFib(n - 1) + simpleFib(n - 2);
        }
    }

    static int improvedFib(int n) {
        int[] cache = new int[n];
        cache[0] =1;
        cache[1] =1;
        return fib(n, cache);
    }

    static int fib(int n, int[] cache) {
        if (n <= 2) {
            return 1;
        } else {
            if (cache[n-1] > 0) {
                return cache[n-1];
            } else {
                int result = fib(n - 1, cache) + fib(n - 2, cache);
                cache[n - 1] = result;
                return result;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("simpleFib(40):" + simpleFib(40));
        long end = System.nanoTime();
        System.out.println(end - start);

        start = System.nanoTime();
        System.out.println("improvedFib(48):" + improvedFib(48));
        end = System.nanoTime();
        System.out.println(end - start);
    }
}
