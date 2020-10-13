package com.provalov.lesson1;

import java.io.IOException;
import java.util.Scanner;

public class lesson1 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите первое целое число: ");
            int firstNumber = in.nextInt();
            System.out.println("Введите второе целое число: ");
            int secondNumber = in.nextInt();

            if (firstNumber > secondNumber) {
                System.out.printf("Число %d больше %d\n", firstNumber, secondNumber);
            } else if (firstNumber < secondNumber) {
                System.out.printf("Число %d меньше %d\n", firstNumber, secondNumber);
            } else {
                System.out.printf("Числа равны");
            }
            System.out.printf("Cумма чисел: %d\n", firstNumber + secondNumber);
        }catch(Exception e)
        {
            System.out.printf("Что-то пошло не так...");
        }
    }

}
