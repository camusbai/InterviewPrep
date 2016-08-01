package com.camusbai.exercise.thread;

/**
 * Created by camusbai on 5/1/16.
 */
public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=0;i<10;++i) {
            System.out.println(getName()+": "+i);
        }
    }
}
