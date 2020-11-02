package com.orion.lesson7;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueue {


    public static void main(String[] args) throws InterruptedException {


        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        queue.offer("A");

        final String poll = queue.poll();

        System.out.println("Достал " + poll);

        final String value = queue.poll(3, TimeUnit.SECONDS);

        System.out.println(value);
    }
}
