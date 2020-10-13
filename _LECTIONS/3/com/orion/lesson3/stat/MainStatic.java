package com.orion.lesson3.stat;

public class MainStatic {

    public static void main(String[] args) {
        System.out.println("Самое начало");
        try {
            System.out.println(StaticExample.RANDOM_VALUE);
        } catch (Throwable e) {

        }
        System.out.println(StaticExample.RANDOM_VALUE);
    }
}
