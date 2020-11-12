package ru.localcat.task2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private Map<String , Operation> operationsList = new HashMap<>();

    public Double calculate(String operationName, Double num1, Double num2) {
        return operationsList.get(operationName).doOperation(num1,num2);
    }

    public void addOperation(String operationName, Operation implementation) {
        operationsList.put(operationName,implementation);
    }
}
