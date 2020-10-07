package ru.localcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input first value");
        String sValue1 = reader.readLine();
        Integer value1 = Integer.parseInt(sValue1);

        System.out.println("Input second value:");
        String sValue2 = reader.readLine();
        Integer value2 = Integer.parseInt(sValue2);

        if (!value1.equals(value2)) {
            Formatter formatter = new Formatter();
            if (value1 > value2) {
                formatter.format("Число %s больше %s", value1, value2);
            } else {
                formatter.format("Число %s меньше %s", value1, value2);
            }
            System.out.println(formatter);
        } else {
            System.out.println("Введные числа равны");
        }

        System.out.println("Сумма чисел = " + (value1 + value2));
    }
}
