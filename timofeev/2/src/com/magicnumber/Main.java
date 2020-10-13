package com.magicnumber;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int array[]= new int[100];
        for (int i = 0 ; i < array.length; ++i) {
            Random r = new Random();
            int sight = r.nextBoolean()? 1: -1;
            array[i] = (int) (Math.random() * 100) * sight + sight;
            if (isMagicNumber(array[i]))
                System.out.printf("Число %d - магическое!\n", array[i]);
        }
    }

    static boolean isMagicNumber(int number) {
        if (number != 0)
            return number%10 == number/10? true:false;
        return false;
    }
}