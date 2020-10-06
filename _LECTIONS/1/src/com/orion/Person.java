package com.orion;

public class Person {
    static int count = 0;
    int age;
    String name;

    void printHello() {
        System.out.println("Hello, I'm " + name);
    }
    void printGreeting(String greeting) {
        System.out.println(greeting + ", I'm " + name);
    }


}
