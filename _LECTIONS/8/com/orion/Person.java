package com.orion;

import org.w3c.dom.ls.LSOutput;

public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Person p1 = new Person("Vasya");
        Person p2 = new Person("Masha");
     //   getMaxPerson(p1, p2);


        ComparablePerson pc1 = new ComparablePerson("Vasya",20);
        ComparablePerson pc2 = new ComparablePerson("Masha", 18);
        final ComparablePerson maxPerson = getMaxPerson(pc1, pc2);

        System.out.println(maxPerson.age);


    }


    static public <T extends Person & Comparable> T getMaxPerson(T one, T another) {
        return one.compareTo(another) > 0 ? one : another;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class ComparablePerson extends Person implements Comparable<ComparablePerson> {
    final int age;

    public ComparablePerson(String name,int age) {
        super(name);
        this.age = age;
    }

    @Override
    public int compareTo(ComparablePerson o) {
        return age - o.age;
    }
}
