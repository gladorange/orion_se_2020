package com.orion.lesson7;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public class Comparator {


    static class ComparablePerson implements Comparable<ComparablePerson> {
        public String name;
        public int age;

        @Override
        public int compareTo(ComparablePerson o) {
            return name.compareTo(o.name);
        }

        public ComparablePerson(String name) {
            this.name = name;
        }

        public ComparablePerson(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "ComparablePerson{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ComparablePerson that = (ComparablePerson) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }


    public static void main(String[] args) {


        List<ComparablePerson> persons = new ArrayList<>();
        persons.add(new ComparablePerson("Петя"));
        persons.add(new ComparablePerson("Вася"));
        persons.add(new ComparablePerson("Андрей"));
        persons.add(new ComparablePerson("Яна"));
        persons.add(new ComparablePerson("Миша"));
        persons.add(new ComparablePerson("Миша"));

        Collections.sort(persons);

        System.out.println(persons);


        final LinkedHashSet<ComparablePerson> sortedUniquerPersons = new LinkedHashSet<>(persons);

        System.out.println(sortedUniquerPersons);


    }
}
