package com.orion;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WaitNotify {


    static Object object = new Object();

    static List<String> result = new CopyOnWriteArrayList<>();

    static class Producer extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            result.add("42");
            synchronized (object) {
                object.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Producer().start();

        synchronized (object) {
            object.wait();
        }

        System.out.println(result.get(0));
    }
}
