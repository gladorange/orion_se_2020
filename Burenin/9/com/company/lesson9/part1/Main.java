package com.company.lesson9.part1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Person vasya = new Person("Vasya", 20, "123456");
        Person petya = new Person("Petya", 15, "qwerty");
        List<Person> collection = new ArrayList<>();
        collection.add(vasya);
        collection.add(petya);

        final String serialize = Serializer.serialize(collection);

        System.out.println(serialize);

        System.out.println(Deserializer.deserialize(serialize, Person.class));
    }
}
