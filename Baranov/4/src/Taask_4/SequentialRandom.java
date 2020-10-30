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

    public static void main(String[] args) {

        SequentialRandom randomNumber = new SequentialRandom();
        System.out.println(randomNumber);
        SequentialRandom randomNumber2 = new SequentialRandom();
        System.out.println(randomNumber2);
        SequentialRandom randomNumber3 = new SequentialRandom();
        System.out.println(randomNumber3);
        SequentialRandom randomNumber4 = new SequentialRandom();
        System.out.println(randomNumber4);

        SequentialRandom.resetRandom();

        SequentialRandom randomNumber5 = new SequentialRandom();
        System.out.println(randomNumber5);
        SequentialRandom randomNumber6 = new SequentialRandom();
        System.out.println(randomNumber6);
        SequentialRandom randomNumber7 = new SequentialRandom();
        System.out.println(randomNumber7);
    }
}
