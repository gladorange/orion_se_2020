package com.orion.lesson6;

import java.util.Objects;

public class Pair<T,U> {
    T first;
    U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }


    static class Person {
        String name;

        public Person() {
        }

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
    public static void main(String[] args) {
        Pair<String, Integer> stringToLength = new Pair<>("Слово",5);

        final String first = stringToLength.getFirst();
        final Integer second = stringToLength.getSecond();



        Pair<Person, Integer> personToNameLength = new Pair<>(new Person("Vasya"),5);
        final Person firstVasys = personToNameLength.getFirst();


    }
}
