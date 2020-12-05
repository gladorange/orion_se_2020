package maxfomtaskeleven.secondtask;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addOperation("Сложение", Double::sum);
        calculator.addOperation("Вычитание", (number1, number2) -> number1 - number2);
        calculator.addOperation("Умножение", (number1, number2) -> number1 * number2);
        calculator.addOperation("Деление", (number1, number2) -> number1 / number2);
        calculator.addOperation("Возведение в степень", Math::pow);
        calculator.addOperation("Извлечение корня", (number1, number2) -> Math.pow(number1, 1 / number2));

        calculator.calculate("Возведение в степень", 2.0, 5.0);
        calculator.calculate("Извлечение корня", 256.0, 8.0);
        calculator.calculate("Сложение", 2.5, 3.5);
    }
}
