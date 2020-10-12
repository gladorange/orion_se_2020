package com.src;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.printf("Input a number: %s ",1);
        Integer number_1  = in.nextInt();
        System.out.printf("Input a number: %s ",2);
        Integer number_2  = in.nextInt();

        if (isEqual(number_1, number_2))
            System.out.printf("Числа %s равны \n",number_1);
        else if(compare(number_1, number_2))
            System.out.printf("Число %s больше %s \n",number_1, number_2);
        else
            System.out.printf("Число %s больше %s \n",number_2, number_1);

        System.out.printf("Cумма чисел = %d",number_1 + number_2);
    }


    public static boolean compare(Integer first, Integer second) {
        return first > second? true:false;
    }


    public static boolean isEqual(Integer first, Integer second) {
        return first==second? true:false;
    }
}
