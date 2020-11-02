package com.orion.lesson7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ChainedComparator {


    static class Person {
        String name;
        String lastName;

        public Person(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Иван", "Иванов"));
        persons.add(new Person("Андрей", "Иванов"));
        persons.add(new Person("Яков", "Иванов"));
        persons.add(new Person("Михал", "Иванов"));
        persons.add(new Person("Михаил", "Абрикосов"));


        final Comparator<Person> firstNameComparator = Comparator.comparing(person -> person.getName());
        final Comparator<Person> lastNameComparator = Comparator.comparing(person -> person.getLastName());

        final Comparator<Person> chainedComparator = lastNameComparator.thenComparing(firstNameComparator);

        Collections.sort(persons, chainedComparator);
        System.out.println(persons);

    }


}
