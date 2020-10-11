package com.opposite;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] array= new int[10];
        for (int i = 0 ; i < array.length; ++i) {
            Random r = new Random();
            int sight = r.nextBoolean()? 1: -1;
            array[i] = (int) (Math.random() * 2147483647) * sight + sight;
            System.out.printf(" %d ", array[i]);
        }

        for (int i = 1 ; i < array.length; ++i) {
            if (hasOppositeSight(array[i - 1], array[i]))
                System.out.printf("\n Числа с противоположными знаками обнаружены: %d %d ", array[i - 1], array[i]);
        }
    }

    static boolean hasOppositeSight(int number_1, int number_2 ) {
        if (number_1 == 0 || number_2 == 0)
            return false;
        else
            return number_1 >0 && number_2 <0 || number_1 <0 && number_2 >0? true:false;
    }
}