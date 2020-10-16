package com.orion.lesson4;

import com.orion.lesson4.Person;

public class StaticClassExample {


    public static void main(String[] args) {
        Person vasya = new Person("Vasya", "Pupkin", new Person.Profession("Программист", "IT"));
        System.out.println(vasya);


    }


}
