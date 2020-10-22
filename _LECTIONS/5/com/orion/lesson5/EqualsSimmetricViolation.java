package com.orion.lesson5;

public class EqualsSimmetricViolation {


    public static void main(String[] args) {
        Person vasya = new Person("Vasya");
        PersonWithLastname vasyaPupkin = new PersonWithLastname("Vasya","Pupkin");

        System.out.println(vasya.equals(vasyaPupkin));
        System.out.println(vasyaPupkin.equals(vasya));

    }
}
