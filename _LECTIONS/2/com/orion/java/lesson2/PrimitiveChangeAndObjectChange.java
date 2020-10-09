package com.orion.java.lesson2;




public class PrimitiveChangeAndObjectChange {

    static class Person {
        String name;
        String age;


        public Person() {
        }

        public Person(Person source) {
            name = source.name;
        }

    }


    public static void main(String[] args) {
        int a = 2;
        int b = a;
        b = 3;

        System.out.println(a);

        Person vasya = new Person();
        vasya.name = "Vasya";

        Person petya = new Person(vasya);
        System.out.println(petya.name);
        petya.name = "Petya";
        System.out.println(petya.name);

        System.out.println("А тем временем Вася...");
        System.out.println(vasya.name);

    }

}
