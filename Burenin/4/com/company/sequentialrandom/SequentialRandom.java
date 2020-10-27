package com.company.sequentialrandom;

import java.util.concurrent.ThreadLocalRandom;

public class SequentialRandom {
    static int number = -1;

    SequentialRandom() {
        number = number == -1 ? ThreadLocalRandom.current().nextInt(0, 100) : number + 1;
    }

    public static int getNumber() {
        return number;
    }

    public static void resetRandom() {
        number = -1;
        System.out.println("Сброс последовательности");
    }

    public static void main(String[] args) {
        SequentialRandom obj1 = new SequentialRandom();
        System.out.println(SequentialRandom.getNumber());
        SequentialRandom obj2 = new SequentialRandom();
        System.out.println(SequentialRandom.getNumber());
        SequentialRandom obj3 = new SequentialRandom();
        System.out.println(SequentialRandom.getNumber());
        SequentialRandom.resetRandom();
        SequentialRandom obj4 = new SequentialRandom();
        System.out.println(SequentialRandom.getNumber());
        SequentialRandom obj5 = new SequentialRandom();
        System.out.println(SequentialRandom.getNumber());
    }
}
