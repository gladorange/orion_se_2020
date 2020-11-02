package com.orion.lesson7;

import java.util.TreeSet;

import com.orion.lesson7.Comparator.ComparablePerson;

public class TreeSetExample {


    public static void main(String[] args) {
        TreeSet<ComparablePerson> persons = new TreeSet<>(new java.util.Comparator<ComparablePerson>() {
            @Override
            public int compare(ComparablePerson o1, ComparablePerson o2) {
                return o1.age - o2.age;
            }
        });

        persons.add(new ComparablePerson("Петя",20));
        persons.add(new ComparablePerson("Вася",10));
        persons.add(new ComparablePerson("Андрей", 20));
        persons.add(new ComparablePerson("Яна", 10));
        persons.add(new ComparablePerson("Миша", 20));




        System.out.println(persons);
    }
}
