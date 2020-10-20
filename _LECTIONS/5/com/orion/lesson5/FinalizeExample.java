package com.orion.lesson5;

public class FinalizeExample {

    public static void main(String[] args) {
        Person p = new Person("Vasya");

        p = null;
        System.gc();

        System.out.println("Конец");
    }
}
