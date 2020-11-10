package com.orion.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.orion.lesson11.StreamExample.Person;

public class CollectorExample {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Petya",1),
                new Person("Petya",30),
                new Person("Ivan",30),
                new Person("Vasya",20),
                new Person("Masha",18)));

/*
        final Set<Integer> collect = persons.stream()
                .map(p -> p.getName().length())
                .collect(Collectors.toSet());

        System.out.println(collect);*/
/*


        final Map<Person, String> collect = persons.stream().collect(Collectors.toMap(p -> p, Person::getName));
        System.out.println(collect);

*/


        /*System.out.println(persons.stream().collect(Collectors.toMap(p -> p.getName(), p -> p, (person, person2) -> person)));*/

/*
        final Map<String, List<Person>> collect = persons.stream().collect(Collectors.groupingBy(person -> person.getName()));
        System.out.println(collect);*/
/*

        final Map<String, Long> collect = persons.stream().collect(Collectors.groupingBy(person -> person.getName(), Collectors.counting()));
        System.out.println(collect);
*/
/*

        final Map<String, Optional<Person>> collect =
                persons.stream().collect(Collectors.groupingBy(person -> person.getName(),
                Collectors.minBy(Comparator.comparing(Person::getAge))));
        System.out.println(collect);
*/


    }
}
