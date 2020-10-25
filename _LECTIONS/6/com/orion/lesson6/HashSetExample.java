package com.orion.lesson6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.orion.lesson6.Pair.Person;

public class HashSetExample {


    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();

        final Person vasya = new Person("вася");
        final Person vasya2 = new Person("вася");


        persons.add(vasya);
        persons.add(vasya2);


        System.out.println("Есть ли Вася: " + persons.contains(vasya));
        System.out.println(persons);

        vasya.setName("Вася");
        System.out.println("Есть ли Вася: " + persons.contains(vasya));

        persons.add(vasya);
        System.out.println(persons);


    }
}
