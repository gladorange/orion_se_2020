package com.orion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsExample {


    //static Set<Integer> integers = Collections.synchronizedSet(new HashSet<>());
    static Set<Integer> integers = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) throws InterruptedException {
        Adder a = new Adder(0);
        Adder b = new Adder(20000);
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(integers.size());
    }


    static class  Adder extends Thread {

        final int startingNumber ;

        Adder(int startingNumber) {
            this.startingNumber = startingNumber;
        }


        @Override
        public void run() {
            for (int i = 0 + startingNumber; i < 10000 + startingNumber; i++) {
                integers.add(i);
            }
        }
    }
}
