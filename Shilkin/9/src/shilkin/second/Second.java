package shilkin.second;

public class Second {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        addOperations(calc);
        calc.calculate("Умножение", 2.0, 3.0);
        calc.calculate("Деление", 6.0, 3.0);
        calc.calculate("Деление", 6.0, 3.0);
        calc.calculate("Сложение", 1.0, 5.0);
        calc.calculate("Вычитание", 6.0, 2.0);
        calc.calculate("Возведение в степень", 2.0, 2.0);
        calc.calculate("Извлечение корня степени n", 4.0, 2.0);
    }

    static void addOperations(Calculator calc) {
        calc.addOperation("Умножение", (a, b) -> a * b);
        calc.addOperation("Деление", (a, b) -> a / b);
        calc.addOperation("Сложение", Double::sum);
        calc.addOperation("Вычитание", (a, b) -> a - b);
        calc.addOperation("Возведение в степень", Math::pow);
        calc.addOperation("Извлечение корня степени n", (a, b) -> Math.pow(a, 1.0 / b));
    }
}
