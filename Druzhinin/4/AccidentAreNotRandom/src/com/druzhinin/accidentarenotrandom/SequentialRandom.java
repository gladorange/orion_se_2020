package com.druzhinin.accidentarenotrandom;

import java.util.Random;

public class SequentialRandom {

    private static int randomInteger = -1;
    private final static int MAX_VALUE = 100;

    public SequentialRandom() {

        if (randomInteger == -1) {
            System.out.println("Generate first randomInteger");
            resetRandom();
        } else {
            randomInteger++;
            System.out.println("Incremented randomInteger: " + randomInteger);
        }
    }

    public static int getRandomInteger() {
        return randomInteger;
    }

    public static void resetRandom() {
        randomInteger = new Random().nextInt(MAX_VALUE);
        System.out.println("Reset randomInteger: " + randomInteger);
    }
}
