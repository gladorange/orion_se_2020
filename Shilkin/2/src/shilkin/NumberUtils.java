package shilkin;

class NumberUtils {

    public static boolean isMagicNumber(int number) {
        return (number / 10 > 1 || number / 10 < -1) && (number % 10 == number / 10);
    }

    public static boolean isOppositeNumbers(int firstNumber, int secondNumber) {
        return (firstNumber > 0 && secondNumber < 0) || (firstNumber < 0 && secondNumber > 0);
    }

}