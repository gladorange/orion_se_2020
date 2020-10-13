package com.orion.lesson3.stat;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StaticExample {

    static {
        System.out.println("Я загрузился");
        RANDOM_VALUE = 42;
        th();
    }

    //static int RANDOM_VALUE = getRandom();
    static int RANDOM_VALUE;


    public static int getRandom() {
        System.out.println("Идет инициализация");
        return ThreadLocalRandom.current().nextInt(100, 200);
    }

    public static void th() {
        throw new RuntimeException();
    }
}
