package com.orion.lesson5;

public class UnrechableStatementError {


    public static void main(String[] args) {

        someFunction();


    }


    public static void someFunction() {
        System.out.println(42 / getInt());
    }

    static int getInt() {
        return 0;


     /*   if (true) {
            System.out.println("после return");
        }*/
    }
}
