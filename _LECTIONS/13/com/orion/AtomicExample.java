package com.orion;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {


    static AtomicInteger value = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {

        final Incrementer a = new Incrementer();
        final Incrementer b = new Incrementer();
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(value);
    }


    static class Incrementer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                value.incrementAndGet();
            }

        }
    }
}
