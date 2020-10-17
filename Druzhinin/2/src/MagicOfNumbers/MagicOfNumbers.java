package MagicOfNumbers;

import java.util.Random;

public class MagicOfNumbers {
    private final static int ARRAY_SIZE = 100;

    public static void main (String[] args) {
        int [] arrayOfIntegers = new int[ARRAY_SIZE];

        for (int i = 0; i < arrayOfIntegers.length; i++) {
            Random random = new Random();
            int generatedInteger = random.nextInt(ARRAY_SIZE * 2 - 1) - ARRAY_SIZE;

            arrayOfIntegers[i] = generatedInteger;
            if(isMagicNumber(generatedInteger)) {
                System.out.printf("Число %d - магическое!\n", arrayOfIntegers[i]);
            }
        }
    }

    public static boolean isMagicNumber(int number) {
        int whole = number / 10;
        int fractional = number % 10;

        if (whole == fractional) {
            if (Math.abs(whole) > 0 && Math.abs(whole) < 100) {
                return true;
            }
        }
        return false;
    }
}
