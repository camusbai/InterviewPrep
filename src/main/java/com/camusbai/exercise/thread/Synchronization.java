package com.camusbai.exercise.thread;

public class Synchronization {
    public static void main(String args[])
    {
        Sender send = new Sender();
        ThreadedSender S1 =
                new ThreadedSender( " Hi " , send );
        ThreadedSender S2 =
                new ThreadedSender( " Bye " , send );

        // Start two threads of ThreadedSend type
        S1.start();
        S2.start();
    }

    static class ThreadedSender extends Thread {
        Sender sender;
        String msg;

        public ThreadedSender(String msg, Sender sender) {
            this.msg = msg;
            this.sender = sender;
        }

        @Override
        public void run() {
            sender.send(msg);
        }
    }

    static class Sender {
        public void send(String msg) {
            System.out.println("Sending\t" + msg);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Thread  interrupted.");
            }
            System.out.println("\n" + msg + "Sent");
        }
    }
}
