package com.orion.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.orion.lesson11.StreamExample.Person;

public class Stream2 {


    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>(Arrays.asList(new Person("Petya"), new Person("Vasya"), new Person("Masha")));


        final boolean hasA = persons.stream().allMatch(person -> person.getName().contains("a"));







        final boolean doesntHaveYo = persons.stream().noneMatch(person -> person.getName().contains("ё"));
        final boolean anyMatch = persons.stream().anyMatch(person -> person.getName().contains("Mas"));
        System.out.println(hasA);
        System.out.println(doesntHaveYo);
        System.out.println(anyMatch);

    }
}
