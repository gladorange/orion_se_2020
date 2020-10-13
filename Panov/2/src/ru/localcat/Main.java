package ru.localcat;

import java.util.Random;

public class Main {
    private final static int CASE1_COUNT_ELEMS = 100;
    private final static int CASE2_COUNT_ELEMS = 10;
    private final static Random randGen = new Random();

    public static void main(String[] args) {
        //Case 1
        int[] array100Ints = new int[CASE1_COUNT_ELEMS];

        for (int i = 0; i < CASE1_COUNT_ELEMS; i++) {
            array100Ints[i] = getRandomFromRange(-100, 100);
            if (isMagicNumber(array100Ints[i])) {
                System.out.println("Число " + array100Ints[i] + " - магическое!");
            }
        }

        //Case 2

        int[] array10Ints = new int[CASE2_COUNT_ELEMS];
        for (int i = 0; i < CASE2_COUNT_ELEMS; i++) {
            array10Ints[i] = getRandomFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.print(array10Ints[i] + ", ");
        }
        System.out.println();

        int prevValue = 0;

        for (int i = 0; i < CASE2_COUNT_ELEMS; i++) {
            if (i != 0) {
                if (checkDifferentSigns(prevValue, array10Ints[i])) {
                    System.out.println("Числа с противоположными знаками обнаружены: <" + prevValue + "> <" + array10Ints[i] + ">");
                }
            }
            prevValue = array10Ints[i];
        }
    }

    private static int getRandomFromRange(int start, int end) {
        return randGen.ints(1, start, end).findFirst().getAsInt();
    }

    private static boolean checkDifferentSigns(int first, int second) {
        if (first > 0) {
            if (second < 0) {
                return true;
            }
        } else {
            if (second > 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMagicNumber(int number) {
        int numberAbsoluteValue = Math.abs(number);

        if (numberAbsoluteValue < 10) {
            //Не совсем понятно числа 0..9 являются ли магическими,
            //с одной строны технически они состоят из одинаковых цифр, коими сами и являються
            //но пока принмаем, что они не магические
            return false;
        } else {
            if (numberAbsoluteValue <= 99) {
                if ((numberAbsoluteValue % 11) == 0) {
                    return true;
                }
            } else {
                int stateStep = 0;
                int stateStepPrev = 0;
                int balance = numberAbsoluteValue;

                while ((balance / 10) != 0) {
                    stateStepPrev = balance % 10;
                    balance = balance / 10;
                    stateStep = balance % 10;
                    if (stateStep != stateStepPrev) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
