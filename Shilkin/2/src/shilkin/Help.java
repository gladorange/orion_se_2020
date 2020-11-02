package shilkin;

class Help {

    public static boolean isMagicNumber(int number) {

        return (number / 10 > 1 || number / 10 < -1) && (number % 10 == number / 10);

    }

    public static boolean isOppositeNumbers(int firstNumber, int secondNumber) {

        return (firstNumber > 1 && secondNumber < 1) || (firstNumber < 1 && secondNumber > 1);

    }




}