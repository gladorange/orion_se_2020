package com.orion.lesson5;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            System.out.println(ThreadLocalRandom.current().nextInt(100, 200));

        }
    }
}
