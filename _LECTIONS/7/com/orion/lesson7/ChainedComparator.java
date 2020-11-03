package com.orion.lesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChainedComparator {


    static class PersonComparable {
        String name;
        String lastName;
        String age;

        public PersonComparable(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
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
        List<PersonComparable> persons = new ArrayList<>();
        persons.add(new PersonComparable("Иван", "Иванов"));
        persons.add(new PersonComparable("Андрей", "Иванов"));
        persons.add(new PersonComparable("Яков", "Иванов"));
        persons.add(new PersonComparable("Михал", "Иванов"));
        persons.add(new PersonComparable("Михаил", "Абрикосов"));


        final PersonComparable max = Collections.max(persons, Comparator.comparing(person -> person.getAge()));


        final Comparator<PersonComparable> chainedComparator =
                Comparator.comparing(PersonComparable::getLastName)
                .thenComparing(PersonComparable::getName);

        Collections.sort(persons, chainedComparator);
        System.out.println(persons);

    }


}
