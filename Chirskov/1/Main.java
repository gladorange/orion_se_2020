public class Main {

    final static short numbersCount = 2;

    public static void main(String[] args) {
        if (!isValid(args)) {
            System.out.println("Input Error!");
            return;
        }
        int firstNumber = Integer.parseInt(args[0]);
        int secondNumber = Integer.parseInt(args[1]);

        if (firstNumber > secondNumber)
            System.out.println("Число " + firstNumber + " больше " + secondNumber);
        else if (firstNumber < secondNumber)
            System.out.println("Число " + firstNumber + " меньше " + secondNumber);

        System.out.println("Сумма чисел равна " + sumOfTwoNumbers(firstNumber, secondNumber));
    }

    static Integer tryParseInt(String s) {
        try {
            return new Integer(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    static boolean isValid(String[] args) {
        if (numbersCount != args.length)
            return false;
        Integer firstNumber = tryParseInt(args[0]);
        Integer secondNumber = tryParseInt(args[1]);
        if (firstNumber == null || secondNumber == null)
            return false;
        return true;
    }

    static int sumOfTwoNumbers(int firstNumber, int secondNumber)
    {
        return firstNumber + secondNumber;
    }
}
