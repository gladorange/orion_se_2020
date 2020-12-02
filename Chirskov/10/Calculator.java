import java.util.HashMap;

public class Calculator {

    HashMap<String, Operation> operations = new HashMap<>();

    void calculate(String operationName, Integer number1, Integer number2){
        calculate(operationName, Double.valueOf(number1), Double.valueOf(number2));
    }

    void calculate(String operationName, Double number1, Integer number2){
        calculate(operationName, number1, Double.valueOf(number2));
    }

    void calculate(String operationName, Integer number1, Double number2){
        calculate(operationName, Double.valueOf(number1), number2);
    }

    void calculate(String operationName, Double number1, Double number2){
        final Operation operation = operations.get(operationName);
        if (operation != null) {
            System.out.println(operationName + " " + operation.doOperation(number1, number2));
        }
    }

    void addOperation(String operationName, Operation implementation){
        operations.put(operationName, implementation);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.addOperation("addition", Double::sum);
        calc.addOperation("subtraction", (a,b) -> a-b);
        calc.addOperation("multiplication", (a,b) -> a*b);
        calc.addOperation("division", (a,b) -> {
            if (b == 0) {
                throw new ArithmeticException("Argument divisor is 0");
            }
            return a / b;
        });
        calc.addOperation("pow", (a,b) -> Math.pow(a,b));
        calc.addOperation("getRoot", (a,b) -> Math.exp(Math.log(a)/b));

        calc.calculate("addition",2,3);
        calc.calculate("subtraction",2.3,3);
        calc.calculate("multiplication",2,3.3);
        calc.calculate("division",2,3);
        calc.calculate("pow",2,3);
        calc.calculate("getRoot",4,2.0);

    }
}
