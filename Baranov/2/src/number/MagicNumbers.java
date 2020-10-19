package number;

import java.util.Random;


public class MagicNumbers {

    public static void main(String[] args) {

        int[] arr = new int[100];
        randIntArr(-100, 100, arr);

        for (int i = 0; i < arr.length; i++) {
            if (isMagicNumber(arr[i])) {
                System.out.println(String.format("Число: %s - магическое ", arr[i]));
            }
        }
    }

    public static boolean isMagicNumber(int number) {
        if ((Math.abs(number) > 0 && Math.abs(number) < 10) || ((number / 10) == (number % 10))) {
            return true;
        }
        return false;
    }

    public static void randIntArr(int min, int max, int[] arr) {

        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1) + min;
        }

    }
}
