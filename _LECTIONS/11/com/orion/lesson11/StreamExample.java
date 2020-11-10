package com.orion.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamExample {


    public static class Person {
        final String name;
        int age;

        public Person(String name) {
            this.name = name;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }


        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(null, new Person("Petya"), new Person("Vasya"), new Person("Masha")));


      //  System.out.println(Collections.max(persons, Comparator.comparing(Person::getName)));

        /*for (Person person : persons) {
            String name = person.name;
            String toLowerCase = name.toLowerCase();
            System.out.println(toLowerCase);
        }*/

        // выводим людей с буквой а в нижнем регистре
        final Stream<String> stringStream = persons
                .stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Person::getName))
                .map(person -> person.name)
                .filter(name -> name.contains("a"))
                .map(String::toLowerCase);

        //persons.clear(); если  удалить все элементы - то стри работать не будет

        stringStream.forEach(System.out::println);
       // stringStream.forEach(System.out::println); два раза стрим использовать нельзя


    }
}
