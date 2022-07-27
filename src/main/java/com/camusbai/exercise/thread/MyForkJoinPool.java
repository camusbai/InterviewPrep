package com.camusbai.exercise.thread;

import java.util.concurrent.ForkJoinPool;

public class MyForkJoinPool {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(8);
    }
}
