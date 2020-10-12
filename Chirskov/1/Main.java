public class Main {

    final static short NUMBERS_COUNT = 2;

    public static void main(String[] args) {
        if (NUMBERS_COUNT != args.length) {
            System.out.println("Количество введёных аргументов не равно " + NUMBERS_COUNT);
            return;
        }
        Integer firstNumber = tryParseInt(args[0]);
        Integer secondNumber = tryParseInt(args[1]);
        if (firstNumber == null || secondNumber == null) {
            return;
        }

        if (firstNumber > secondNumber) {
            System.out.println("Число " + firstNumber + " больше " + secondNumber);
        }
        else if (firstNumber < secondNumber) {
            System.out.println("Число " + firstNumber + " меньше " + secondNumber);
        }
        System.out.println("Сумма чисел равна " + sumOfTwoNumbers(firstNumber, secondNumber));
    }

    static Integer tryParseInt(String s) {
        try {
            return new Integer(s);
        } catch (NumberFormatException e) {
            System.out.println(s + " не удалось преобразовать в Integer");
            return null;
        }
    }

    static int sumOfTwoNumbers(int firstNumber, int secondNumber)
    {
        return firstNumber + secondNumber;
    }
}
