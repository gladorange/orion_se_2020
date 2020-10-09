package com.orion.java.lesson2;

public class BooleanWork {


    public static void main(String[] args) {
        boolean b1 = false;
        boolean b2 = true;

        if (b1 && getTrue()) {
            System.out.println("Оба true");
        }



        //&=


        int[] numbers = {1, 2, 4, 6, -4, 4};


        boolean negativeFound = false;
        for (int number : numbers) {
            negativeFound |= number < 0;
        }

    }


    static boolean getTrue() {
        System.out.println("Я возвращаю true");
        return true;
    }
}
