package com.orion.lesson5;

public class Clone {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person vasya = new Person("Vasya");

        final Person clone = vasya.clone();
        System.out.println(clone.name);
        System.out.println("Всего людей " + Person.count);
    }


}
