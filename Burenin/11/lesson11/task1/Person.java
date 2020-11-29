package lesson11.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<Person> collection = new ArrayList<>();
        collection.add(new Person("Vasya", 20));
        collection.add(new Person("Sveta", 13));
        collection.add(new Person("Petya", 15));
        collection.add(new Person("Katya", 22));
        collection.add(new Person("Vanya", 30));
        collection.add(new Person("Anya", 4));

        Collections.sort(collection, Comparator.comparing(person -> person.getName()));
        System.out.println(collection);

        Collections.sort(collection, Comparator.comparing(person -> person.getAge()));
        System.out.println(collection);
    }
}
