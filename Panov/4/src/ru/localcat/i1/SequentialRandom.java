package ru.localcat.i1;

import java.util.Random;

public class SequentialRandom {
    private static int sValue;
    //Использовать автонрементацию или нет
    private static boolean useAI = false;
    private static final int aiStep = 1;
    private final int value;

    public SequentialRandom() {
        changeValue();
        value = sValue;
    }

    private void changeValue() {
        if (useAI) {
            sValue = sValue + aiStep;
        } else {
            sValue = new Random().nextInt();
            useAI = true;
        }
    }

    public static void resetRandom() {
        useAI = false;
    }

    public int getValue() {
        return value;
    }
}
