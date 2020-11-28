import java.util.HashMap;
import java.util.Map;

public class Calculator {

    interface Operation {
        Double doOperation(Double number1, Double number2);
    }

    Map<String, Operation> operations = new HashMap<>();

    Double calculate(String operatorName, Double number1, Double number2) {
        return this.operations.get(operatorName).doOperation(number1, number2);
    }

    void addOperation(String operationName, Operation implementation) {
        this.operations.put(operationName, implementation);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addOperation("Addition", Double::sum);
        calc.addOperation("Multiplication", (a, b) -> a * b);
        calc.addOperation("Division", (a, b) -> a / b);
        calc.addOperation("Subtraction", (a, b) -> a - b);
        calc.addOperation("Exponentiation", Math::pow);
        calc.addOperation("Extracting", (a, b) -> Math.pow(a, 1.0 / b));

        System.out.println(calc.calculate("Addition", 5.0, 2.0));
        System.out.println(calc.calculate("Multiplication", 6.0, 3.0));
        System.out.println(calc.calculate("Division", 9.0, 3.0));
        System.out.println(calc.calculate("Subtraction", 6.0, 3.0));
        System.out.println(calc.calculate("Exponentiation", 2.0, 5.0));
        System.out.println(calc.calculate("Extracting", 70.0, 3.0));

    }
}

