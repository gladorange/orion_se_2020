package com.company;

public class Main {
    static class Numbers {
        public Numbers() {
            numbers = new int[SIZE];

            for (int index = 0; index < SIZE; index++)
                numbers[index] = (int)(Math.random() * (MAX - MIN) + MIN);
        }

        public int[] getNumbers() {
            return numbers;
        }

        private int[] numbers;
        private final static int SIZE = 100;
        private final static int MIN = -100;
        private final static int MAX =  100;
    }

    static boolean isMagicNumber(int number) {
        if (number < 0)
            number = number * (-1);

        if (number == 0 || (number / 10 < 1)) // if 0, 1, 2, 3, ... 9
            return false;

        return ((number % 10) == (number / 10) % 10);
    }

    public static void main(String[] args) {
	    Numbers numbers = new Numbers();
	    int[] values = numbers.getNumbers();

	    for (int el : values)
	        if (isMagicNumber(el))
	            System.out.format("Число <%d> магическое\n", el);
    }
}
