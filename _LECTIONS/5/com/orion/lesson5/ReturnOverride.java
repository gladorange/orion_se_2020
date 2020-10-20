package com.orion.lesson5;

import com.orion.lesson5.OrionException.CriticalLevel;

public class ReturnOverride {


    public static void main(String[] args) {
        int value = tryGuess();
        System.out.println(value);
    }

    private static int tryGuess() {
        try {
            return 2/0;
        } catch (ArithmeticException e) {
            System.out.println("Исключение");
            throw new OrionException("Что-то не так", CriticalLevel.ERROR);
        } finally {
            return 100;
        }

    }
}
