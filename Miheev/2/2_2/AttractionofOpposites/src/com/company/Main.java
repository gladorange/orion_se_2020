package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static class Numbers {
        public Numbers() {
            numbers = new int[SIZE];

            Random rand = new Random();
            for (int index = 0; index < SIZE; index++)
                numbers[index] = rand.nextInt();
        }

        public void show() {
            System.out.println(Arrays.toString(numbers));
        }

        public void check() {
            int a, b;

            for (int index = 0; index < SIZE - 1; index++) {
                a = numbers[index];
                b = numbers[index + 1];

                if ((a != 0 && b != 0 && ((a < 0 && b > 0) || (a > 0 && b <0))))
                    System.out.format("Числа с противоположными знаками обнаружены: %d %d\n", a, b);
            }
        }

        private int[] numbers;
        private final static int SIZE = 10;
        private final static int MIN = Integer.MIN_VALUE;
        private final static int MAX = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
	    Numbers numbers = new Numbers();
	    numbers.show();
	    numbers.check();
    }
}
