package SequentialRandom;

import java.util.Random;

public class SequentialRandom {
    private static int value ;
    private static boolean newEntity = true;
    private static final int MAX_VALUE = 500;

    public int getValue() {
        return value;
    }

    public SequentialRandom(){
        if (newEntity) {
            value = new Random().nextInt(MAX_VALUE);
            newEntity = false;
        }else{
            value++;
        }
    }

    public static void resetRandom(){
        newEntity = true;
    }
}
