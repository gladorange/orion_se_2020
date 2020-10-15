package MagicOfNumbers;

import java.util.Random;
import java.util.stream.IntStream;

public class MagicOfNumbers {
    public static void main (String[] args) {
        int [] arrayOfIntegers = new int[100];

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int generatedInteger = random.nextInt(101)  - (random.nextInt(2) == 0 ? 0 : 100);
            arrayOfIntegers[i] = generatedInteger;
            // System.out.println("Число: " + generatedInteger);
            if(isMagicNumber(generatedInteger)) {
                System.out.printf("Число %d - магическое!\n", arrayOfIntegers[i]);
            }
        }
    }

    public static boolean isMagicNumber(int number) {
        int whole = number / 10;
        int fractional = number % 10;
        // System.out.println("whole: " + whole + " fractional: " + fractional);

        if (whole == fractional) {
            if (Math.abs(whole) > 0 && Math.abs(whole) < 100) {
                return true;
            }
        }
        return false;
    }
}
