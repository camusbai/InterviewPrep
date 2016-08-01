package com.camusbai.exercise.thread;

/**
 * Created by camusbai on 5/1/16.
 */
public class MyStopThread extends Thread {
    private volatile Thread stopIndicator;

    public void start(){
        stopIndicator = new Thread(this);
        stopIndicator.start();
    }

    public void stopThread(){

    }
}

