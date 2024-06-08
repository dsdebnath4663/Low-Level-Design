package org.lld.thread;


class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread is running...");

    }
}

public class Main {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
    }
}