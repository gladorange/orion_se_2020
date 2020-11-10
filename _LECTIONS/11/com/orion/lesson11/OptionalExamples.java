package com.orion.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.orion.lesson11.StreamExample.Person;


public class OptionalExamples {


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
      //  List<Person> persons = Arrays.asList(new Person("Vasya"));

        final Optional<Person> max = findMax(persons);


       /* max
                .or(() -> Optional.of(new Person("человек по умолчаниб")));*/


        //final Person person1 = findMax(persons).orElseThrow(() -> new RuntimeException("человек не найден"));

        final String defaultName = findMax(persons)
                .map(p -> p.getName())
                .orElse("Пустое имя");

        System.out.println(defaultName);

        final Person maxOrElse = max.orElseGet(() -> new Person("человек по умолчанию"));
        System.out.println(maxOrElse);


    }


    static Optional<Person> findMax(Collection<Person> persons) {
        if (persons.isEmpty()) {
            return Optional.empty();
        }


        return Optional.ofNullable(Collections.max(persons, Comparator.comparing(Person::getName)));
    }


}
