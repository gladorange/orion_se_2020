package com.orion;

public class Main {

    public static void main(String[] args) {
        Person vasya = new Person();
        vasya.name = "Vasya";

        Person petya = new Person();
        petya.name = "Petya";
        Person.count = 2;

        vasya.printHello();

        String greeting = "Привет";
        greeting = "Hello";
        petya.printGreeting(greeting);

    }
}
