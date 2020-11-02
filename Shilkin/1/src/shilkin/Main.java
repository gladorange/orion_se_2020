package shilkin;

public class Main {

    public static void main(String[] args) {

        int firstNumber = 16;
        int secondNumber = 14;

        if (firstNumber > secondNumber){

            System.out.println(String.format("Число %s больше %s", firstNumber, secondNumber));
        }
        if (firstNumber < secondNumber){

            System.out.println(String.format("Число %s меньше %s", firstNumber, secondNumber));
        }

        System.out.println("Сумма чисел: " + (firstNumber + secondNumber));
    }
}
