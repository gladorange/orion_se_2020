package Taask_4;

import java.util.concurrent.ThreadLocalRandom;

public class SequentialRandom {
    static int previousValue;
    private final int number;

    public SequentialRandom() {
        if (SequentialRandom.previousValue == 0) {
            number = ThreadLocalRandom.current().nextInt();
        } else {
            number = SequentialRandom.previousValue + 1;
        }
        SequentialRandom.previousValue = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public static void resetRandom() {
        SequentialRandom.previousValue = 0;
    }
}
