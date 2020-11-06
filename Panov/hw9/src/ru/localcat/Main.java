package ru.localcat;

import ru.localcat.hw.examples.Person;
import ru.localcat.hw.xmlserializer.XMLSerializer;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        System.out.println("Start APP!");

        Person pers1;

        pers1 = Person.builder()
                .firstName("Vasya")
                .address("Space 1")
                .age(18)
                .build();

        System.out.println(pers1);

        Collection<Person> persList = new ArrayList<>();
        persList.add(pers1);
        persList.add(Person.builder()
                .firstName("Vitiya")
                .address("World 2")
                .age(48)
                .build()
        );

        String xmlDoc = XMLSerializer.serialize(persList, Person.class);
        System.out.println(xmlDoc);

        System.out.println(XMLSerializer.deserialize(xmlDoc, Person.class));
    }
}
