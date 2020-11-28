package lesson10.task2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String, Operation> operations = new HashMap<>();

    public void addOperation(String nameOperation, Operation implementation) {
        operations.put(nameOperation, implementation);
    }

    public void calculate(String nameOperation, Double a, Double b) {
        final Operation operation = operations.get(nameOperation);
        if (operation == null) {
            System.out.println("Operation " + nameOperation + " not found");
        }
        else {
            System.out.println(nameOperation + " = " + operation.doOperation(a, b));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.addOperation("sum", (a, b) -> a + b);
        calc.addOperation("diff", (a, b) -> a - b);
        calc.addOperation("mult", (a, b) -> a * b);
        calc.addOperation("div", (a, b) -> a / b);
        calc.addOperation("pow", (a, b) -> Math.pow(a, b));
        calc.addOperation("root", (a, b) -> Math.pow(a, 1 / b));

        calc.calculate("sum", 2.0, 3.0);
        calc.calculate("diff", 5.0, 2.0);
        calc.calculate("mult", 5.0, 4.0);
        calc.calculate("div", 25.0, 5.0);
        calc.calculate("pow", 2.0, 3.0);
        calc.calculate("root", 15.0, 3.0);
    }
}
