package com.orion.lesson3;

public class Point {


    public static int DEFAULT_X = 42;

    public Point() {
        System.out.println("Я поинт из другого package'a");
    }

    public static void printHello() {
        System.out.println("Hello");
    }
}
