import java.util.Random;

public class MagicNumbers {
    final static int MAX_NUMBER = 100;
    final static int MIN_NUMBER = -100;

    public static boolean isMagicNumber(int number) {
        Integer magicNumber = null;
        while (number != 0) {
            if (magicNumber != null && magicNumber != number % 10)
                return false;
            magicNumber = number % 10;
            number /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt((MAX_NUMBER - MIN_NUMBER) + 1) + MIN_NUMBER;
            if (isMagicNumber(numbers[i]))
                System.out.println("Число " + numbers[i] + " - магическое!");
        }
    }
}