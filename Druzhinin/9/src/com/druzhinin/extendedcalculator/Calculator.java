package com.druzhinin.extendedcalculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    Map<String, Operation> operations;

    public Calculator() {
        this.operations = new HashMap<>();
    }

    public double calculate(String operationName, Double number1, Double number2) {
        return operations.get(operationName).doOperation(number1, number2);
    }

    public void addOperation(String operationName, Operation implementation) {
        operations.put(operationName, implementation);
    }
}
