package practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter two numbers separated by enter:");

        Scanner scanner = new Scanner(System.in);
        Integer firstNumber = scanner.nextInt();
        Integer secondNumber = scanner.nextInt();

        System.out.println(compareNumbers(firstNumber, secondNumber));

    }

    public static String compareNumbers(int a, int b) {
        if (a > b) {
            return String.format("Число %s больше %s", a, b);
        } else if (a < b) {
            return String.format("Число %s меньше %s", a, b);
        } else {
            return "Числа равны";
        }
    }
}
