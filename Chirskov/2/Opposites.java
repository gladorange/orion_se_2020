import java.util.Random;

public class Opposites {
    public static boolean checkNearby(int firstNumber, int secondNumber) {
        return isPositiveNumber(firstNumber) ^ isPositiveNumber(secondNumber);
    }

    public static boolean isPositiveNumber(int number) {
        return number > 0 ? true : false;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt();
        }

        for (int i = 1; i < numbers.length; i++) {
            if (checkNearby(numbers[i - 1], numbers[i]))
                System.out.println(" Числа с противоположными знаками обнаружены: " + numbers[i - 1] + " " + numbers[i]);
        }

    }
}