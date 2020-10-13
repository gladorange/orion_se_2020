package com.provalov.lesson2;

import java.util.Random;

public class Lesson2 {
    /**
     * method works with numbers consisting of two digits
     * @param checkNumber int argument
     * @return true if the digits of the argument match, otherwise returns false
     */
    public static boolean isMagicNumber(int checkNumber){
        if (Math.abs(checkNumber) < 100 & Math.abs(checkNumber) > 10){
            return checkNumber % 10 == checkNumber / 10;
        }
        return false;
    }

    /**
     * method that defines the sign of a number
     * @param checkNumber int argument
     * @return 1 - if checkNumber is greater than zero, 0 - if checkNumber is zero, -1 - if checkNumber is less than zero
     */
    public static int sign(int checkNumber){
        if (checkNumber > 0){
            return 1;
        }else if(checkNumber == 0) {
            return 0;
        }
        else return -1;
    }

    public static void main(String[] args) {
// Магические числа
        int[] myArray = new int[100];
        for(int i = 0; i < myArray.length; i++){
            myArray[i] = (int)(Math.random() * 200) - 100;
        }
        for(int currentNumber :myArray){
            if (isMagicNumber(currentNumber)){
                System.out.printf("Число %d - магическое\n", currentNumber);
            }
        }

// Влечение противоположностей
        int[] myArray2 = new int[10];
        Random randomGenerator = new Random();
        for(int i = 0; i < myArray2.length; i++){
            myArray2[i] = randomGenerator.nextInt();
            System.out.printf("%d  \n", myArray2[i]);
        }
        for (int i = 0; i < myArray2.length - 1; i++) {
            if (sign(myArray2[i]) * sign(myArray2[i + 1]) < 0) {
                System.out.printf("Числа с противоположными знаками обнаружены: %d %d\n", myArray2[i], myArray2[i+1]);
            }
        }
    }
}
