package com.orion;

public class IntPool {


    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a) {
        return sum(a, 42);
    }






    public static void main(String[] args) {

      int a = 2;
        int b = 2;

        if (a == b) {
            System.out.println("Числа равны!");
        }


    }
}
